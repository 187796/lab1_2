package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public interface IssuanceStrategy {
    BigDecimal getRatio();

    String getDesc();
}