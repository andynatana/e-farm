package mg.andy.atody.services.impl;

import mg.andy.atody.mappers.CustomerMapper;
import mg.andy.atody.models.Customer;
import mg.andy.atody.presentation.CustomerDto;
import mg.andy.atody.repositories.CustomerRepository;
import mg.andy.atody.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl() {
    }

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDto> fetch() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }
}
