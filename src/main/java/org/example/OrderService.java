package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

@WebService
public class OrderService {

    List<Order> orderList = new ArrayList<>();

    @WebMethod
    public void create(Order order){
        orderList.add(order);
    }

    @WebMethod
    public void updateStatus(Long id, String status){
        orderList.forEach(order -> {
            if (id.equals(order.getId())){
                order.setStatus(status);
            }
        });
    }

    @WebMethod
    public List<Order> getAll(){
        return orderList;
    }


}
