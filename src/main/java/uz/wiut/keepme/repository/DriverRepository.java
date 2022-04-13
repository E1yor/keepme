package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Driver;
import uz.wiut.keepme.domain.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    List<Driver> findAllByStateNot(Integer state);
    Optional<Driver> findByIdAndStateNot(Integer id, Integer state);
}
