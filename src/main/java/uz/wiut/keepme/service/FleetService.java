package uz.wiut.keepme.service;

import org.springframework.stereotype.Service;
import uz.wiut.keepme.dto.FleetDto;
import uz.wiut.keepme.dto.ResponseDto;

@Service
public interface FleetService {
    ResponseDto getAll();
    ResponseDto getById(Integer id);
    ResponseDto add(FleetDto dto);
    ResponseDto edit(FleetDto dto);
    ResponseDto remove(Integer id);
}