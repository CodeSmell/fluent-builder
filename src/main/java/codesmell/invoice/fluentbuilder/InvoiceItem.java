package codesmell.invoice.fluentbuilder;

import java.util.function.Consumer;

public class InvoiceItem {
	private String itemGtin;
	private Integer quantityRequested;
	private Integer quantityShipped;

	public static Builder builder() {
		return new InvoiceItem.Builder();
	}

	public String getItemGtin() {
		return itemGtin;
	}

	public Integer getQuantityRequested() {
		return quantityRequested;
	}

	public Integer getQuantityShipped() {
		return quantityShipped;
	}

	public static class Builder {
		private InvoiceItem managedInstance = new InvoiceItem();
		private Invoice.Builder parentBuilder;
		private Consumer<InvoiceItem> callback;

		public Builder() {
		}
		
		public Builder(Invoice.Builder b, Consumer<InvoiceItem> c) {
			parentBuilder = b;
			callback = c;
		}

		public Builder as(String gtin) {
			managedInstance.itemGtin = gtin;
			return this;
		}

		public Builder orderedQuantity(Integer num) {
			managedInstance.quantityRequested = num;
			return this;
		}

		public Builder shippedQuantity(Integer num) {
			managedInstance.quantityShipped = num;
			return this;
		}
		
		public InvoiceItem build() {
			return managedInstance;
		}
		
		public Invoice.Builder end() {
			callback.accept(managedInstance);
			return parentBuilder;
		}

	}
}
