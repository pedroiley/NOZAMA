package controller;

import dao.DaoManager;
import entity.OrderItem;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@RestController
public class OrderItemController {

    private DaoManager DM = new DaoManager();

    @PostMapping(path = "/OrderItem", consumes = "application/json")
    @ResponseBody
    public void createOrderItem(@RequestBody Map<String, Object> body){
        OrderItem oi = new OrderItem(
                (Integer)body.get("productId"),
                (Integer)body.get("orderId"),1);

        DM.getOrderItemDao().createOrderItem(oi);
    }

    @PutMapping(path = "/OrderItem/{orderItemId}", consumes = "application/json")
    @ResponseBody
    public void updateOrderItem(@PathVariable long orderItemId , @RequestBody Map<String, Object> body)
    {
        OrderItem oi3 = DM.getOrderItemDao().getOrderItem(orderItemId);

        oi3.setOrderItems(
                (int)body.get("productId"),
                (int)body.get("orderId"),
                (int)body.get("quantity") );

        DM.getOrderItemDao().updateOrderItem(oi3);
    }

    @DeleteMapping(path = "/OrderItem", consumes = "application/json")
    @ResponseBody
    public void deleteOrderItem(@RequestBody Map<String, Long> body){
        OrderItem oi2 =  DM.getOrderItemDao().getOrderItem(body.get("orderItemId"));

        DM.getOrderItemDao().deleteOrderItem(oi2);
    }



    @GetMapping (path = "/OrderItem", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public OrderItem readOrderItem(@RequestBody Map<String, Object> body)
    {
        return DM.getOrderItemDao().getOrderItem((Long)body.get("orderItemId"));
    }

    @GetMapping (path = "/OrderItems")
    @ResponseBody
    public List<OrderItem> readOrderItems()
    {
        return DM.getOrderItemDao().getOrderItems();
    }
}
