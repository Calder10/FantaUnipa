import java.io.IOException;
import java.util.ArrayList;

/** Interfaccia contenente i metodi base per effettuare un'asta
 * @author Salvatore Calderaro
 *
 */
public interface SubjectAsta {
	
	/** Metodo che carica i fantallenatori che devono partecipare all'asta 
	 * @param tipo intero che rappresenta il ruolo del giocatore per cui si sta svolgendo l'asta
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadFantallenatori(int tipo) throws IOException,ClassNotFoundException;
	
	/** Metodo che notifica a tutti gli altri partecipanti all'asta la puntata di un determinato utente 
	 * @param username dell'utente che effettua la puntata 
	 * @param puntata valore della puntata  
	 */
	public void notifyAllObserver(String username,int puntata);


}
