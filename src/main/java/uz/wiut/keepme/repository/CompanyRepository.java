package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.Company;
import uz.wiut.keepme.domain.Unit;
import uz.wiut.keepme.domain.User;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByIdAndStateNot(Integer id, Integer state);
}
