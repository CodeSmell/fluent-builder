package codesmell.invoice.fluentbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import codesmell.invoice.builder.InvoiceItem;
import codesmell.invoice.fluentbuilder.Invoice;
import codesmell.invoice.fluentbuilder.InvoiceActor;
import codesmell.invoice.fluentbuilder.InvoiceActorType;

public class InvoiceMoreFluentBuilderTest {
	
	@Test
	public void test_InvoiceActor_with_more_fluent_builder() {
		InvoiceActor actor = InvoiceActor.builder()
				.named("101")
				.as(InvoiceActorType.DC)
				.build();
		
		assertNotNull(actor);
		assertEquals("101", actor.getActorName());
		assertEquals(InvoiceActorType.DC, actor.getActorType());
	}
	
	@Test
	public void test_InvoiceItem_with_more_fluent_builder() {
		InvoiceItem item = InvoiceItem.builder()
				.as("TK421")
				.orderedQuantity(10)
				.shippedQuantity(8)
				.build();
		
		assertNotNull(item);
		assertEquals("TK421", item.getItemGtin());
		assertEquals(new Integer(10), item.getQuantityRequested());
		assertEquals(new Integer(8), item.getQuantityShipped());
	}
	
	@Test
	public void test_with_more_fluent_builder() {
		
		Invoice inv = Invoice.builder()
				.createdOn(new Date())
				.withDocumentNumber("5150")
				.shippingOnTrailer("2112")
				.suppliedBy()
					.named("101")
					.as(InvoiceActorType.DC)
					.end()
				.beingSentTo()
					.named("42")
					.as(InvoiceActorType.STORE)
					.end()
				.withItem()
					.as("TK421")
					.orderedQuantity(10)
					.shippedQuantity(8)
					.end()
				.withItem()
					.as("FN2187")
					.orderedQuantity(5)
					.shippedQuantity(5)
					.end()
				.build();
		
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
