package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import uz.wiut.keepme.domain.Load;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.LoadDto;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoadMapper extends MapperInterface<LoadDto, Load>{

    @Override
    Load toEntity(LoadDto dto);

    @Override
    LoadDto toDto(Load entity);

    @Override
    List<Load> toEntity(List<LoadDto> dtoList);

    @Override
    List<LoadDto> toDto(List<Load> entityList);

}
