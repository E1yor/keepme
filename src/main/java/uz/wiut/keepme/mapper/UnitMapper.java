package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnitMapper extends MapperInterface<UnitDto, Unit>{

    @Override
    Unit toEntity(UnitDto dto);

    @Override
    UnitDto toDto(Unit entity);

    @Override
    List<Unit> toEntity(List<UnitDto> dtoList);

    @Override
    List<UnitDto> toDto(List<Unit> entityList);

}
