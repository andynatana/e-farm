package mg.andy.atody.mappers;

import mg.andy.atody.models.Item;
import mg.andy.atody.presentation.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "unitPrice", source = "price")
    ItemDto toDto(Item item);
}
