package codesmell.invoice.builder;

public class InvoiceActor {

	private String actorName;
	private InvoiceActorType actorType;

	public static InvoiceActorBuilder builder() {
		return new InvoiceActor.InvoiceActorBuilder();
	}

	private InvoiceActor() {
	}
	
	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public InvoiceActorType getActorType() {
		return actorType;
	}

	public void setActorType(InvoiceActorType actorType) {
		this.actorType = actorType;
	}

	public static class InvoiceActorBuilder {
		private InvoiceActor managedInstance = new InvoiceActor();
		
		public InvoiceActorBuilder() {
		}

		/**
		 * fluent setter for actor name
		 * 
		 * @param name
		 * @return
		 */
		public InvoiceActorBuilder named(String name) {
			managedInstance.actorName = name;
			return this;
		}

		/**
		 * fluent setter for actor type
		 * 
		 * @param type
		 * @return
		 */
		public InvoiceActorBuilder as(InvoiceActorType type) {
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
	}		
}
