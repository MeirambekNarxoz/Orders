package Make_Orders.controller;

import Make_Orders.entity.Order;
import Make_Orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping(name = "/order")
public class Order_Controller {
    private final OrderService service;

    @GetMapping()
    public List<Order> getAll() {
        return service.getAllOrders();
    }
    @GetMapping("/id")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }
}
