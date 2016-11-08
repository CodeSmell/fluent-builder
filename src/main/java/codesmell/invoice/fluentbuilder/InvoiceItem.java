package codesmell.invoice.fluentbuilder;

import java.util.function.Consumer;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class InvoiceItem {
	private String itemGtin;
	private Integer quantityRequested;
	private Integer quantityShipped;

	/**
	 * static factory method for builder
	 */
	public static Builder builder() {
		return new InvoiceItem.Builder();
	}
	
	/**
	 * forces use of the Builder
	 */
	private InvoiceItem() {
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
