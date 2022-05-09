package uz.wiut.keepme.service;

import org.springframework.stereotype.Service;
import uz.wiut.keepme.dto.LoadDto;
import uz.wiut.keepme.dto.ResponseDto;
import uz.wiut.keepme.dto.UnitDto;

@Service
public interface LoadService {
    ResponseDto getAll(String search);
    ResponseDto getById(Integer id);
    ResponseDto add(LoadDto dto);
    ResponseDto edit(LoadDto dto);
    ResponseDto remove(Integer id);
}