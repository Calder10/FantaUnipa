/** Classe che implementa l'interfaccia strategy.
 * @author Calvatore Calderaro
 * @author Gaspare Casano
 *
 */
public class MediumStrategy implements AstaStrategy{
	
	

	/** Metodo che permette all'utente virtuale di rilanciare di 5 rispetto alla puntata massima o eventualmente rinucniare
     * 
     * @param o osservatore che ha effettuato la prima puntata
     * @param username del fantallenatore virtuale
     * @param max puntata massima 
     * @param tipo per identificare il ruolo del giocatore per cui si sta svolgendo l'asta
     * @return la puntata del fantallenatore virtuale (0 nel caso in cui rinuncia).
     */
	public int puntaVirtuale(ConcreteObserverAsta o,String username,int max,int tipo) {
		int puntata=0;
		Integer oldValue = o.getPuntata().get(username);
		switch(tipo) {
		case 0:
			puntata = max+5;
			if(puntata>30) {
				puntata=0;
				o.passa(username);
				
			}
			else {
				o.getPuntata().replace(username, oldValue,puntata);
			}
			break;
		case 1:
			puntata = max+5;
			if(puntata>30) {
				puntata=0;
				o.passa(username);
				
			}
			else {
				o.getPuntata().replace(username, oldValue,puntata);
			}
			break;
			
		case 2:
			puntata = max+5;
			if(puntata>30) {
				puntata=0;
				o.passa(username);
				
			}
			else {
				o.getPuntata().replace(username, oldValue,puntata);
			}
			break;
			
		case 3:
			puntata = max+1;
			if(puntata>30) {
				puntata=0;
				o.passa(username);
				
			}
			else {
				o.getPuntata().replace(username, oldValue,puntata);
			}
			break;
		}
		return puntata;
	}

}