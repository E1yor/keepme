package uz.wiut.keepme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {
    private Integer id;
    private String brand;
    private String model;
    private String fuelType;
    private Integer year;
    private String licenseNumber;
    private String eldNumber;
    private String notes;
}
