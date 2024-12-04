package mg.andy.atody.presentation;

import java.math.BigDecimal;

public record ItemDto(
        Long id,
        String designation,
        BigDecimal unitPrice
) {
}
