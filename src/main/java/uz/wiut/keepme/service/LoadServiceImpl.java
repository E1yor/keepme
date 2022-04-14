package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.config.Constants;
import uz.wiut.keepme.domain.Load;
import uz.wiut.keepme.dto.*;
import uz.wiut.keepme.mapper.LoadMapper;
import uz.wiut.keepme.repository.LoadRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoadServiceImpl implements LoadService {

    @Autowired
    LoadRepository loadRepository;
    @Autowired
    LoadMapper loadMapper;


    @Override
    public ResponseDto getAll() {
        ResponseDto response = null;

        try {
            List<LoadDto> list = loadRepository.findAllByStateNot(Constants.STATUS_DELETED)
                    .stream().map(loadMapper::toDto)
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

            Optional<LoadDto> single = loadRepository.findByIdAndStateNot(id, Constants.STATUS_DELETED).map(loadMapper::toDto);

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
    public ResponseDto add(LoadDto dto) {
        ResponseDto response = null;

        try {
            dto.setCreated(new Date());
            dto.setState(Constants.STATUS_INSERTED);

            Load load = loadMapper.toEntity(dto);
            load = loadRepository.save(load);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(loadMapper.toDto(load));

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
    public ResponseDto edit(LoadDto dto) {
        ResponseDto response = null;

        try {

            Optional<LoadDto> loadDto = loadRepository
                    .findById(dto.getId())
                    .map(
                            existingloads -> {
                                loadMapper.partialUpdate(existingloads, dto);
                                existingloads.setUpdated(new Date());
                                return existingloads;
                            }
                    )
                    .map(loadRepository::save)
                    .map(loadMapper::toDto);


            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(loadDto.get());

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

            Load load = loadRepository.getOne(id);

            load.setState(Constants.STATUS_DELETED);
            load.setUpdated(new Date());

            load = loadRepository.save(load);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(loadMapper.toDto(load));

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
