package uz.wiut.keepme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FleetDto {
    private Integer id;
    private Integer driverId;
    private Integer loadId;
    private Integer unitId;
    private Integer statusId;
    private String location;
    private Date eta;
    private Date readyTime;
    private String notes;
}
