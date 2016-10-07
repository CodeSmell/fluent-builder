package codesmell.invoice.standard;

public class InvoiceItem {
	private String itemGtin;
	private Integer quantityRequested;
	private Integer quantityShipped;
	
	public InvoiceItem() {
	}
	
	public InvoiceItem(String gtin, Integer requested, Integer shipped) {
		this.itemGtin = gtin;
		this.quantityRequested = requested;
		this.quantityShipped = shipped;
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
