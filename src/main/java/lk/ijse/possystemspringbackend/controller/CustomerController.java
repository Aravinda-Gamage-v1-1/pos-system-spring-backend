package lk.ijse.possystemspringbackend.controller;

import jakarta.validation.Valid;
import lk.ijse.possystemspringbackend.customObj.CustomerResponse;
import lk.ijse.possystemspringbackend.dto.impl.CustomerDTO;
import lk.ijse.possystemspringbackend.exception.CustomerNotFound;
import lk.ijse.possystemspringbackend.exception.DataPersistFailedException;
import lk.ijse.possystemspringbackend.service.CustomerService;
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
@RequestMapping(value = "api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void > createCustomer(@Valid @RequestBody CustomerDTO customerDTO  ){
        try {
            customerService.saveCustomer(customerDTO);
            logger.info("Customer saved : " + customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/allcustomers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping(value = "/{cusId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public CustomerResponse getCustomer(@PathVariable("cusId") String cusId){
        return customerService.getSelectCustomer(cusId);
    }

    @PatchMapping(value = "/{cusId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>  updateCustomer(@Valid @PathVariable ("cusId") String cusId,@RequestBody CustomerDTO customerdto) {
        try {
            customerService.updateCustomer(cusId, customerdto);
            logger.info("Customer updated : " + customerdto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFound e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{cusId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ("cusId") String cusId) {
        try {
            customerService.deleteCustomer(cusId);
            logger.info("Customer deleted : " + cusId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
