package lk.ijse.possystemspringbackend.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.possystemspringbackend.entity.SuperEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> order;
}
