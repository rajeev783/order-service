package in.javastack.order.dto;

import java.math.BigDecimal;

public record OrderRequestDTO(
         Long id,
         String orderNumber,
         String skuCode,
         BigDecimal price,
         int quantity
) {
}
