package Service;

import Dao.OrderDao;
import Model.Order;
import Model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Integer createOrder (int customerId, String cartId, int shippingId, int taxId) {
        return orderDao.createOrder(customerId, cartId, shippingId, taxId);
    }

    public OrderDetail getOrderInformation (int orderId) {
        return orderDao.getOrderInformation(orderId);
    }

    public List<Order> getOrdersByCustomer (int customerId) {
        return orderDao.getOrdersByCustomer(customerId);
    }

    public Order getShortOrderDetail(int orderId) {
        return orderDao.getShortOrderDetail(orderId);
    }


}
