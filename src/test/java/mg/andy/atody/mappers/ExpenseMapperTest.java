package mg.andy.atody.mappers;

import mg.andy.atody.models.Expense;
import mg.andy.atody.presentation.request.ExpenseRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseMapperTest {

    @Autowired
    private ExpenseMapper expenseMapper;

    @Test
    void toEntity() {
        ExpenseRequest expenseRequest = new ExpenseRequest();
        expenseRequest.setExpenseAmount(BigDecimal.valueOf(12000));
        expenseRequest.setQuantity(2L);
        expenseRequest.setItemId(1L);

        Expense expense = expenseMapper.toEntity(expenseRequest);
        assertNotNull(expense);
        assertNotNull(expense.getItemPrice());
        assertNotNull(expense.getQuantity());
        assertNotNull(expense.getItem());
    }
}