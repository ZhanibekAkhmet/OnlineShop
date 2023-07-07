package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Notebooks.Notebook;

import java.util.List;

@Repository
@Transactional
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
//    List<Notebook>findAllByProcessor_Id();
}
