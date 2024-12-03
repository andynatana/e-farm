package mg.andy.atody.repositories;

import mg.andy.atody.models.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
}
