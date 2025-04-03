package Make_Orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "types-service", url = "http://localhost:8080") // User service on port 8080
public interface TypesClient {

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id);
}
