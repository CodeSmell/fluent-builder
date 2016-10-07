package codesmell.invoice.standard;

public class InvoiceActor {

	private String actorName;
	private InvoiceActorType actorType;

	public InvoiceActor() {
	}

	public InvoiceActor(String name, InvoiceActorType type) {
		this.actorName = name;
		this.actorType = type;
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
