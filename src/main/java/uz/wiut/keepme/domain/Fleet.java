package uz.wiut.keepme.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FLEET")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fleet {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "load_id")
    private Integer loadId;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "location")
    private String location;

    @Column(name = "eta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eta;

    @Column(name = "ready_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readyTime;

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