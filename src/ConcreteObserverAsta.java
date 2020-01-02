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
		System.out.println("punta");
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
	public int puntaVirtuale(String username){
		System.out.println("punta virtuale");
		Integer oldValue = this.puntata.get(username);
		int fantaCrediti = this.squadra.getFantallenatore().getFantaCrediti();
		int newPuntata=0;
		int max=Collections.max(this.puntata.values());
		int aus;
		int s;
		s = new Random().nextInt(2);
		int strat = new Random().nextInt(3);
		
		if(s==0) {
			this.passa(username);
		}
		else {
			if(strat==0) {
				newPuntata=max+1;
				if(newPuntata>30)
					this.passa(username);
				this.puntata.replace(username, oldValue, newPuntata);
			}
			if(strat==1) {
				newPuntata=max+5;
				if(newPuntata>30)
					this.passa(username);
				this.puntata.replace(username, oldValue, newPuntata);
			}
			if(strat==2) {
				newPuntata=max+10;
				if(newPuntata>30)
					this.passa(username);
				this.puntata.replace(username, oldValue, newPuntata);
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
