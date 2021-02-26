package controller;

import dao.DaoManager;
import entity.Orders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Component
public class OrderController {

    private DaoManager DM = new DaoManager();

    @PostMapping(path = "/order", consumes = "application/json")
    @ResponseBody
    public void createOrder(@RequestBody Map<String, Integer> body){
        Orders or = new Orders(body.get("userId"));

        DM.getOrderDao().createOrder(or);
    }

    @PutMapping(path = "/order/{orderId}", consumes = "application/json")
    @ResponseBody
    public void updateOrder(@PathVariable int orderId, @RequestBody Map<String, Object> body)
    {
        Orders o = DM.getOrderDao().getOrder(orderId);

        o.setUserId((Integer)body.get("userId"));
        DM.getOrderDao().updateOrder(o);
    }

    @DeleteMapping(path = "/order/{orderId}", consumes = "application/json")
    @ResponseBody
    public void deleteOrder(@PathVariable int orderId){
        Orders or2 =  DM.getOrderDao().getOrder(orderId);

        DM.getOrderDao().deleteOrder(or2);
    }

    @GetMapping (path = "/order/{orderId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Orders readOrder(@PathVariable int orderId)
    {
        return DM.getOrderDao().getOrder(orderId);
    }

    @GetMapping (path = "/order/list", consumes = "application/json", produces= "application/json")
    @ResponseBody
    public List<Orders> readOrders()
    {
        return DM.getOrderDao().getOrders();
    }
}
