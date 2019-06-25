package Dao;

import Model.Order;
import Model.OrderDetail;

import java.util.List;

public interface OrderDao {

    Integer createOrder(int customerId, String cartId, int shippingId, int taxId);

    OrderDetail getOrderInformation (int orderId);

    List<Order> getOrdersByCustomer (int customerId);

    Order getShortOrderDetail (int orderId);

}
