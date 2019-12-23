
public class Director {
	private FantallenatoreBuilder fantallenatoreBuilder;
	
	public Director(FantallenatoreBuilder fantallenatoreBuilder) {
		this.fantallenatoreBuilder=fantallenatoreBuilder;
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatoreBuilder.getFantallenatore();
	}
	
	public void createFantallenatore() {
		this.fantallenatoreBuilder.addNome();
		this.fantallenatoreBuilder.addCognome();
		this.fantallenatoreBuilder.addUsername();
		this.fantallenatoreBuilder.addPassword();
		this.fantallenatoreBuilder.addFantaCrediti();
	}
}
