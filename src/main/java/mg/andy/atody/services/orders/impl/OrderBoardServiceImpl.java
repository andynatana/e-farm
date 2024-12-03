package mg.andy.atody.services.orders.impl;

import mg.andy.atody.presentation.OrderBoard;
import mg.andy.atody.repositories.OrderRepository;
import mg.andy.atody.services.orders.OrderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBoardServiceImpl implements OrderBoardService {

    private OrderRepository orderRepository;

    public OrderBoardServiceImpl() {
    }

    @Autowired
    public OrderBoardServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderBoard getOrderBoardStat() {
        return orderRepository.getBoardStat();
    }
}
