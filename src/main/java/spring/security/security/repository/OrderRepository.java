package spring.security.security.repository;

import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import spring.security.security.model.Order;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUserId(Long id);
    List<Order> findAllByStatusOrderByCreatedDate(int statusId);
    List<Order> findByUserEmailIgnoreCaseOrUserFullNameIgnoreCaseOrUserPhoneIgnoreCase(String email, String fullName, String phone);
}
