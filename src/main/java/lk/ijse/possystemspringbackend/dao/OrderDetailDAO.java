package lk.ijse.possystemspringbackend.dao;

import lk.ijse.possystemspringbackend.entity.impl.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetailEntity, String> {
}
