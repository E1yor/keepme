package uz.wiut.keepme.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

public interface IFleet {
    Integer getid();
    Integer getdriver_id();
    String getdriver_name();
    Integer getload_id();
    String getload_name();
    Integer getunit_id();
    String getunit_name();
    Integer getstatus_id();
    String getstatus_name();
    String getlocation();

    @Lob
    String getNotes();

    @Temporal(TemporalType.TIMESTAMP)
    Date geteta();
    @Temporal(TemporalType.TIMESTAMP)
    Date getready_time();
    @Temporal(TemporalType.TIMESTAMP)
    Date getcreated();
    @Temporal(TemporalType.TIMESTAMP)
    Date getupdated();
}