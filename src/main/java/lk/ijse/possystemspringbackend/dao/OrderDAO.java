package lk.ijse.possystemspringbackend.dao;

import lk.ijse.possystemspringbackend.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity, String> {
}
