
/** Intefaccia contenente dei metodi di base che verranno utilizzati dall'utente per effettuare l'asta
 * @author Calvatore Calderaro
 * @author Gaspare Casano
 *
 */
public interface ObserverAsta {
	
	
	/**
	 * @param username dell'utente che sta effettuando la puntata 
	 * @param puntata valore della puntata 
	 * @return true se la puntata è accettata, false altrimenti
	 */
	public boolean punta(String username,int puntata);
	public int puntaVirtuale(String username,int tipo);
	public void passa(String username);
	
}
