package mg.andy.atody.repositories;

import mg.andy.atody.models.Expense;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends ListCrudRepository<Expense, Long> {
}
