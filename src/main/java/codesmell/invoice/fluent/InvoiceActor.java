package codesmell.invoice.fluent;

public class InvoiceActor {

	private String actorName;
	private InvoiceActorType actorType;

	/**
	 * static factory method used to create object
	 * @return
	 */
	public static InvoiceActor create() {
		return new InvoiceActor();
	}
	
	/**
	 * fluent setter for actor name
	 * @param name
	 * @return
	 */
	public InvoiceActor named(String name) {
		this.actorName = name;
		return this;
	}
	
	/**
	 * fluent setter for actor type
	 * @param type
	 * @return
	 */
	public InvoiceActor as(InvoiceActorType type) {
		this.actorType = type;
		return this;
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
}
