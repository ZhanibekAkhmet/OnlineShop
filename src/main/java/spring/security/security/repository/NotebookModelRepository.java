package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Notebooks.NotebookModel;

@Repository
@Transactional
public interface NotebookModelRepository extends JpaRepository<NotebookModel, Long> {
}