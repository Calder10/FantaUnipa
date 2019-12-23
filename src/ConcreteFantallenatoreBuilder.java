
public class ConcreteFantallenatoreBuilder implements FantallenatoreBuilder{
	private Fantallenatore fantallenatore;
	
	public ConcreteFantallenatoreBuilder() {
		this.fantallenatore=new Fantallenatore();
	}
	
	public void addNome(String nome) {
		fantallenatore.setNome(nome);
	}
	
	public void addCognome(String cognome) {
		fantallenatore.setCognome(cognome);
	}
	
	public void addUsername(String username) {
		fantallenatore.setUsername(username);
	}
	
	public void addPassword(String password) {
		fantallenatore.setPassword(password);
	}
	
	public void addFantaCrediti() {
		fantallenatore.setFantaCrediti(500);
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatore;
	}
}
