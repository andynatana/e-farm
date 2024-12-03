package mg.andy.atody.services.orders.impl;

import mg.andy.atody.mappers.OrderMapper;
import mg.andy.atody.presentation.OrderDto;
import mg.andy.atody.repositories.OrderRepository;
import mg.andy.atody.services.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderServiceImpl() {
    }

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
