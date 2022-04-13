package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import uz.wiut.keepme.domain.Status;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.StatusDto;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper extends MapperInterface<StatusDto, Status>{

    @Override
    Status toEntity(StatusDto dto);

    @Override
    StatusDto toDto(Status entity);

    @Override
    List<Status> toEntity(List<StatusDto> dtoList);

    @Override
    List<StatusDto> toDto(List<Status> entityList);

}
