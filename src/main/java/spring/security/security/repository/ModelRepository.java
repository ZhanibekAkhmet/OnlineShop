package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Laptop.Model;

@Repository
@Transactional
public interface ModelRepository extends JpaRepository<Model, Long> {
}
