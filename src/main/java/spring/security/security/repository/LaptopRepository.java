package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Laptop.Laptop;

@Repository
@Transactional
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Laptop findByItem_Id(Long id);
}
