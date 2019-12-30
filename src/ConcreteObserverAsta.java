import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ConcreteObserverAsta implements ObserverAsta {

	private Squadra squadra;
	private HashMap<String, Integer> puntata;

	public ConcreteObserverAsta() {
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
	public void punta(String username, int puntata) {
		Integer oldValue = this.puntata.get(username);
		this.puntata.replace(username, oldValue, puntata);

	}

	public int puntaVirtuale(String username) throws Exception{
		System.out.println(this.puntata.toString());
		Integer oldValue = this.puntata.get(username);
		int fantaCrediti = this.squadra.getFantallenatore().getFantaCrediti();
		int newPuntata=0;
		int max=Collections.max(this.puntata.values());
		int aus;
		if (fantaCrediti > 0) {
			while (true) {
				newPuntata = new Random().nextInt(30);
				if (newPuntata < max)
					newPuntata = new Random().nextInt(30);
				else {
					this.puntata.replace(username, oldValue, newPuntata);
					break;
				}
			}
		}
		return newPuntata;
	}

	@Override
	public void rilancia(String username) {
		String usr = this.squadra.getFantallenatore().getUsername();
		if (usr.equalsIgnoreCase(username) == true) {
			int s;
			s = new Random().nextInt(1);
			if (s == 0) {
				this.passa(username);
			} else {
				int fantaCrediti = this.squadra.getFantallenatore().getFantaCrediti();
				if (fantaCrediti > 0) {
					while (true) {
						HashMap.Entry<String, Integer> maxValue = null;
						for (HashMap.Entry<String, Integer> value : puntata.entrySet()) {
							if (maxValue == null || value.getValue().compareTo(maxValue.getValue()) > 0) {
								maxValue = value;
							}
						}
						int newPuntata = new Random().nextInt(30);
						if (newPuntata < maxValue.getValue())
							newPuntata = new Random().nextInt(30);
						else {
							Integer oldValue = this.puntata.get(username);
							this.puntata.replace(username, oldValue, newPuntata);
						}

					}
				}
			}
		}

	}

	@Override
	public void passa(String username) {
		Integer oldValue = this.puntata.get(username);
		this.puntata.replace(username, oldValue, -1);

	}

	@Override
	public String toString() {
		return "ConcreteObserverAsta [squadra=" + squadra + ", puntata=" + puntata + "]";
	}

}
