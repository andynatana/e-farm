package mg.andy.atody.services.expenses;

import mg.andy.atody.mappers.ExpenseMapper;
import mg.andy.atody.models.Expense;
import mg.andy.atody.presentation.request.ExpenseRequest;
import mg.andy.atody.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper;

    public ExpenseServiceImpl() {
    }

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public void create(ExpenseRequest expenseRequest) {
        Expense expense = expenseMapper.toEntity(expenseRequest);
        expenseRepository.save(expense);
    }
}
