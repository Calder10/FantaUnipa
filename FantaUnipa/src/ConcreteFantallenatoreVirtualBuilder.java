import java.util.Random;

public class ConcreteFantallenatoreVirtualBuilder implements FantallenatoreBuilder{
	private String [] nomi= {"Antonio","Salvatore","Franco","Giuseppe","Andrea","Martina","Simone","Danilo"};
	private String [] cognomi = {"Rossi","Verdi","Bianchi","Neri"};
	private String [] password = {"abs3yYa","bcwbdbD1b","byufbvuH6fe","ygf8yvbyH8bvf","wyfrywTTv2","g7ywfv78wrv"};
	private Fantallenatore fantallenatore;
	
	public ConcreteFantallenatoreVirtualBuilder() {
		this.fantallenatore=new Fantallenatore();
	}
	
	public void addNome() {
		int i = new Random().nextInt(7);
		String nome = nomi[i];
		fantallenatore.setNome(nome);
	}
	
	public void addCognome() {
		int i = new Random().nextInt(3);
		String cognome = cognomi[i];
		fantallenatore.setCognome(cognome);
	}
	
	public void addUsername() {
		String username = fantallenatore.getNome().concat(fantallenatore.getCognome());
		fantallenatore.setUsername(username);
	}
	
	public void addPassword() {
		int i = new Random().nextInt(5);
		String pwd = password[i];
		fantallenatore.setPassword(pwd);
	}
	
	public void addFantaCrediti() {
		fantallenatore.setFantaCrediti(500);
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatore;
	}
}
