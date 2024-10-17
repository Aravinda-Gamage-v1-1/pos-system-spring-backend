package lk.ijse.possystemspringbackend.dao;

import lk.ijse.possystemspringbackend.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<ItemEntity, String> {
}
