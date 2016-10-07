package codesmell.invoice.fluent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class InvoiceFluentTest {

	@Test
	public void test_with_static_factory_and_fluent() {
		
		Invoice inv = Invoice.createdOn(new Date())
				.withDocumentNumber("5150")
				.shippingOnTrailer("2112")
				.suppliedBy(InvoiceActor.create().named("101").as(InvoiceActorType.DC))
				.beingSentTo(InvoiceActor.create().named("42").as(InvoiceActorType.STORE))
				.with(InvoiceItem.create().as("TK421").orderedQuantity(10).shippedQuantity(8))
				.with(InvoiceItem.create().as("FN2187").orderedQuantity(5).shippedQuantity(5));
		
		assertNotNull(inv);
		assertEquals("5150", inv.getSupplierDocumentId());
		assertEquals("2112", inv.getTrailerNumber());
		assertNotNull(inv.getInvoiceSupplier());
		assertEquals("101", inv.getInvoiceSupplier().getActorName());
		assertNotNull(inv.getInvoiceDestination());
		assertEquals("42", inv.getInvoiceDestination().getActorName());
		assertEquals(2, inv.getItems().size());
		assertEquals("TK421", inv.getItems().get(0).getItemGtin());
		assertEquals("FN2187", inv.getItems().get(1).getItemGtin());
	}

}
