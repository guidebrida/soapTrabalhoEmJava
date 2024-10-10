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
    public void updateStatus(int id, String status) {
        orderList.forEach(order -> {
            if (id == order.getId()) {
                order.setStatus(status);
            }
        });
    }

    @WebMethod
    public void delete(int id) {
        orderList.removeIf(order -> id == order.getId());
    }
    @WebMethod
    public List<Order> getAll(){
        return orderList;
    }


}
