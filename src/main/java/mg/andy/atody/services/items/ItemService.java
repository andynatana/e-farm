package mg.andy.atody.services.items;

import mg.andy.atody.models.Item;
import mg.andy.atody.presentation.ItemDto;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {

    List<ItemDto> fetch();

    BigDecimal getPrice(Long itemId);

    Item findById(Long itemId);

}
