
public class ConcreteFantallenatoreBuilder implements FantallenatoreBuilder{
	private Fantallenatore fantallenatore;
	
	public ConcreteFantallenatoreBuilder() {
		this.fantallenatore=new Fantallenatore();
	}
	
	public void addNome() {
		fantallenatore.setNome("Pippo");
	}
	
	public void addCognome() {
		fantallenatore.setCognome("Rossi");
	}
	
	public void addUsername() {
		fantallenatore.setUsername("Pippo1925");
	}
	
	public void addPassword() {
		fantallenatore.setPassword("santozafonte");
	}
	
	public void addFantaCrediti() {
		fantallenatore.setFantaCrediti(100);
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatore;
	}
}
