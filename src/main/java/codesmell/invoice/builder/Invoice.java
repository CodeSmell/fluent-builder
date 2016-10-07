package codesmell.invoice.builder;

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
	 * static factory method for builder
	 */
	public static InvoiceBuilder builder() {
		return new Invoice.InvoiceBuilder();
	}
	
	private Invoice() {
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

	public static class InvoiceBuilder {
		Invoice managedInstance = new Invoice();

		/**
		 * fluent setters for date
		 * @param date
		 * @return
		 */
		public InvoiceBuilder createdOn(Date date) {
			managedInstance.setDocumentDate(date);
			return this;
		}

		/**
		 * fluent setter for trailer
		 * 
		 * @param trailerNum
		 * @return Invoice
		 */
		public InvoiceBuilder shippingOnTrailer(String trailerNum) {
			managedInstance.trailerNumber = trailerNum;
			return this;
		}

		/**
		 * fluent setter for document number
		 * 
		 * @param docNumber
		 * @return
		 */
		public InvoiceBuilder withDocumentNumber(String docNumber) {
			managedInstance.supplierDocumentId = docNumber;
			return this;
		}

		/**
		 * fluent setter for Supplier
		 * 
		 * @param docNumber
		 * @return
		 */
		public InvoiceBuilder suppliedBy(InvoiceActor actor) {
			managedInstance.invoiceSupplier = actor;
			return this;
		}
		
		/**
		 * fluent setter for Destination
		 * 
		 * @param docNumber
		 * @return
		 */
		public InvoiceBuilder beingSentTo(InvoiceActor actor) {
			managedInstance.invoiceDestination = actor;
			return this;
		}

		/**
		 * fluent setter for items in the list
		 * 
		 * @param docNumber
		 * @return
		 */
		public InvoiceBuilder with(InvoiceItem item) {
			if (managedInstance.items == null) {
				managedInstance.items = new ArrayList<InvoiceItem>();
			}
			managedInstance.items.add(item);
			return this;
		}
		
		public Invoice build() {
			return managedInstance;
		}

	}
}
