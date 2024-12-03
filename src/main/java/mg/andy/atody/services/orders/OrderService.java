package mg.andy.atody.services.orders;

import mg.andy.atody.presentation.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAll();
}
