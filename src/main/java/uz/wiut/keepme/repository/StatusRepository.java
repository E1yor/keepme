package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Status;
import uz.wiut.keepme.domain.Unit;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
