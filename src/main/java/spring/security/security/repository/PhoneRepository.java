package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Notebooks.Notebook;
import spring.security.security.model.Phone.Phone;

@Repository
@Transactional
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
