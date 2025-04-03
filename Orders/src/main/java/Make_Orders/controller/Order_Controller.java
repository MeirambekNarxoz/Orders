package Make_Orders.controller;

import Make_Orders.entity.Order;
import Make_Orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order") // Путь для всех запросов
public class Order_Controller {
    private final OrderService service;

    // Получить все заказы
    @GetMapping("")  // Путь для всех заказов
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    // Получить заказ по ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }
}
