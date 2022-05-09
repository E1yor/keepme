package uz.wiut.keepme.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMPANY")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Company {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MC")
    private String mc;

    @Column(name = "US_DOT")
    private String usDot;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "MAIL_ADDRESS")
    private String mailAddress;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Column(name = "state")
    private Integer state;

}
