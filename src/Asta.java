import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JTextArea;

public class Asta implements SubjectAsta{
	
	private Giocatore giocatore ;
	private Fantallenatore f;
	private HashMap<String,Integer> puntataCorrente;
	private ArrayList<ConcreteObserverAsta> obs;
	
	
	public Asta(Giocatore giocatore) throws ClassNotFoundException, IOException {
		this.giocatore=giocatore;
		this.loadFantallenatori();
	}
	
		
	

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	

	public HashMap<String, Integer> getPuntataCorrente() {
		return puntataCorrente;
	}



	public void setPuntataCorrente(HashMap<String, Integer> puntataCorrente) {
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
		this.puntataCorrente=new HashMap<>();
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
				String s = aus.getFantallenatore().getUsername();
				this.puntataCorrente.put(s,0);
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
	public void notifyAllObserver(String username,int puntata){
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if(usr.equalsIgnoreCase(username)==false) {
				Integer oldValue = this.puntataCorrente.get(username);
				this.puntataCorrente.replace(username, oldValue, puntata);
				//System.out.println(puntataCorrente.toString());
			}
		}
		
	}

	@Override
	public void removeFantallenatore(Fantallenatore f) {
		// TODO Auto-generated method stub
		
	}
	
	public String stampaPuntata(String username) {
		String valore = puntataCorrente.get(username).toString();
		return username+": "+valore+"\n";
	}

}
