package uz.wiut.keepme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.wiut.keepme.domain.User;
import uz.wiut.keepme.domain.UserSession;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, String> {
}
