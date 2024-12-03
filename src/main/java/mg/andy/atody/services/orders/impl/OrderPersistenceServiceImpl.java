package mg.andy.atody.services.orders.impl;

import mg.andy.atody.mappers.OrderMapper;
import mg.andy.atody.models.Order;
import mg.andy.atody.presentation.OrderRequest;
import mg.andy.atody.repositories.OrderRepository;
import mg.andy.atody.services.orders.OrderPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPersistenceServiceImpl implements OrderPersistenceService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderPersistenceServiceImpl() {
    }

    @Autowired
    public OrderPersistenceServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public void createOrder(OrderRequest orderRequest) {
        log.info("Creating order {}", orderRequest);
        Order order = orderMapper.toEntity(orderRequest);
        orderRepository.save(order);
    }

    @Override
    public void removeOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
