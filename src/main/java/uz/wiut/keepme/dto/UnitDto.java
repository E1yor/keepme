package uz.wiut.keepme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {
    Integer
            id;
    String
            brand,
            model,
            fuelType;
    Integer
            year;
    String
            licenseNumber,
            eldNumber,
            notes;
    @Temporal(TemporalType.TIMESTAMP)
    Date
            created,
            updated;
    Integer
            state;
}
