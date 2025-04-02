package Make_Orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "types-service", url = "http://localhost:2222")
public interface TypesClient {

//    @GetMapping("/types/{id}")
//
//    public Type getType(@PathVariable("id") Long id);
}
