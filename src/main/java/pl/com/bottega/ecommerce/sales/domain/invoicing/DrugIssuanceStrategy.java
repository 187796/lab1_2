package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public class DrugIssuanceStrategy implements IssuanceStrategy {
    public BigDecimal getRatio() {
        return BigDecimal.valueOf(0.05);
    }

    public String getDesc() {
        return "5% (D)";
    }
}