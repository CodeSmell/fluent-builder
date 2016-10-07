package codesmell.invoice.standard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class InvoiceStandardTest {

	@Test
	public void test_with_constructor_and_setters() {
		InvoiceActor supplier = new InvoiceActor();
		supplier.setActorName("101");
		supplier.setActorType(InvoiceActorType.DC);
		
		InvoiceActor reciever = new InvoiceActor();
		reciever.setActorName("42");
		reciever.setActorType(InvoiceActorType.STORE);
		
		List<InvoiceItem> list = new ArrayList<InvoiceItem>();
		InvoiceItem itemOne = new InvoiceItem("TK421", 10, 8);
		list.add(itemOne);
		InvoiceItem itemTwo = new InvoiceItem("FN2187", 5, 5);
		list.add(itemTwo);
		
		Invoice inv = new Invoice();
		inv.setSupplierDocumentId("5150");
		inv.setTrailerNumber("2112");
		inv.setInvoiceSupplier(supplier);
		inv.setInvoiceDestination(reciever);
		inv.setItems(list);
		
		assertNotNull(inv);
		assertEquals("5150", inv.getSupplierDocumentId());
		assertEquals("2112", inv.getTrailerNumber());
		assertNotNull(inv.getInvoiceSupplier());
		assertEquals("101", inv.getInvoiceSupplier().getActorName());
		assertNotNull(inv.getInvoiceDestination());
		assertEquals("42", inv.getInvoiceDestination().getActorName());
		assertEquals(2, inv.getItems().size());
		assertEquals("TK421", inv.getItems().get(0).getItemGtin());
	}
	
	@Test
	public void test_with_constructors() {
		InvoiceActor supplier = new InvoiceActor("101", InvoiceActorType.DC);
		InvoiceActor reciever = new InvoiceActor("42", InvoiceActorType.STORE);
		
		List<InvoiceItem> list = new ArrayList<InvoiceItem>();
		InvoiceItem itemOne = new InvoiceItem("TK421", 10, 8);
		list.add(itemOne);
		InvoiceItem itemTwo = new InvoiceItem("FN2187", 5, 5);
		list.add(itemTwo);
		
		Invoice inv = new Invoice(supplier, reciever, "5150", new Date(), "2112", list);
		
		assertNotNull(inv);
		assertEquals("5150", inv.getSupplierDocumentId());
		assertEquals("2112", inv.getTrailerNumber());
		assertNotNull(inv.getInvoiceSupplier());
		assertEquals("101", inv.getInvoiceSupplier().getActorName());
		assertNotNull(inv.getInvoiceDestination());
		assertEquals("42", inv.getInvoiceDestination().getActorName());
		assertEquals(2, inv.getItems().size());
		assertEquals("TK421", inv.getItems().get(0).getItemGtin());
	}
	
}
