package mg.andy.atody.services;

import mg.andy.atody.presentation.OrderDto;
import mg.andy.atody.presentation.OrderRequest;

import java.util.List;

public interface OrderService {

    void createOrder(OrderRequest orderRequest);

    List<OrderDto> getAll();
}
