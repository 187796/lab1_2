package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public class StandardIssuanceStrategy implements IssuanceStrategy {
    public BigDecimal getRatio() {
        return BigDecimal.valueOf(0.23);
    }

    public String getDesc() {
        return "23%";
    }
}