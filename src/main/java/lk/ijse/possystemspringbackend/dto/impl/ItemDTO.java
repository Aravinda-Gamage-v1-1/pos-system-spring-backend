package lk.ijse.possystemspringbackend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lk.ijse.possystemspringbackend.customObj.ItemResponse;
import lk.ijse.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
    private String code;
    @NotBlank(message = "Description cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Description must contain only letters")
    private String description;
    private int quantity;
    private double price;
}
