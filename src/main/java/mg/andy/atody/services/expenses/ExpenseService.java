package mg.andy.atody.services.expenses;

import mg.andy.atody.presentation.ExpenseDto;
import mg.andy.atody.presentation.request.ExpenseRequest;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {

    void create(ExpenseRequest expenseRequest);

    List<ExpenseDto> fetch();

    void remove(Long expenseId);

    BigDecimal getTotalExpense();
}
