package lk.ijse.possystemspringbackend.controller;

import jakarta.validation.Valid;
import lk.ijse.possystemspringbackend.dto.impl.OrderDTO;
import lk.ijse.possystemspringbackend.exception.DataPersistFailedException;
import lk.ijse.possystemspringbackend.service.PlaceOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*" ,allowedHeaders ="*" )
@RestController
@RequestMapping(value = "/api/v1/placeOrder")
public class PlaceOrderController {
    @Autowired
    private PlaceOrderService placeOrderService;
    static Logger logger = LoggerFactory.getLogger(PlaceOrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void > createItem(@Valid @RequestBody OrderDTO orderDTO  ){
        try {
            placeOrderService.saveOrder(orderDTO);
            logger.info("Order saved : " + orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/allorders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return placeOrderService.getAllOrder();
    }
}
