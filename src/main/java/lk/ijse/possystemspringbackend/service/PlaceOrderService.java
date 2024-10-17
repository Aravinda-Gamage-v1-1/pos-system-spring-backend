package lk.ijse.possystemspringbackend.service;

import lk.ijse.possystemspringbackend.dto.impl.OrderDTO;

import java.util.List;

public interface PlaceOrderService {
    void saveOrder(OrderDTO orderDto);
    List<OrderDTO> getAllOrder();
}
