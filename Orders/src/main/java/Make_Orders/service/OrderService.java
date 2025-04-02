package Make_Orders.service;

import Make_Orders.entity.Order;
import Make_Orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
public List<Order> getAllOrders() {
    return repository.findAll();
}
public Order getOrderById(Long id) {
return repository.findById(id).orElse(null);
}

}
