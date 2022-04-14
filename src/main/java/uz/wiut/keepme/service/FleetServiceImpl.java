package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.config.Constants;
import uz.wiut.keepme.domain.Fleet;
import uz.wiut.keepme.domain.IFleet;
import uz.wiut.keepme.dto.*;
import uz.wiut.keepme.mapper.FleetMapper;
import uz.wiut.keepme.repository.FleetRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FleetServiceImpl implements FleetService {

    @Autowired
    FleetRepository fleetRepository;
    @Autowired
    FleetMapper fleetMapper;

    @Override
    public ResponseDto getAll() {
        ResponseDto response = null;

        try {
            List<IFleet> list = fleetRepository.findAllByStateNot(Constants.STATUS_DELETED);
//                    .stream().map(fleetMapper::toDto)
//                    .collect(Collectors.toList());
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

            Optional<IFleet> single = fleetRepository.findByIdAndStateNot(id, Constants.STATUS_DELETED);
//                    .map(fleetMapper::toDto);

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
    public ResponseDto add(FleetDto dto) {
        ResponseDto response = null;

        try {
            dto.setCreated(new Date());
            dto.setState(Constants.STATUS_INSERTED);

            Fleet fleet = fleetMapper.toEntity(dto);
            fleet = fleetRepository.save(fleet);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(fleetMapper.toDto(fleet));

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
    public ResponseDto edit(FleetDto dto) {
        ResponseDto response = null;

        try {

            Optional<FleetDto> FleetDto = fleetRepository
                    .findById(dto.getId())
                    .map(
                            existingFleets -> {
                                fleetMapper.partialUpdate(existingFleets, dto);
                                existingFleets.setUpdated(new Date());
                                return existingFleets;
                            }
                    )
                    .map(fleetRepository::save)
                    .map(fleetMapper::toDto);


            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(FleetDto.get());

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

            Fleet fleet = fleetRepository.getOne(id);

            fleet.setState(Constants.STATUS_DELETED);
            fleet.setUpdated(new Date());

            fleet = fleetRepository.save(fleet);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(fleetMapper.toDto(fleet));

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
