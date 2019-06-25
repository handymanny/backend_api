package Controller;


import Model.Order;
import Model.OrderDetail;
import Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer createOrder (@RequestParam("card_id") String cartId,
                                @RequestParam("shipping_id") int shippingId,
                                @RequestParam("tax_id") int taxId) {
        int customerId = 1;
        return orderService.createOrder(customerId, cartId, shippingId, taxId);
    }

    @RequestMapping(value = "/{order_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDetail getOrderInformation (@PathVariable("order_id") int orderId) {
        return orderService.getOrderInformation(orderId);
    }

    @RequestMapping(value = "/inCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrdersByCustomer (@RequestParam("customer_id") int customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @RequestMapping(value = "/shortDetail/{order_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getShortOrderDetail(@PathVariable("order_id") int orderId) {
        return orderService.getShortOrderDetail(orderId);
    }




}
