package mg.andy.atody.mappers;

import mg.andy.atody.mappers.helpers.ExpenseHelperMapper;
import mg.andy.atody.models.Expense;
import mg.andy.atody.presentation.request.ExpenseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", uses = ExpenseHelperMapper.class)
public interface ExpenseMapper {

    @Mapping(target = "item", source = "itemId")
    @Mapping(target = "itemPrice", source = "expenseAmount")
    Expense toEntity(ExpenseRequest expenseRequest);

}
