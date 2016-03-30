package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;
import java.util.List;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BookKeeper {

	public Invoice issuance(InvoiceRequest invoiceRequest) {
		Invoice invoice = InvoiceFactory.getInvoice(Id.generate(), invoiceRequest.getClient());

		for (RequestItem item : invoiceRequest.getItems()) {
			Money net = item.getTotalCost();
			BigDecimal ratio = null;
			String desc = null;

			IssuanceStrategy issuanceStrategy = item.getIssuanceStrategy();

			ratio = issuanceStrategy.getRatio();
			desc = issuanceStrategy.getDesc();

			Money taxValue = net.multiplyBy(ratio);
			
			Tax tax = new Tax(taxValue, desc);
			

			InvoiceLine invoiceLine = new InvoiceLine(item.getProductData(),
					item.getQuantity(), net, tax);
			invoice.addItem(invoiceLine);
		}

		return invoice;
	}

}
