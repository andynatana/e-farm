package mg.andy.atody.services;

import mg.andy.atody.presentation.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> fetch();
}
