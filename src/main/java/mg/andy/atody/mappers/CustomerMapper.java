package mg.andy.atody.mappers;

import mg.andy.atody.models.Customer;
import mg.andy.atody.presentation.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);
}
