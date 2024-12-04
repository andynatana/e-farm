package mg.andy.atody.repositories;

import mg.andy.atody.models.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ExpenseRepository extends ListCrudRepository<Expense, Long> {

    @Query("select sum((e.itemPrice * e.quantity)) from Expense e")
    BigDecimal getTotalExpense();
}
