package mg.andy.atody.mappers;

import mg.andy.atody.mappers.helpers.OrderMapperHelper;
import mg.andy.atody.models.Order;
import mg.andy.atody.presentation.OrderDto;
import mg.andy.atody.presentation.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderMapperHelper.class)
public interface OrderMapper {

    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "status", expression = "java(mg.andy.atody.models.enums.OrderStatus.INITIATED)")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", source = "customerId")
    Order toEntity(OrderRequest orderRequest);

    @Mapping(target = "orderStatus", source = "status")
    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "customerFullName", source = "customer.fullName")
    @Mapping(target = "amount", source = "order.totalPrice")
    OrderDto toDto(Order order);
}
