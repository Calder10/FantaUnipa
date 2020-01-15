/**
 * Interfaccia per la gestione delle strategie applicate dai fantallenatori virtuali per l'acquisto di un determinato giocatore
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */
public interface AstaStrategy {
	
	/**
	 * 
	 * @param o osservatore che ha effettuato la prima puntata
	 * @param username del fantallenatore virtuale
	 * @param max puntata massima 
	 * @param tipo per identificare il ruolo del giocatore per cui si sta svolgendo l'asta
	 * @return la puntata del fantallenatore virtuale
	 */
	public int puntaVirtuale(ConcreteObserverAsta o, String username, int max,int tipo);
}