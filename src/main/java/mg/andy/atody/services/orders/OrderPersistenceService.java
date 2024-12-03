package mg.andy.atody.services.orders;

import mg.andy.atody.presentation.OrderRequest;

public interface OrderPersistenceService {

    void createOrder(OrderRequest orderRequest);

    void removeOrder(Long orderId);
}
