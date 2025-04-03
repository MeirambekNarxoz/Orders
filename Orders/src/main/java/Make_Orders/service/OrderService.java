package Make_Orders.service;

import Make_Orders.client.TypesClient;
import Make_Orders.entity.Order;
import Make_Orders.client.UserDTO;  // Импортируем UserDTO
import Make_Orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final TypesClient typesClient;  // Feign клиент для работы с пользователями

    // Метод для получения всех заказов
    public List<Order> getAllOrders() {
        List<Order> orders = repository.findAll();

        // Для каждого заказа получаем данные о пользователе и прикрепляем к заказу
        for (Order order : orders) {
            // Заменить order.getId() на order.getUserId(), если user_id это поле, которое хранит id пользователя
            UserDTO user = typesClient.getUserById(order.getUserId()); // Получаем пользователя по ID, связанному с заказом
            order.setUser(user);  // Устанавливаем данные пользователя в заказ
        }

        return orders;
    }

    // Метод для получения заказа по ID
    public Order getOrderById(Long id) {
        Order order = repository.findById(id).orElse(null);

        if (order != null) {
            // Заменить order.getId() на order.getUserId(), если user_id это поле, которое хранит id пользователя
            UserDTO user = typesClient.getUserById(order.getUserId());  // Получаем пользователя по ID, связанному с заказом
            order.setUser(user);  // Устанавливаем данные пользователя в заказ
        }

        return order;
    }
}
