package lk.ijse.possystemspringbackend.service;

import lk.ijse.possystemspringbackend.customObj.ItemResponse;
import lk.ijse.possystemspringbackend.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String code,ItemDTO itemDTO);
    void deleteItem(String code);
    List<ItemDTO> getAllItem();
    ItemResponse getSelectItem(String code);
}
