package mg.andy.atody.mappers;

import mg.andy.atody.mappers.helpers.ExpenseHelperMapper;
import mg.andy.atody.models.Expense;
import mg.andy.atody.presentation.ExpenseDto;
import mg.andy.atody.presentation.request.ExpenseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = ExpenseHelperMapper.class)
public interface ExpenseMapper {

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "item", source = "itemId")
    @Mapping(target = "itemPrice", source = "expenseAmount")
    Expense toEntity(ExpenseRequest expenseRequest);

    @Mapping(target = "unitPrice", source = "item.price")
    @Mapping(target = "totalPrice", source = "expense")
    @Mapping(target = "designation", source = "item.designation")
    ExpenseDto toDto(Expense expense);

    default BigDecimal getTotalPrice(Expense expense) {
        BigDecimal itemPrice = Optional.ofNullable(expense.getItemPrice())
                .orElse(expense.getItem().getPrice());
        return itemPrice.multiply(BigDecimal.valueOf(expense.getQuantity()));
    }
}
