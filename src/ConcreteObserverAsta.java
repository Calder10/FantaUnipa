
public class ConcreteObserverAsta implements ObserverAsta{
	
	private Squadra squadra;
	private int puntata;

	public int getPuntata() {
		return puntata;
	}

	public void setPuntata(int puntata) {
		this.puntata = puntata;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	@Override
	public void punta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rilancia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "ConcreteObserverAsta [squadra=" + squadra + ", puntata=" + puntata + "]";
	}
	
	

}
