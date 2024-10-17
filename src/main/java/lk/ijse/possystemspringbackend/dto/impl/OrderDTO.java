package lk.ijse.possystemspringbackend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import lk.ijse.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO {
    private String orderId;
    private String date;
    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;
    private List<ItemDTO> itemDtoList;
    private double total;
    private String discount;
    private double subTotal;
    private double cash;
    private double balance;
}
