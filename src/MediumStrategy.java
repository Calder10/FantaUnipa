
public class MediumStrategy implements AstaStrategy{

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
			if(puntata>20) {
				puntata=0;
				o.passa(username);
				
			}
			else {
				o.getPuntata().replace(username, oldValue,puntata);
			}
			break;
			
		case 2:
			puntata = max+5;
			if(puntata>20) {
				puntata=0;
				o.passa(username);
				
			}
			else {
				o.getPuntata().replace(username, oldValue,puntata);
			}
			break;
			
		case 3:
			puntata = max+1;
			if(puntata>25) {
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