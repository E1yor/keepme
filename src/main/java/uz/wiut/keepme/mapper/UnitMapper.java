package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnitMapper extends MapperInterface<UnitDto, Unit>{

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    Unit toEntity(UnitDto dto);

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    UnitDto toDto(Unit entity);

    @Override
    List<Unit> toEntity(List<UnitDto> dtoList);

    @Override
    List<UnitDto> toDto(List<Unit> entityList);

}
