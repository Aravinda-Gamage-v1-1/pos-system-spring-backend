package lk.ijse.possystemspringbackend.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class OrderDetailPrimaryKey implements Serializable {
    private String orderId;
    private String code;
}
