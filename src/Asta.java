import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Asta implements SubjectAsta{
	
	private Giocatore giocatore ;
	private Fantallenatore f;
	int puntataCorrente;
	private ArrayList<ConcreteObserverAsta> obs;
	
	
	public Asta(Giocatore giocatore, int puntataCorrente) throws ClassNotFoundException, IOException {
		this.giocatore=giocatore;
		this.puntataCorrente=puntataCorrente;
		this.loadFantallenatori();
	}
	
	

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public int getPuntataCorrente() {
		return puntataCorrente;
	}

	public void setPuntataCorrente(int puntataCorrente) {
		this.puntataCorrente = puntataCorrente;
	}

	public ArrayList<ConcreteObserverAsta> getObs() {
		return obs;
	}

	public void setObs(ArrayList<ConcreteObserverAsta> obs) {
		this.obs = obs;
	}

	public void loadFantallenatori() throws IOException, ClassNotFoundException {
		obs = new ArrayList<ConcreteObserverAsta>();
		File f = new File("src/Squadre");
		if(f.isDirectory()) {
			File [] files = f.listFiles();
			for(File x : files) {
				FileInputStream fis = new FileInputStream(x);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ConcreteObserverAsta o = new ConcreteObserverAsta();
				Squadra aus = (Squadra) ois.readObject();
				o.setSquadra(aus);
				obs.add(o);
				ois.close();
				fis.close();
			}
		}
		
	}

	@Override
	public void addFantallenatore(Fantallenatore f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAllObserver(String username){
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if(usr.equalsIgnoreCase(username)==false) {
				o.setPuntata(this.puntataCorrente);
				System.out.println(o.toString());
			}
		}
		
	}

	@Override
	public void removeFantallenatore(Fantallenatore f) {
		// TODO Auto-generated method stub
		
	}

}
