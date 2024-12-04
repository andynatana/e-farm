package mg.andy.atody.services.expenses;

import mg.andy.atody.mappers.ExpenseMapper;
import mg.andy.atody.models.Expense;
import mg.andy.atody.presentation.request.ExpenseRequest;
import mg.andy.atody.repositories.ExpenseRepository;
import mg.andy.atody.services.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper;
    private ItemService itemService;

    public ExpenseServiceImpl() {
    }

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper, ItemService itemService) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
        this.itemService = itemService;
    }

    @Override
    public void create(ExpenseRequest expenseRequest) {
        BigDecimal itemPrice = itemService.getPrice(expenseRequest.getItemId());
        if (expenseRequest.getExpenseAmount() == null) {
            expenseRequest.setExpenseAmount(itemPrice);
        }
        Expense expense = expenseMapper.toEntity(expenseRequest);
        expenseRepository.save(expense);
    }
}
