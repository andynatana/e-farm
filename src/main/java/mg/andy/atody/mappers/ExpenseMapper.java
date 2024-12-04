package mg.andy.atody.mappers;

import mg.andy.atody.models.Expense;
import mg.andy.atody.presentation.request.ExpenseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    Expense toEntity(ExpenseRequest expenseRequest);
}
