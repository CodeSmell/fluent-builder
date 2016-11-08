package codesmell.invoice.fluentbuilder;

import java.util.function.Consumer;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class InvoiceActor {

	private String actorName;
	private InvoiceActorType actorType;

	/**
	 * static factory method for builder
	 */
	public static Builder builder() {
		return new InvoiceActor.Builder();
	}
	
	/**
	 * forces use of the Builder
	 */
	private InvoiceActor() {
	}
	
	public String getActorName() {
		return actorName;
	}

	public InvoiceActorType getActorType() {
		return actorType;
	}

	public static class Builder {
		private InvoiceActor managedInstance = new InvoiceActor();
		private Invoice.Builder parentBuilder;
		private Consumer<InvoiceActor> callback;
		
		public Builder() {
		}
		
		public Builder(Invoice.Builder b, Consumer<InvoiceActor> f) {
			this.parentBuilder = b;
			this.callback = f;
		}
		
		/**
		 * fluent setter for actor name
		 * 
		 * @param name
		 * @return
		 */
		public Builder named(String name) {
			managedInstance.actorName = name;
			return this;
		}

		/**
		 * fluent setter for actor type
		 * 
		 * @param type
		 * @return
		 */
		public Builder as(InvoiceActorType type) {
			managedInstance.actorType = type;
			return this;
		}
		
		/**
		 * build 
		 * @return
		 */
		public InvoiceActor build() {
			return managedInstance;
		}

		/**
		 * end 
		 * @return
		 */
		public Invoice.Builder end() {
			callback.accept(managedInstance);
			return parentBuilder;
		}
		
	}		
}
