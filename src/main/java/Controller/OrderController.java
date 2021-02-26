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

    @PostMapping(path = "/Order", consumes = "application/json")
    @ResponseBody
    public void createOrder(@RequestBody Map<String, Integer> body){
        Order or = new Order(body.get("userId"));

        DM.getOrderDao().createOrder(or);
    }

    @PutMapping(path = "/Order/{orderId}", consumes = "application/json")
    @ResponseBody
    public void updateOrder(@PathVariable long orderId, @RequestBody Map<String, Object> body)
    {
        Order o = DM.getOrderDao().getOrder(orderId);

        o.setUserId((Integer)body.get("userId"));
        DM.getOrderDao().updateOrder(o);
    }

    @DeleteMapping(path = "/Order", consumes = "application/json")
    @ResponseBody
    public void deleteOrder(@RequestBody Map<String, Long> body){
        Order or2 =  DM.getOrderDao().getOrder(body.get("orderId"));

        DM.getOrderDao().deleteOrder(or2);
    }

    @GetMapping (path = "/Order", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Order readOrder(@RequestBody Map<String, Object> body)
    {
        return DM.getOrderDao().getOrder((Long)body.get("orderId"));
    }

    @GetMapping (path = "/Orders")
    @ResponseBody
    public List<Order> readOrders()
    {
        return DM.getOrderDao().getOrders();
    }
}
