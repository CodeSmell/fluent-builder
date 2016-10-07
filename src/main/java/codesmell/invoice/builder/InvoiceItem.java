package codesmell.invoice.builder;

public class InvoiceItem {
	private String itemGtin;
	private Integer quantityRequested;
	private Integer quantityShipped;

	public static InvoiceItemBuilder builder() {
		return new InvoiceItem.InvoiceItemBuilder();
	}

	public String getItemGtin() {
		return itemGtin;
	}

	public void setItemGtin(String itemGtin) {
		this.itemGtin = itemGtin;
	}

	public Integer getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(Integer quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public Integer getQuantityShipped() {
		return quantityShipped;
	}

	public void setQuantityShipped(Integer quantityShipped) {
		this.quantityShipped = quantityShipped;
	}

	public static class InvoiceItemBuilder {
		private InvoiceItem managedInstance = new InvoiceItem();

		public InvoiceItemBuilder() {
		}

		public InvoiceItemBuilder as(String gtin) {
			managedInstance.itemGtin = gtin;
			return this;
		}

		public InvoiceItemBuilder orderedQuantity(Integer num) {
			managedInstance.quantityRequested = num;
			return this;
		}

		public InvoiceItemBuilder shippedQuantity(Integer num) {
			managedInstance.quantityShipped = num;
			return this;
		}
		
		public InvoiceItem build() {
			return managedInstance;
		}

	}
}
