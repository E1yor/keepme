package uz.wiut.keepme.service;

import org.springframework.stereotype.Service;
import uz.wiut.keepme.dto.ResponseDto;

@Service
public interface LoadService {
    ResponseDto getAll();
    ResponseDto getById(Integer id);
}