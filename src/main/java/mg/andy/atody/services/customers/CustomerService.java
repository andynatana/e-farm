package mg.andy.atody.services.customers;

import mg.andy.atody.models.Customer;
import mg.andy.atody.presentation.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDto> fetch();

    Optional<Customer> getById(Long id);
}
