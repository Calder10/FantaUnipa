
public class Director {
	private FantallenatoreBuilder fantallenatoreBuilder;
	
	public Director(FantallenatoreBuilder fantallenatoreBuilder) {
		this.fantallenatoreBuilder=fantallenatoreBuilder;
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatoreBuilder.getFantallenatore();
	}
	
	public void createFantallenatore(String nome,String cognome,String username, String password) {
		this.fantallenatoreBuilder.addNome(nome);
		this.fantallenatoreBuilder.addCognome(cognome);
		this.fantallenatoreBuilder.addUsername(username);
		this.fantallenatoreBuilder.addPassword(password);
		this.fantallenatoreBuilder.addFantaCrediti();
	}
}
