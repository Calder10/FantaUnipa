import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/** Classe per la gestione di una singola partita.
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Partita implements Serializable{
	
	
	private static final long serialVersionUID = 8300870919346163806L;
	private Squadra squadraCasa;
	private Squadra squadraTrasferta;
	private String risultato;
	private Formazione formazioneSquadraCasa;
	private Formazione formazioneSquadraTrasferta;
	private HashMap<String,Double> votiSquadraCasa;
	private HashMap<String,Double> votiSquadraTrasferta;
	private ArrayList<String> panoramicaVotiCasa;
	private ArrayList<String> panoramicaVotiTrasferta;
	
	public ArrayList<String> getPanoramicaVotiCasa() {
		return panoramicaVotiCasa;
	}

	
	public void setPanoramicaVotiCasa(ArrayList<String> panoramicaVotiCasa) {
		this.panoramicaVotiCasa = panoramicaVotiCasa;
	}

	
	public ArrayList<String> getPanoramicaVotiTrasferta() {
		return panoramicaVotiTrasferta;
	}

	
	public void setPanoramicaVotiTrasferta(ArrayList<String> panoramicaVotiTrasferta) {
		this.panoramicaVotiTrasferta = panoramicaVotiTrasferta;
	}

	
	public HashMap<String, Double> getVotiSquadraCasa() {
		return votiSquadraCasa;
	}

	
	public void setVotiSquadraCasa(HashMap<String, Double> votiSquadraCasa) {
		this.votiSquadraCasa = votiSquadraCasa;
	}

	
	public HashMap<String, Double> getVotiSquadraTrasferta() {
		return votiSquadraTrasferta;
	}

	
	public void setVotiSquadraTrasferta(HashMap<String, Double> votiSquadraTrasferta) {
		this.votiSquadraTrasferta = votiSquadraTrasferta;
	}

	
	
	
	/**
	 * @param casa Squadra che gioca in casa
	 * @param trasferta squadra che gioca in trasferta
	 */
	public Partita (Squadra casa, Squadra trasferta) {
		this.squadraCasa=casa;
		this.squadraTrasferta=trasferta;
		this.risultato=" - ";
	}
	
	public Squadra getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(Squadra squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public Squadra getSquadraTrasferta() {
		return squadraTrasferta;
	}

	public void setSquadraTrasferta(Squadra squadraTrasferta) {
		this.squadraTrasferta = squadraTrasferta;
	}

	public String getRisultato() {
		return risultato;
	}

	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}
	
	
	public Formazione getFormazioneSquadraCasa() {
		return formazioneSquadraCasa;
	}

	public void setFormazioneSquadraCasa(Formazione formazioneSquadraCasa) {
		this.formazioneSquadraCasa = formazioneSquadraCasa;
	}

	public Formazione getFormazioneSquadraTrasferta() {
		return formazioneSquadraTrasferta;
	}

	public void setFormazioneSquadraTrasferta(Formazione formazioneSquadraTrasferta) {
		this.formazioneSquadraTrasferta = formazioneSquadraTrasferta;
	}
	
	
	/**Metodo che calcola il risultato della partita
	 * 
	 */
	public void calcolaRisultato() {
		double casa =0.0;
		double trasferta=0.0;
		int numeriGolCasa=0;
		int numeriGolTrasferta=0;
		Set<String> keys = this.votiSquadraCasa.keySet();
		for(String key : keys) {
			casa+=this.votiSquadraCasa.get(key);
		}
		keys = this.votiSquadraTrasferta.keySet();
		for(String key : keys) {
			trasferta+=this.votiSquadraTrasferta.get(key);
		}
		int aus;
		if(casa>=66.0) {
			numeriGolCasa=1;
			aus=72;
			while(aus<=casa) {
				numeriGolCasa++;
				aus+=6;
			}
		}
		aus=0;
		if(trasferta>=66.0) {
			numeriGolTrasferta=1;
			aus=72;
			while(aus<=trasferta) {
				numeriGolTrasferta++;
				aus+=6;
			}
		}
		
		this.risultato=numeriGolCasa+ " - " +numeriGolTrasferta;
	}
	
	
	/** Metodo simula la partita
	 * @param partitaDaGiocare partita che deve essere giocata 
	 * @param giornata numero che rappresenta la giornata a cui fa riferimento la partita da giocare 
	 */
	public static void giocaPartita(Partita partitaDaGiocare,int giornata) {
		ArrayList<String[]> formazioneCasa = Formazione.getNomiGiocatori(partitaDaGiocare.getFormazioneSquadraCasa());
		ArrayList<String[]> formazioneTrasferta = Formazione.getNomiGiocatori(partitaDaGiocare.getFormazioneSquadraTrasferta());
		partitaDaGiocare.setPanoramicaVotiCasa(UtilityVotiGiocatori.creaPanoramicaVoti(formazioneCasa, giornata));
		partitaDaGiocare.setPanoramicaVotiTrasferta(UtilityVotiGiocatori.creaPanoramicaVoti(formazioneTrasferta,giornata));
		partitaDaGiocare.setVotiSquadraCasa(UtilityVotiGiocatori.assegnaVoti(formazioneCasa, giornata));
		partitaDaGiocare.setVotiSquadraTrasferta(UtilityVotiGiocatori.assegnaVoti(formazioneTrasferta, giornata));
		partitaDaGiocare.calcolaRisultato();
	}
	
	/** Metodo che ritorna un ArrayList di ArrayList di String contentenente i voti ottenuti dai calciatori in una determinata partita
	 * @param numeroGiornata  numero della giornata a cui fa riferimento la partita 
	 * @param numeroPartita numero che rappresenta la partita da giocare 
	 * @return ArrayList di ArrayList contenente i voti ottenuti dai giocatori in quella determinata partita.
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<ArrayList<String>> returnVotiPartita(int numeroGiornata,int numeroPartita) throws ClassNotFoundException {
		File f = new File("src/torneo.dat");
		FileInputStream fis;
		Torneo t=null;;
		ArrayList<ArrayList<String>> ris = new ArrayList<>();
		try {
			fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			t=(Torneo) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Errore nella scrittura su file !");
		}
		Partita p=t.getGiornate().getGiornate().get(numeroGiornata).getPartite().getPartite().get(numeroPartita);
		ArrayList<String> casa = new ArrayList<String>();
		casa.add(p.getSquadraCasa().getNomeSquadra());
		Set<String> keys;
		keys = p.getVotiSquadraCasa().keySet();
		for(String k : keys) {
			String voto=k+ " "+p.getVotiSquadraCasa().get(k);
			casa.add(voto);
		}
		ris.add(casa);
		ArrayList<String> trasferta = new ArrayList<String>();
		trasferta.add(p.getSquadraTrasferta().getNomeSquadra());
		keys=p.getVotiSquadraTrasferta().keySet();
		for(String k : keys) {
			String voto=k+ " "+p.getVotiSquadraTrasferta().get(k);
			trasferta.add(voto);
		}
		ris.add(trasferta);
		return ris;
	}
}
