package uz.wiut.keepme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.NamingDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.StatusDto;
import uz.wiut.keepme.dto.UnitDto;
import uz.wiut.keepme.mapper.UnitMapper;
import uz.wiut.keepme.repository.UnitRepository;

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
            List<UnitDto> list = unitRepository.findAll()
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

        }

        return response;
    }

    @Override
    public ResponseDto getById(Integer id) {
        ResponseDto response = null;

        try {

            Optional<UnitDto> single = unitRepository.findById(id).map(unitMapper::toDto);

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

    public UnitDto save(UnitDto dto) throws Exception {
        try {
            Unit model = unitMapper.toEntity(dto);
            dto = unitMapper.toDto(unitRepository.save(model));

            return dto;
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
