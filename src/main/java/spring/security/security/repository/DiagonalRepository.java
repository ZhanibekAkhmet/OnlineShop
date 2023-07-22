package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Diagonal;
import spring.security.security.model.Memory;

@Repository
@Transactional
public interface DiagonalRepository extends JpaRepository<Diagonal, Long> {
}
