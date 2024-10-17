package lk.ijse.possystemspringbackend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lk.ijse.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@NotBlank
@Data
public class CustomerDTO implements SuperDTO {
    private String id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "First name must contain only alphabets and be 2-30 characters long")

    private String  name;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address;

    private double salary;
}
