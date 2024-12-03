package mg.andy.atody.presentation;

import java.math.BigDecimal;

public record OrderBoard(
        Long quantitySold,
        BigDecimal totalSellingPrice
) {
}
