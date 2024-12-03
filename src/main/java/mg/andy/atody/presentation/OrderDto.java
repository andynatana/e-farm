package mg.andy.atody.presentation;

import mg.andy.atody.models.enums.OrderStatus;

import java.math.BigDecimal;

public record OrderDto(
        Long orderId,
        String customerFullName,
        Long quantity,
        BigDecimal unitPrice,
        BigDecimal amount,
        OrderStatus orderStatus
) {
}
