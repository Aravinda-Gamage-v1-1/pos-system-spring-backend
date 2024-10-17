package lk.ijse.possystemspringbackend.util;

import lk.ijse.possystemspringbackend.dto.impl.CustomerDTO;
import lk.ijse.possystemspringbackend.dto.impl.ItemDTO;
import lk.ijse.possystemspringbackend.dto.impl.OrderDTO;
import lk.ijse.possystemspringbackend.dto.impl.OrderDetailDTO;
import lk.ijse.possystemspringbackend.entity.impl.CustomerEntity;
import lk.ijse.possystemspringbackend.entity.impl.ItemEntity;
import lk.ijse.possystemspringbackend.entity.impl.OrderDetailEntity;
import lk.ijse.possystemspringbackend.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO convertToCustomerDTO(CustomerEntity customer){return modelMapper.map(customer, CustomerDTO.class);}
    public CustomerEntity convertToCustomerEntity(CustomerDTO dto) {return modelMapper.map(dto, CustomerEntity.class);}
    public List<CustomerDTO> convertToCustomerDTO(List<CustomerEntity> customer){return modelMapper.map(customer,new TypeToken<List<CustomerDTO>>() {}.getType());}

    public ItemDTO convertToItemDTO(ItemEntity item){
        return modelMapper.map(item, ItemDTO.class);
    }
    public ItemEntity convertToItemEntity(ItemDTO dto) {
        return modelMapper.map(dto, ItemEntity.class);
    }
    public List<ItemDTO> convertToItemDTO(List<ItemEntity> items){return modelMapper.map(items,new TypeToken<List<ItemDTO>>() {}.getType());}

    public OrderEntity convertToOrderEntity(OrderDTO dto) {return modelMapper.map(dto, OrderEntity.class);}
    public List<OrderDTO> convertToOrderDTO(List<OrderEntity> ordersEntity){return modelMapper.map(ordersEntity,new TypeToken<List<OrderDTO>>() {}.getType());}

    public OrderDetailEntity convertToOrderDetailEntity(OrderDetailDTO dto) {return modelMapper.map(dto, OrderDetailEntity.class);}
}
