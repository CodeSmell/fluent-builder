package codesmell.invoice.standard;

import java.util.Date;
import java.util.List;

public class Invoice {

	private InvoiceActor invoiceSupplier;
	private InvoiceActor invoiceDestination;

	private String supplierDocumentId;
	private Date documentDate;

	private String trailerNumber;

	private List<InvoiceItem> items;

 	public Invoice() {
	}

	public Invoice(InvoiceActor supplier, InvoiceActor dest, String docId, Date docDate, String trailer,
			List<InvoiceItem> list) {
		this.invoiceSupplier = supplier;
		this.invoiceDestination = dest;
		this.supplierDocumentId = docId;
		this.documentDate = docDate;
		this.trailerNumber = trailer;
		this.items = list;
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
