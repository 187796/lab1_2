package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public class FoodIssuanceStrategy implements IssuanceStrategy {
    public BigDecimal getRatio() {
        return BigDecimal.valueOf(0.07);
    }

    public String getDesc() {
        return "7% (F)";
    }
}