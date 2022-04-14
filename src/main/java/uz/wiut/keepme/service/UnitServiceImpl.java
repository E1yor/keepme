package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.config.Constants;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.*;
import uz.wiut.keepme.mapper.UnitMapper;
import uz.wiut.keepme.repository.UnitRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitRepository unitRepository;
    @Autowired
    UnitMapper unitMapper;

    @Override
    public ResponseDto getAll() {
        ResponseDto response = null;

        try {
            List<UnitDto> list = unitRepository.findAllByStateNot(Constants.STATUS_DELETED)
                    .stream().map(unitMapper::toDto)
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

            Optional<UnitDto> single = unitRepository.findByIdAndStateNot(id, Constants.STATUS_DELETED).map(unitMapper::toDto);

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
    public ResponseDto add(UnitDto dto) {
        ResponseDto response = null;

        try {
            dto.setCreated(new Date());
            dto.setState(Constants.STATUS_INSERTED);

            Unit unit = unitMapper.toEntity(dto);
            unit = unitRepository.save(unit);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(unitMapper.toDto(unit));

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
    public ResponseDto edit(UnitDto dto) {
        ResponseDto response = null;

        try {

            Optional<UnitDto> unitDto = unitRepository
                    .findById(dto.getId())
                    .map(
                            existingUnits -> {
                                unitMapper.partialUpdate(existingUnits, dto);
                                existingUnits.setUpdated(new Date());
                                return existingUnits;
                            }
                    )
                    .map(unitRepository::save)
                    .map(unitMapper::toDto);


            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(unitDto.get());

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

            Unit unit = unitRepository.getOne(id);

            unit.setState(Constants.STATUS_DELETED);
            unit.setUpdated(new Date());

            unit = unitRepository.save(unit);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(unitMapper.toDto(unit));

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
