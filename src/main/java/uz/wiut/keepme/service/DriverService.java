package uz.wiut.keepme.service;

import org.springframework.stereotype.Service;
import uz.wiut.keepme.dto.DriverDto;
import uz.wiut.keepme.dto.ResponseDto;

@Service
public interface DriverService {
    ResponseDto getAll();
    ResponseDto getById(Integer id);
    ResponseDto add(DriverDto dto);
    ResponseDto edit(DriverDto dto);
    ResponseDto remove(Integer id);
}