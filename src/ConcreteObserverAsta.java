import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ConcreteObserverAsta implements ObserverAsta {

	private Squadra squadra;
	private HashMap<String, Integer> puntata;

	public ConcreteObserverAsta() {
		squadra = new Squadra();
		puntata = new HashMap<String,Integer>();
	}

	public HashMap<String, Integer> getPuntata() {
		return puntata;
	}

	public void setPuntata(HashMap<String, Integer> puntata) {
		this.puntata = puntata;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	@Override
	public boolean punta(String username, int puntata) {
		if(this.getPuntata().isEmpty()) {
			Integer oldValue = this.puntata.get(username);
			this.puntata.replace(username, oldValue, puntata);
			return true;
		}
		else {
			int max=Collections.max(this.puntata.values());
			if(puntata>max) {
				Integer oldValue = this.puntata.get(username);
				this.puntata.replace(username, oldValue, puntata);
				return true;
			}
			else return false;
		}
	}
	
	@Override
	public int puntaVirtuale(String username,int tipo){
		int newPuntata=0;
		int max;
		if(this.puntata.isEmpty())
			max=0;
		else
			max=Collections.max(this.puntata.values());
		int s;
		s = new Random().nextInt(2);
		int strategy = new Random().nextInt(3);
		
		if(s==0) {
			this.passa(username);
		}
		else {
			switch(strategy) {
			case 0: 
				SoftStrategy softStrategy = new SoftStrategy();
				newPuntata = softStrategy.puntaVirtuale(this, username, max,strategy);
				break;
			case 1: 
				MediumStrategy mediumStrategy = new MediumStrategy();
				newPuntata = mediumStrategy.puntaVirtuale(this, username, max,strategy);
				break;
			case 2:
				HardStrategy hardStrategy = new HardStrategy();
				newPuntata = hardStrategy.puntaVirtuale(this, username, max,strategy);
				break;
			default: System.out.println("Scelta non consentita");
			}
		}
		return newPuntata;
	}
	
	

	@Override
	public void passa(String username) {
		System.out.println("passa");
		this.puntata.remove(username);
		

	}

	@Override
	public String toString() {
		return "ConcreteObserverAsta [squadra=" + squadra + ", puntata=" + puntata + "]";
	}

}
