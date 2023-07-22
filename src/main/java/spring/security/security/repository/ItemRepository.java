package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.security.model.Item;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoriesId(Long categoryId);
    List<Item> findByCategoriesIdOrderByPrice(Long categoryId);
    List<Item> findByCategoriesIdOrderByPriceDesc(Long categoryId);
    List<Item> findAllByModel_Id(Long modelId);
    List<Item> findByModel_IdOrderByPrice(Long id);
    List<Item> findByModel_IdOrderByPriceDesc(Long id);
 }
