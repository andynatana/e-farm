package mg.andy.atody.mappers.helpers;

import mg.andy.atody.models.Item;
import mg.andy.atody.services.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpenseHelperMapper {

    private ItemService itemService;

    public ExpenseHelperMapper() {
    }

    @Autowired
    public ExpenseHelperMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    public Item map(Long itemId) {
        return itemService.
                findById(itemId);
    }
}
