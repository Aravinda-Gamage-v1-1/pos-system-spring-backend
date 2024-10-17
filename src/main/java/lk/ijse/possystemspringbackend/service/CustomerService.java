package lk.ijse.possystemspringbackend.service;

import lk.ijse.possystemspringbackend.customObj.CustomerResponse;
import lk.ijse.possystemspringbackend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String cusId,CustomerDTO customerDTO);
    void deleteCustomer(String cusId);
    List<CustomerDTO> getAllCustomer();
    CustomerResponse getSelectCustomer(String cusId);
}
