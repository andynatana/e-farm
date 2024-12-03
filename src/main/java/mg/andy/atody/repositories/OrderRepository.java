package mg.andy.atody.repositories;

import mg.andy.atody.models.Order;
import mg.andy.atody.presentation.OrderBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            SELECT new mg.andy.atody.presentation.OrderBoard(sum(o.quantity), sum(cast(o.unitPrice * o.quantity as BIGDECIMAL ))) FROM Order o
            """)
    OrderBoard getBoardStat();
}
