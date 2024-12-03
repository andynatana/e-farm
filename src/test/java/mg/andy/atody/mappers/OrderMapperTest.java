package mg.andy.atody.mappers;

import mg.andy.atody.models.Order;
import mg.andy.atody.presentation.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void toEntity() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setCustomerId(1L);
        orderRequest.setQuantity(12L);
        orderRequest.setUnitPrice(BigDecimal.valueOf(14));

        Order order = orderMapper.toEntity(orderRequest);
        assertNotNull(order);
        assertNotNull(order.getCustomer());
        assertNotNull(order.getQuantity());
        assertNotNull(order.getUnitPrice());
        assertNotNull(order.getStatus());
        assertNotNull(order.getTotalPrice());
        assertEquals(orderRequest.getCustomerId(), order.getCustomer().getId());
        assertEquals(orderRequest.getQuantity(), order.getQuantity());
        assertEquals(orderRequest.getUnitPrice(), order.getUnitPrice());
    }
}