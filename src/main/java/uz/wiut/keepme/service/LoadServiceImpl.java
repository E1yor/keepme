package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.dto.DriverDto;
import uz.wiut.keepme.dto.LoadDto;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.mapper.DriverMapper;
import uz.wiut.keepme.mapper.LoadMapper;
import uz.wiut.keepme.repository.DriverRepository;
import uz.wiut.keepme.repository.LoadRepository;

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
            List<LoadDto> list = loadRepository.findAll()
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

        }

        return response;
    }

    @Override
    public ResponseDto getById(Integer id) {
        ResponseDto response = null;

        try {

            Optional<LoadDto> single = loadRepository.findById(id).map(loadMapper::toDto);

            response = new ResponseDto();
            response.setSuccess(Boolean.TRUE);
            response.setData(single);

        } catch (Exception ex){
            response = new ResponseDto();
            response.setSuccess(Boolean.FALSE);

            NamingDto message = new NamingDto();
            message.setName_en(ex.getMessage());
        }

        return response;
    }

}
