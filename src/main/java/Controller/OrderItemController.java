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

    @PostMapping(path = "/orderItem", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void createOrderItem( @RequestBody Map<String, Object> body){
        OrderItem oi = new OrderItem(
                (int)body.get("productId"),
                (int)body.get("orderId"),1);

        DM.getOrderItemDao().createOrderItem(oi);
    }

    @PutMapping(path = "/orderItem/{orderItemId}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void updateOrderItem(@PathVariable int orderItemId , @RequestBody Map<String, Object> body)
    {
        OrderItem oi3 = DM.getOrderItemDao().getOrderItem(orderItemId);

        oi3.setOrderItems(
                (int)body.get("productId"),
                (int)body.get("orderId"),
                (int)body.get("quantity") );

        DM.getOrderItemDao().updateOrderItem(oi3);
    }

    @DeleteMapping(path = "/orderItem", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public void deleteOrderItem(@RequestBody Map<String, Integer> body){
        OrderItem oi2 =  DM.getOrderItemDao().getOrderItem(body.get("orderItemId"));

        DM.getOrderItemDao().deleteOrderItem(oi2);
    }

    @GetMapping (path = "/orderItem", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public OrderItem readOrderItem(@RequestBody Map<String, Object> body)
    {
        return DM.getOrderItemDao().getOrderItem((int)body.get("orderItemId"));
    }

    @GetMapping (path = "/orderItem/list", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<OrderItem> readOrderItems()
    {
        return DM.getOrderItemDao().getOrderItems();
    }
}
