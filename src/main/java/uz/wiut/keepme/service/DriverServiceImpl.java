package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.config.Constants;
import uz.wiut.keepme.domain.Driver;
import uz.wiut.keepme.dto.DriverDto;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.StatusDto;
import uz.wiut.keepme.mapper.DriverMapper;
import uz.wiut.keepme.mapper.StatusMapper;
import uz.wiut.keepme.repository.DriverRepository;
import uz.wiut.keepme.repository.StatusRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    DriverMapper driverMapper;

    @Override
    public ResponseDto getAll() {
        ResponseDto response = null;

        try {
            List<DriverDto> list = driverRepository.findAllByStateNot(Constants.STATUS_DELETED)
                                            .stream().map(driverMapper::toDto)
                                            .collect(Collectors.toList());
            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(list);

        } catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());

            response.setMessage(message);
        }

        return response;
    }

    @Override
    public ResponseDto getById(Integer id) {
        ResponseDto response = null;

        try {

            Optional<DriverDto> single = driverRepository.findByIdAndStateNot(id, Constants.STATUS_DELETED).map(driverMapper::toDto);

            if(single != null){
                response = new ResponseDto();
                response.setSuccess(Boolean.TRUE);
                response.setData(single.get());
            }else{
                response = new ResponseDto();
                response.setSuccess(Boolean.FALSE);

                NamingDto message = new NamingDto();
                message.setName_en("Cannot find the entity by id");

                response.setMessage(message);
            }

        } catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());

            response.setMessage(message);
        }

        return response;
    }

    @Override
    public ResponseDto add(DriverDto dto) {
        ResponseDto response = null;

        try {
            dto.setCreated(new Date());
            dto.setState(Constants.STATUS_INSERTED);

            Driver driver = driverMapper.toEntity(dto);
            driver = driverRepository.save(driver);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(driverMapper.toDto(driver));

        } catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());

            response.setMessage(message);
        }

        return response;
    }

    @Override
    public ResponseDto edit(DriverDto dto) {
        ResponseDto response = null;

        try {

            Optional<DriverDto> driverDto = driverRepository
                    .findById(dto.getId())
                    .map(
                            existingDrivers -> {
                                driverMapper.partialUpdate(existingDrivers, dto);
                                existingDrivers.setUpdated(new Date());
                                return existingDrivers;
                            }
                    )
                    .map(driverRepository::save)
                    .map(driverMapper::toDto);


            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(driverDto.get());

        }catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());

            response.setMessage(message);
        }

        return response;
    }

    @Override
    public ResponseDto remove(Integer id) {
        ResponseDto response = null;

        try {

            Driver driver = driverRepository.getOne(id);

            driver.setState(Constants.STATUS_DELETED);
            driver.setUpdated(new Date());

            driver = driverRepository.save(driver);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(driverMapper.toDto(driver));

        }catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());

            response.setMessage(message);
        }

        return response;
    }

}
