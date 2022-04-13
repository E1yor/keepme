package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.wiut.keepme.domain.Driver;
import uz.wiut.keepme.domain.Status;
import uz.wiut.keepme.dto.DriverDto;
import uz.wiut.keepme.dto.StatusDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper extends MapperInterface<DriverDto, Driver>{

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    Driver toEntity(DriverDto dto);

    @Override
    @Mapping(source = "created", target = "created")
    @Mapping(source = "updated", target = "updated")
    @Mapping(source = "state", target = "state")
    DriverDto toDto(Driver entity);

    @Override
    List<Driver> toEntity(List<DriverDto> dtoList);

    @Override
    List<DriverDto> toDto(List<Driver> entityList);

}
