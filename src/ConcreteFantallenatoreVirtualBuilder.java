import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ConcreteFantallenatoreVirtualBuilder implements FantallenatoreBuilder{
	private String [] nomi= {"Antonio","Salvatore","Franco","Giuseppe","Andrea","Martina","Simone","Danilo"};
	private ArrayList<String> n =new ArrayList<>( Arrays.asList(nomi));
	private String [] cognomi = {"Rossi","Verdi","Bianchi","Neri","Gialli","Parrinello","Silvestri","Fontana","Boschetti"};
	private List<String> c = Arrays.asList(cognomi);
	private String [] password = {"abs3yYa","bcwbdbD1b","byufbvuH6fe","ygf8yvbyH8bvf","wyfrywTTv2","g7ywfv78wrv"};
	private Fantallenatore fantallenatore;
	
	public ConcreteFantallenatoreVirtualBuilder() {
		this.fantallenatore=new Fantallenatore();
	}
	
	public void addNome(String nome) {
		int i = new Random().nextInt(this.n.size()-1);
		nome = n.get(i);
		n.remove(i);
		fantallenatore.setNome(nome);
	}
	
	public void addCognome(String cognome) {
		int i = new Random().nextInt(7);
		cognome = cognomi[i];
		fantallenatore.setCognome(cognome);
	}
	
	public void addUsername(String username) {
		username = fantallenatore.getNome().concat(fantallenatore.getCognome());
		fantallenatore.setUsername(username);
	}
	
	public void addPassword(String pwd) {
		int i = new Random().nextInt(5);
		pwd = password[i];
		fantallenatore.setPassword(pwd);
	}
	
	public void addFantaCrediti() {
		fantallenatore.setFantaCrediti(500);
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatore;
	}
}
