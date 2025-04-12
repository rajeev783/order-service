package in.javastack.order.service;

import in.javastack.order.client.InventoryClient;
import in.javastack.order.dto.OrderRequestDTO;
import in.javastack.order.model.Order;
import in.javastack.order.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepo orderRepo;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequestDTO orderRequestDTO){
        if(inventoryClient.isInStock(orderRequestDTO.skuCode(),orderRequestDTO.quantity())) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequestDTO.price());
            order.setQuantity(orderRequestDTO.quantity());
            order.setSkuCode(orderRequestDTO.skuCode());
            orderRepo.save(order);
            log.info("Order placed successfully!");
        } else {
            throw new RuntimeException("item is out of stock");
        }
    }

    public List<OrderRequestDTO> getAllOrders(){
        return orderRepo.findAll()
                .stream()
                .map(order -> new OrderRequestDTO(
                        order.getId(),order.getOrderNumber(),
                        order.getSkuCode(),order.getPrice(),order.getQuantity()
                )).toList();
    }
}
