package lk.ijse.possystemspringbackend.util;

import java.util.UUID;

public class AppUtil {
    public static String createCustomerId(){
        return "Customer"+ UUID.randomUUID().toString();
    }
    public static String createItemCode(){
        return "Item"+ UUID.randomUUID().toString();
    }
    public static String createOrderId(){
        return "Order"+ UUID.randomUUID().toString();
    }
}
