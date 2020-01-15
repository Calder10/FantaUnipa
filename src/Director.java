
/**
 * Classe che dirige la costruzione dei fantallenatori tramite pattern builder
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */

public class Director {
	private FantallenatoreBuilder fantallenatoreBuilder;
	
	/**
     * Costruttore della classe.
     * 
     * @param fantallenatoreBuilder fantallenatore da costruire
     * 
     */
	public Director(FantallenatoreBuilder fantallenatoreBuilder) {
		this.fantallenatoreBuilder=fantallenatoreBuilder;
	}
	
	public Fantallenatore getFantallenatore() {
		return this.fantallenatoreBuilder.getFantallenatore();
	}
	
	/**
	 * Metodo che crea il fantallenatore 
	 * 
	 * @param nome del fantallenatore
	 * @param cognome del fantallenatore
	 * @param username del fantallenatore
	 * @param password del fantallenatore
	 */
	public void createFantallenatore(String nome,String cognome,String username, String password) {
		this.fantallenatoreBuilder.addNome(nome);
		this.fantallenatoreBuilder.addCognome(cognome);
		this.fantallenatoreBuilder.addUsername(username);
		this.fantallenatoreBuilder.addPassword(password);
		this.fantallenatoreBuilder.addFantaCrediti();
	}
}
