package uz.wiut.keepme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    Integer
            id;
    String
            name,
            phone,
            email,
            address,
            notes;
    @Temporal(TemporalType.TIMESTAMP)
    Date
        created,
        updated;
    Integer
        state;
}
