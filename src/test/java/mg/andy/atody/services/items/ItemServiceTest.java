package mg.andy.atody.services.items;

import mg.andy.atody.presentation.ItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    void fetch() {
        List<ItemDto> items = itemService.fetch();
        assertFalse(items.isEmpty());
    }

    @Test
    void getPrice() {
        BigDecimal price = itemService.getPrice(1L);
        assertNotNull(price);
        assertTrue(price.doubleValue() > 0);
    }
}