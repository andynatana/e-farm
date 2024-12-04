package mg.andy.atody.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ExpenseRepositoryTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void getTotalExpense() {
        BigDecimal totalExpense = expenseRepository.getTotalExpense();
        assertNotNull(totalExpense);
        assertTrue(totalExpense.compareTo(new BigDecimal(0)) > 0);
    }
}