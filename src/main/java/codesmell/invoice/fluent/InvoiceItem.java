package codesmell.invoice.fluent;

public class InvoiceItem {
	private String itemGtin;
	private Integer quantityRequested;
	private Integer quantityShipped;
	
	/**
	 * static factory method 
	 * @return
	 */
	public static InvoiceItem create() {
		return new InvoiceItem();
	}
	
	public InvoiceItem as(String gtin) {
		this.itemGtin = gtin;
		return this;
	}
	
	public InvoiceItem orderedQuantity(Integer num) {
		this.quantityRequested = num;
		return this;
	}
	
	public InvoiceItem shippedQuantity(Integer num) {
		this.quantityShipped = num;
		return this;
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
	
}
