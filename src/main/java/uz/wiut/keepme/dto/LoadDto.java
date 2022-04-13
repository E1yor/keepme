package uz.wiut.keepme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadDto {
    private Integer id;
    private String brokerName;
    private String origin;
    private Date pickupTime;
    private Date deliveryTime;
    private Double rate;
    private String notes;
}
