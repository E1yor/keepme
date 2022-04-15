package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Fleet;
import uz.wiut.keepme.domain.IFleet;
import uz.wiut.keepme.domain.Unit;

import java.util.List;
import java.util.Optional;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Integer> {
    @Query(
        value = "select  " +
                "    t1.id, " +
                "    t1.driver_id, " +
                "    t2.name as driver_name, " +
                "    t1.load_id, " +
                "    concat(t3.broker_name, ' - ', t3.origin, ' - ', t3.pickup_time) as load_name, " +
                "    t1.unit_id, " +
                "    concat(t4.brand, ' - ', t4.model, ' - ', t4.license_number) as unit_name, " +
                "    t1.status_id, " +
                "    t5.name as status_name, " +
                "    t1.location, t1.eta, t1.ready_time, TO_CHAR(t1.notes) as notes, t1.created, t1.updated " +
                "from fleet t1 " +
                "left join driver t2 on t1.driver_id = t2.id " +
                "left join load t3 on t1.load_id = t3.id " +
                "left join unit t4 on t1.unit_id = t4.id " +
                "left join status t5 on t1.status_id = t5.id " +
                "where t1.state <> :state",
        nativeQuery = true
    )
    List<IFleet> findAllByStateNot(@Param("state") Integer state);

    @Query(
            value = "select  " +
                    "    t1.id, " +
                    "    t1.driver_id, " +
                    "    t2.name as driver_name, " +
                    "    t1.load_id, " +
                    "    concat(t3.broker_name, ' - ', t3.origin, ' - ', t3.pickup_time) as load_name, " +
                    "    t1.unit_id, " +
                    "    concat(t4.brand, ' - ', t4.model, ' - ', t4.license_number) as unit_name, " +
                    "    t1.status_id, " +
                    "    t5.name as status_name, " +
                    "    t1.location, t1.eta, t1.ready_time, TO_CHAR(t1.notes) as notes, t1.created, t1.updated " +
                    "from fleet t1 " +
                    "left join driver t2 on t1.driver_id = t2.id " +
                    "left join load t3 on t1.load_id = t3.id " +
                    "left join unit t4 on t1.unit_id = t4.id " +
                    "left join status t5 on t1.status_id = t5.id " +
                    "where t1.state <> :state and t1.id = :id",
            nativeQuery = true
    )
    Optional<IFleet> findByIdAndStateNot(@Param("id") Integer id, @Param("state") Integer state);
}
