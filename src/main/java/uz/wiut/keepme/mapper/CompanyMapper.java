package uz.wiut.keepme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.wiut.keepme.domain.Company;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.dto.CompanyDto;
import uz.wiut.keepme.dto.UnitDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends MapperInterface<CompanyDto, Company>{

    @Override
    Company toEntity(CompanyDto dto);

    @Override
    CompanyDto toDto(Company entity);

    @Override
    List<Company> toEntity(List<CompanyDto> dtoList);

    @Override
    List<CompanyDto> toDto(List<Company> entityList);

}
