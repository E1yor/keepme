package uz.wiut.keepme.service;

import org.springframework.stereotype.Service;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Service
public interface UnitService {
    ResponseDto getAll();
    ResponseDto getById(Integer id);
    UnitDto save(UnitDto dto) throws Exception;
}