package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.wiut.keepme.domain.Load;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.LoadDto;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoadMapper extends MapperInterface<LoadDto, Load>{

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    Load toEntity(LoadDto dto);

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    LoadDto toDto(Load entity);

    @Override
    List<Load> toEntity(List<LoadDto> dtoList);

    @Override
    List<LoadDto> toDto(List<Load> entityList);

}
