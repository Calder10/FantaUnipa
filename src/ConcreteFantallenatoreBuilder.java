/**
 * Classe per la creazione del fantallenatore
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */

public class ConcreteFantallenatoreBuilder implements FantallenatoreBuilder{
	private Fantallenatore fantallenatore;
	
	/**
     * Costruttore della classe.
     * 
     */
	public ConcreteFantallenatoreBuilder() {
		this.fantallenatore=new Fantallenatore();
	}
	
	
	/**
	 *Metodo che setta il nome del fantallenatore
	 *@param nome del fantallenatore
	 */
	public void addNome(String nome) {
		fantallenatore.setNome(nome);
	}
	
	/**
	 *Metodo che setta il cognome del fantallenatore
	 *@param cognome del fantallenatore
	 */
	public void addCognome(String cognome) {
		fantallenatore.setCognome(cognome);
	}
	
	/**
	 *Metodo che setta l'username del fantallenatore
	 *@param username del fantallenatore
	 */
	public void addUsername(String username) {
		fantallenatore.setUsername(username);
	}
	
	/**
	 *Metodo che setta la password del fantallenatore
	 *@param password del fantallenatore
	 */
	public void addPassword(String password) {
		fantallenatore.setPassword(password);
	}
	
	/**
	 *Metodo che setta i fantacrediti del fantallenatore
	 
	 */
	public void addFantaCrediti() {
		fantallenatore.setFantaCrediti(500);
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatore;
	}
}
