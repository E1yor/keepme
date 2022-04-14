package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Driver;
import uz.wiut.keepme.domain.Unit;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    List<Unit> findAllByStateNot(Integer state);
    Optional<Unit> findByIdAndStateNot(Integer id, Integer state);
}
