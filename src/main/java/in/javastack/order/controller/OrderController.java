package in.javastack.order.controller;

import in.javastack.order.dto.OrderRequestDTO;
import in.javastack.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequestDTO orderRequestDTO){
            orderService.placeOrder(orderRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderRequestDTO> getAllOrders(){
       return orderService.getAllOrders();
    }
}
