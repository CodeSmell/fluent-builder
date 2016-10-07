package codesmell.invoice.fluent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

	private InvoiceActor invoiceSupplier;
	private InvoiceActor invoiceDestination;
	
	private String supplierDocumentId;
	private Date documentDate;
	
	private String trailerNumber;
	
	private List<InvoiceItem> items;

	/**
	 * static factory method
	 */
	public static Invoice create() {
		return new Invoice();
	}
	
	/**
	 * fluent static factory method
	 */
	public static Invoice createdOn(Date date) {
		Invoice inv = new Invoice();
		inv.setDocumentDate(date);
		return inv;
	}
	
	/**
	 * Allows for a fluent creation of the object
	 * per Martin Fowler it breaks the command-query style of 
	 * writing methods as well as the naming pattern expected
	 * by most tools 
	 * @param trailerNum
	 * @return Invoice
	 */
	public Invoice shippingOnTrailer(String trailerNum) {
		this.trailerNumber = trailerNum;
		return this;
	}
	
	/**
	 * fluent setter for document number
	 * @param docNumber
	 * @return
	 */
	public Invoice withDocumentNumber(String docNumber) {
		this.supplierDocumentId = docNumber;
		return this;
	}
	
	/**
	 * fluent setter for Supplier
	 * @param docNumber
	 * @return
	 */
	public Invoice suppliedBy(InvoiceActor actor) {
		this.invoiceSupplier = actor;
		return this;
	}
	
	/**
	 * fluent setter for Destination
	 * @param docNumber
	 * @return
	 */
	public Invoice beingSentTo(InvoiceActor actor) {
		this.invoiceDestination = actor;
		return this;
	}
	
	/**
	 * fluent setter for items in the list
	 * @param docNumber
	 * @return
	 */
	public Invoice with(InvoiceItem item) {
		if (items == null) {
			items = new ArrayList<InvoiceItem>();
		}
		items.add(item);
		return this;
	}
	
	public String getTrailerNumber() {
		return trailerNumber;
	}

	public void setTrailerNumber(String trailerNumber) {
		this.trailerNumber = trailerNumber;
	}
	
	public String getSupplierDocumentId() {
		return supplierDocumentId;
	}

	public void setSupplierDocumentId(String supplierDocumentId) {
		this.supplierDocumentId = supplierDocumentId;
	}
	
	public InvoiceActor getInvoiceSupplier() {
		return invoiceSupplier;
	}

	public void setInvoiceSupplier(InvoiceActor invoiceSupplier) {
		this.invoiceSupplier = invoiceSupplier;
	}

	public InvoiceActor getInvoiceDestination() {
		return invoiceDestination;
	}

	public void setInvoiceDestination(InvoiceActor invoiceDestination) {
		this.invoiceDestination = invoiceDestination;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}
}
