package lk.ijse.possystemspringbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemspringbackend.customObj.ItemResponse;
import lk.ijse.possystemspringbackend.customObj.impl.ItemErrorResponse;
import lk.ijse.possystemspringbackend.dao.ItemDAO;
import lk.ijse.possystemspringbackend.dto.impl.ItemDTO;
import lk.ijse.possystemspringbackend.entity.impl.ItemEntity;
import lk.ijse.possystemspringbackend.exception.DataPersistFailedException;
import lk.ijse.possystemspringbackend.exception.ItemNotFoundException;
import lk.ijse.possystemspringbackend.service.ItemService;
import lk.ijse.possystemspringbackend.util.AppUtil;
import lk.ijse.possystemspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setCode(AppUtil.createItemCode());
        ItemEntity Itemsave= itemDAO.save(mapping.convertToItemEntity(itemDTO));
        if(Itemsave == null && Itemsave.getCode() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateItem(String code, ItemDTO itemDTO) {
        Optional<ItemEntity> updateById=itemDAO.findById(code);
        if(!updateById.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            updateById.get().setDescription(itemDTO.getDescription());
            updateById.get().setPrice(itemDTO.getPrice());
            updateById.get().setQuantity(itemDTO.getQuantity());
        }
    }

    @Override
    public void deleteItem(String code) {
        Optional<ItemEntity> selectedItemCode = itemDAO.findById(code);
        if(selectedItemCode.isPresent()){
            itemDAO.deleteById(code);
        }else {
            throw new ItemNotFoundException("Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return  mapping.convertToItemDTO(itemDAO.findAll());

    }

    @Override
    public ItemResponse getSelectItem(String code) {
        if(itemDAO.existsById(code)){
            Optional<ItemEntity> itemEntityByItemCode = itemDAO.findById(code);
            return mapping.convertToItemDTO(itemEntityByItemCode.get());
        }else {
            return new ItemErrorResponse(0, "Item not found");
        }
    }
}
