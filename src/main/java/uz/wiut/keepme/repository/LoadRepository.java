package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Load;
import uz.wiut.keepme.domain.Unit;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {
    List<Load> findAllByReferenceNumberContainingAndStateNot(String search, Integer state);
    List<Load> findAllByStateNot(Integer state);
    Optional<Load> findByIdAndStateNot(Integer id, Integer state);
}
