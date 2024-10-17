package lk.ijse.possystemspringbackend.dao;

import lk.ijse.possystemspringbackend.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {
}
