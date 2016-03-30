package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

class RequestItem {
	private IssuanceStrategy issuanceStrategy;

	private ProductData productData;

	private int quantity;

	private Money totalCost;

	public RequestItem(ProductData productData, int quantity, Money totalCost) {
		this.productData = productData;
		this.quantity = quantity;
		this.totalCost = totalCost;

		switch (productData.getType()) {
			case DRUG:
				issuanceStrategy = new DrugIssuanceStrategy();
				break;
			case FOOD:
				issuanceStrategy = new FoodIssuanceStrategy();
				break;
			case STANDARD:
				issuanceStrategy = new StandardIssuanceStrategy();
				break;

			default:
				throw new IllegalArgumentException(productData.getType() + " not handled");
		}
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public ProductData getProductData() {
		return productData;
	}

	public int getQuantity() {
		return quantity;
	}

	public IssuanceStrategy getIssuanceStrategy() {
		return issuanceStrategy;
	};
}