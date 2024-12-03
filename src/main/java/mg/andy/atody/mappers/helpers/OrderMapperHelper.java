package mg.andy.atody.mappers.helpers;

import mg.andy.atody.models.Customer;
import mg.andy.atody.services.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperHelper {

    private CustomerService customerService;

    public OrderMapperHelper() {
    }

    @Autowired
    public OrderMapperHelper(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer fromCustomerId(Long id) {
        return customerService.getById(id)
                .orElseThrow();
    }
}
