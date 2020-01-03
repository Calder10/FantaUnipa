import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Asta implements SubjectAsta{
	
	private Giocatore giocatore ;
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
	
	@Override
	public void loadFantallenatori() throws IOException, ClassNotFoundException{
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
	public void notifyAllObserver(String username,int puntata){
		System.out.println("notifyall");
		for (ConcreteObserverAsta o : obs) {
			String usr = o.getSquadra().getFantallenatore().getUsername();
			if(usr.equalsIgnoreCase(username)==false) {
				Integer oldValue = this.puntataCorrente.get(username);
				this.puntataCorrente.replace(username, oldValue, puntata);
			}
			o.setPuntata(this.puntataCorrente);
		}
	}

	
	public String stampaPuntata(String username) {
		Set<String> keys  = this.puntataCorrente.keySet();
		if(keys.contains(username)) {
			String valore = puntataCorrente.get(username).toString();
			return username+": "+valore+"\n\n";
		}
		else {
			return username+" ha rinunciato !\n\n";
		}
	}
	
	public void puntateVirtuali(String username,JTextArea textArea,JButton btnNewButtonRilancia) {
		System.out.println("puntateVirtuali");
		textArea.setVisible(true);
		btnNewButtonRilancia.setVisible(true);
		ArrayList<ConcreteObserverAsta> delete = new ArrayList<>();
		for(ConcreteObserverAsta o : obs) {
			String usr=o.getSquadra().getFantallenatore().getUsername();
			if(username.equalsIgnoreCase(usr)==false){
				int ris = o.puntaVirtuale(usr);
				if(ris==0) {
					delete.add(o);
					this.notifyAllObserver(usr, ris);
					textArea.append(this.stampaPuntata(usr));
				}
				else {
					this.notifyAllObserver(usr, ris);
					textArea.append(this.stampaPuntata(usr));
				}
			}
		}
		for (ConcreteObserverAsta o : delete) {
			this.obs.remove(o);
		}
	}
	
	public void simulaAsta(AstaGiocatoreGUI astaGiocatoreGUI, JTextField textField,String username,JTextArea textArea, JButton btnNewButtonRinuncia) {
		System.out.println("Prova");
		ConcreteObserverAsta o =null;
		for(ConcreteObserverAsta ob : obs) {
			if(ob.getSquadra().getFantallenatore().getUsername().equalsIgnoreCase(username)) {
				o=ob;
			}
		}
		if (o.getSquadra().getPortieri().size()<3) {
			int puntata = Integer.parseInt(textField.getText());
			try {
				boolean ris = o.punta(username, puntata);
				if(ris==true) {
					HashMap<String, Integer> aus = this.getPuntataCorrente();
					Integer oldValue = aus.get(username);
					aus.replace(username, oldValue, puntata);
					this.setPuntataCorrente(aus);
					this.notifyAllObserver(username, puntata);
					this.puntateVirtuali(username, textArea,btnNewButtonRinuncia);
					int dim = this.getPuntataCorrente().size();
					if (dim == 1) {
						String key = "";
						int value = 0;
						System.out.println(this.getGiocatore().getNomeGiocatore() + " aggiudicato");
						Set<String> keys = this.getPuntataCorrente().keySet();
						for (String s : keys) {
							key = s;
							value = this.getPuntataCorrente().get(s);
						}

						ArrayList<ConcreteObserverAsta> oss = this.getObs();
						Squadra s;
						for (ConcreteObserverAsta o1 : oss) {
							if (key.equalsIgnoreCase(o1.getSquadra().getFantallenatore().getUsername())) {
								s=o1.getSquadra();
								o1.getSquadra().getFantallenatore().setFantaCrediti(value);
								o1.getSquadra().addPortiere((Portiere) this.getGiocatore());
								System.out.println(o1.getSquadra().getPortieri().toString());
								s.updateSquadra();
								UtilityListaGiocatori.giocatoreAcquistato(0, this.giocatore.getNomeGiocatore());
								JOptionPane.showMessageDialog(textField, "Ti sei aggiudicato: "+this.giocatore.getNomeGiocatore());
								astaGiocatoreGUI.dispose();
							}
						}
						
						
						
					}
				}
				else {
					JOptionPane.showMessageDialog(textField, "Puntata non consentita!");
				}
			}catch(Exception e) {
				System.out.println("Errore");
			}
		}
		else {
			this.getObs().remove(o);
		}
		System.out.println(o.getSquadra().getPortieri().toString());
		
	}

}
