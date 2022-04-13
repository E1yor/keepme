package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import uz.wiut.keepme.domain.Fleet;
import uz.wiut.keepme.dto.FleetDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FleetMapper extends MapperInterface<FleetDto, Fleet>{

    @Override
    Fleet toEntity(FleetDto dto);

    @Override
    FleetDto toDto(Fleet entity);

    @Override
    List<Fleet> toEntity(List<FleetDto> dtoList);

    @Override
    List<FleetDto> toDto(List<Fleet> entityList);

}
