package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.wiut.keepme.domain.Fleet;
import uz.wiut.keepme.dto.FleetDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FleetMapper extends MapperInterface<FleetDto, Fleet>{

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    Fleet toEntity(FleetDto dto);

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    FleetDto toDto(Fleet entity);

    @Override
    List<Fleet> toEntity(List<FleetDto> dtoList);

    @Override
    List<FleetDto> toDto(List<Fleet> entityList);

}
