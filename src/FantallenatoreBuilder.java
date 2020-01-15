
/**
 * Interfaccia per la costruzione del fantallenatore
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */

public interface FantallenatoreBuilder {
	
	/**
	 *Metodo che setta il nome del fantallenatore
	 *@param cognome del fantallenatore
	 */
	public void addNome(String nome);
	/**
	 *Metodo che setta il cognome del fantallenatore
	 *@param cognome del fantallenatore
	 */

	public void addCognome(String cognome);
	
	/**
	 *Metodo che setta username del fantallenatore
	 *@param cognome del fantallenatore
	 */

	public void addUsername(String username);
	
	/**
	 *Metodo che setta la password del fantallenatore
	 *@param username del fantallenatore
	 */

	public void addPassword(String password);
	
	/**
	 *Metodo che setta i fantacrediti del fantallenatore
	 */

	public void addFantaCrediti();

	public Fantallenatore getFantallenatore();
}
