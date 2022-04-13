package uz.wiut.keepme.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LOAD")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Load {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "broker_name")
    private String brokerName;

    @Column(name = "origin")
    private String origin;

    @Column(name = "pickup_time")
    private Date pickupTime;

    @Column(name = "delivery_time")
    private Date deliveryTime;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "notes")
    private String notes;

}