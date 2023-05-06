package ma.orders.services;

import ma.orders.entities.Orders;
import ma.orders.exceptions.ResourceNotFoundException;
import ma.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(String id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders updateOrder(String id, Orders order) {
        Optional<Orders> existingOrder = ordersRepository.findById(id);
        if (existingOrder.isPresent()) {
            Orders updatedOrder = existingOrder.get();
            updatedOrder.setDescription(order.getDescription());
            updatedOrder.setTotalHT(order.getTotalHT());
            updatedOrder.setTotalTTC(order.getTotalTTC());
            updatedOrder.setQuantity(order.getQuantity());
            updatedOrder.setProductId(order.getProductId());
            updatedOrder.setSupplierId(order.getSupplierId());
            return ordersRepository.save(updatedOrder);
        } else {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        }
    }

    public void deleteOrder(String id) {
        Optional<Orders> existingOrder = ordersRepository.findById(id);
        if (existingOrder.isPresent()) {
            ordersRepository.delete(existingOrder.get());
        } else {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        }
    }
}
