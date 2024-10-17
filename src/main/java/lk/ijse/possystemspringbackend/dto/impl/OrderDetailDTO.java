package lk.ijse.possystemspringbackend.dto.impl;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lk.ijse.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements SuperDTO {
    private String orderId;
    @Min(value = 1, message = "Quantity must be at least 1")
    private  int order_qty;
    @NotBlank(message = "Item code cannot be blank")
    private String itemCode;
    @Positive(message = "Unit price must be greater than zero")
    private double unitPrice;
}
