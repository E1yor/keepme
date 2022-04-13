package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Load;
import uz.wiut.keepme.domain.Unit;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {
}
