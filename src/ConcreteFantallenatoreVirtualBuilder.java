import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Classe per la creazione dei fantallenatori virtuali
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */
public class ConcreteFantallenatoreVirtualBuilder implements FantallenatoreBuilder{
	private String [] nomi= {"Antonio","Salvatore","Franco","Giuseppe","Andrea","Martina","Simone","Danilo"};
	private ArrayList<String> n =new ArrayList<>( Arrays.asList(nomi));
	private String [] cognomi = {"Rossi","Verdi","Bianchi","Neri","Gialli","Parrinello","Silvestri","Fontana","Boschetti"};
	private List<String> c = Arrays.asList(cognomi);
	private String [] password = {"abs3yYa","bcwbdbD1b","byufbvuH6fe","ygf8yvbyH8bvf","wyfrywTTv2","g7ywfv78wrv"};
	private Fantallenatore fantallenatore;
	
	/**
     * Costruttore della classe.
     * 
     */
	public ConcreteFantallenatoreVirtualBuilder() {
		this.fantallenatore=new Fantallenatore();
	}
	/**
	 *Metodo che setta il nome dei fantallenatori virtuali
	 *@param nome dei fantallenatori virtuali
	 */
	public void addNome(String nome) {
		int i = new Random().nextInt(this.n.size()-1);
		nome = n.get(i);
		n.remove(i);
		fantallenatore.setNome(nome);
	}
	/**
	 *Metodo che setta il cognome dei fantallenatori virtuali
	 *@param cognome dei fantallenatori virtuali
	 */
	public void addCognome(String cognome) {
		int i = new Random().nextInt(7);
		cognome = cognomi[i];
		fantallenatore.setCognome(cognome);
	}
	
	/**
	 *Metodo che setta username dei fantallenatori virtuali
	 *@param username dei fantallenatori virtuali
	 */
	
	public void addUsername(String username) {
		username = fantallenatore.getNome().concat(fantallenatore.getCognome());
		fantallenatore.setUsername(username);
	}
	
	/**
	 *Metodo che setta la password dei fantallenatori virtuali
	 *@param pwd passwrod dei fantallenatori virtuali
	 */
	public void addPassword(String pwd) {
		int i = new Random().nextInt(5);
		pwd = password[i];
		fantallenatore.setPassword(pwd);
	}
	
	/**
	 *Metodo che setta i fantacrediti dei fantallenatori virtuali
	 */
	public void addFantaCrediti() {
		fantallenatore.setFantaCrediti(500);
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatore;
	}
}
