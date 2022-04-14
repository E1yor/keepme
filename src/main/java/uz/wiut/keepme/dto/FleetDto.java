package uz.wiut.keepme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FleetDto {
    Integer
            id,
            driverId,
            loadId,
            unitId,
            statusId;
    String
            location;
    @Temporal(TemporalType.TIMESTAMP)
    Date
            eta,
            readyTime,
            created,
            updated;
    String
            notes;
    Integer
            state;
}
