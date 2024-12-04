package mg.andy.atody.presentation;

import java.math.BigDecimal;

public record ExpenseDto(
        Long id,
        String designation,
        Long quantity,
        BigDecimal unitPrice,
        BigDecimal totalPrice
) {

}
