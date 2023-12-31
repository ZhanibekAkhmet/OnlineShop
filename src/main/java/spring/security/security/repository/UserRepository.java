package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);
//    User findByFullName(String fullName);
}
