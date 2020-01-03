
public class SoftStrategy implements AstaStrategy{

	public int puntaVirtuale(ConcreteObserverAsta o,String username,int max) {
		int puntata;
		Integer oldValue = o.getPuntata().get(username);
		puntata = max+1;
		if(puntata>30) {
			puntata=0;
			o.passa(username);
			
		}
		else {
			o.getPuntata().replace(username, oldValue,puntata);
		}
		return puntata;
	}
	
}