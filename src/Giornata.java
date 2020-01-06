import java.io.IOException;
import java.util.ArrayList;

public class Giornata extends Torneo{


	private ArrayList<Partita> partite;
	

	public void addGiornata() {
		giornate.add(this);
		
	}

	public void addPartita(Partita p) {
		this.partite.add(p);
	}
	

}
