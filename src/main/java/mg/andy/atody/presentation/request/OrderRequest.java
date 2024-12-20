package mg.andy.atody.presentation.request;

import java.math.BigDecimal;

public class OrderRequest {

    private Long customerId;
    private Long quantity;
    private BigDecimal unitPrice;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
               "customerId=" + customerId +
               ", quantity=" + quantity +
               ", unitPrice=" + unitPrice +
               '}';
    }
}
