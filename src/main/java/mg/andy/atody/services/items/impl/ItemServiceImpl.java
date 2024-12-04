package mg.andy.atody.services.items.impl;

import mg.andy.atody.exceptions.BusinessException;
import mg.andy.atody.mappers.ItemMapper;
import mg.andy.atody.models.Item;
import mg.andy.atody.presentation.ItemDto;
import mg.andy.atody.repositories.ItemRepository;
import mg.andy.atody.services.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    public ItemServiceImpl() {
    }

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDto> fetch() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::toDto)
                .toList();

    }

    @Override
    public BigDecimal getPrice(Long itemId) {
        return itemRepository.findById(itemId)
                .map(Item::getPrice)
                .orElseThrow(() -> new BusinessException("Price not found for item " + itemId));
    }

    @Override
    public Item findById(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new BusinessException("Item not found for item " + itemId));
    }
}
