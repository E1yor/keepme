package uz.wiut.keepme.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UNIT")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Unit {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "year")
    private Integer year;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "eld_number")
    private String eldNumber;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Column(name = "state")
    private Integer state;

}