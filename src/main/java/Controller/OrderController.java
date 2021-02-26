package controller;

import dao.DaoManager;
import entity.Order;
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
        Order or = new Order(body.get("userId"));

        DM.getOrderDao().createOrder(or);
    }

    @PutMapping(path = "/order/{orderId}", consumes = "application/json")
    @ResponseBody
    public void updateOrder(@PathVariable long orderId, @RequestBody Map<String, Object> body)
    {
        Order o = DM.getOrderDao().getOrder(orderId);

        o.setUserId((Integer)body.get("userId"));
        DM.getOrderDao().updateOrder(o);
    }

    @DeleteMapping(path = "/order/{orderId}", consumes = "application/json")
    @ResponseBody
    public void deleteOrder(@PathVariable long orderId){
        Order or2 =  DM.getOrderDao().getOrder(orderId);

        DM.getOrderDao().deleteOrder(or2);
    }

    @GetMapping (path = "/order/{orderId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Order readOrder(@PathVariable long orderId)
    {
        return DM.getOrderDao().getOrder(orderId);
    }

    @GetMapping (path = "/order/list", consumes = "application/json", produces= "application/json")
    @ResponseBody
    public List<Order> readOrders()
    {
        return DM.getOrderDao().getOrders();
    }
}
