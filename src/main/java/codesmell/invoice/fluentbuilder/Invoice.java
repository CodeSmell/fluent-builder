package codesmell.invoice.fluentbuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.concurrent.Immutable;

@Immutable
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
	public static Builder builder() {
		return new Invoice.Builder();
	}
	
	/**
	 * forces use of the Builder
	 */
	private Invoice() {
	}

	public String getTrailerNumber() {
		return trailerNumber;
	}

	public String getSupplierDocumentId() {
		return supplierDocumentId;
	}

	public InvoiceActor getInvoiceSupplier() {
		return invoiceSupplier;
	}

	public InvoiceActor getInvoiceDestination() {
		return invoiceDestination;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public List<InvoiceItem> getItems() {
		return Collections.unmodifiableList(items);
	}

	/**
	 * more fluent Builder
	 */
	public static class Builder {
		private Invoice managedInstance = new Invoice();

		/**
		 * fluent setters for date
		 * @param date
		 * @return
		 */
		public Builder createdOn(Date date) {
			managedInstance.documentDate = date;
			return this;
		}

		/**
		 * fluent setter for trailer
		 * 
		 * @param trailerNum
		 * @return Invoice
		 */
		public Builder shippingOnTrailer(String trailerNum) {
			managedInstance.trailerNumber = trailerNum;
			return this;
		}

		/**
		 * fluent setter for document number
		 * 
		 * @param docNumber
		 * @return
		 */
		public Builder withDocumentNumber(String docNumber) {
			managedInstance.supplierDocumentId = docNumber;
			return this;
		}

		/**
		 * more fluent setter for Supplier
		 * @return
		 */
		public InvoiceActor.Builder suppliedBy() {
			Consumer<InvoiceActor> f = obj -> { managedInstance.invoiceSupplier = obj;};
			return new InvoiceActor.Builder(this, f);
		}

		/**
		 * more fluent setter for Destination
		 * 
		 * @param docNumber
		 * @return
		 */
		public InvoiceActor.Builder beingSentTo() {
			Consumer<InvoiceActor> f = obj -> { managedInstance.invoiceDestination = obj;};
			return new InvoiceActor.Builder(this, f);
		}

		/**
		 * fluent setter for items in the list
		 * 
		 * @param docNumber
		 * @return
		 */
		public InvoiceItem.Builder withItem() {
			if (managedInstance.items == null) {
				managedInstance.items = new ArrayList<InvoiceItem>();
			}
			Consumer<InvoiceItem> f = obj -> { managedInstance.items.add(obj);};
			return new InvoiceItem.Builder(this, f);
		}
		
		public Invoice build() {
			return managedInstance;
		}

	}
}
