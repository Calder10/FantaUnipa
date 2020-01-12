import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Partita implements Serializable{
	
	/**
	 * 
	 */
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
	
	
	
	/**
	 * @return the panoramicaVotiCasa
	 */
	public ArrayList<String> getPanoramicaVotiCasa() {
		return panoramicaVotiCasa;
	}

	/**
	 * @param panoramicaVotiCasa the panoramicaVotiCasa to set
	 */
	public void setPanoramicaVotiCasa(ArrayList<String> panoramicaVotiCasa) {
		this.panoramicaVotiCasa = panoramicaVotiCasa;
	}

	/**
	 * @return the panoramicaVotiTrasferta
	 */
	public ArrayList<String> getPanoramicaVotiTrasferta() {
		return panoramicaVotiTrasferta;
	}

	/**
	 * @param panoramicaVotiTrasferta the panoramicaVotiTrasferta to set
	 */
	public void setPanoramicaVotiTrasferta(ArrayList<String> panoramicaVotiTrasferta) {
		this.panoramicaVotiTrasferta = panoramicaVotiTrasferta;
	}

	/**
	 * @return the votiSquadraCasa
	 */
	public HashMap<String, Double> getVotiSquadraCasa() {
		return votiSquadraCasa;
	}

	/**
	 * @param votiSquadraCasa the votiSquadraCasa to set
	 */
	public void setVotiSquadraCasa(HashMap<String, Double> votiSquadraCasa) {
		this.votiSquadraCasa = votiSquadraCasa;
	}

	/**
	 * @return the votiSquadraTrasferta
	 */
	public HashMap<String, Double> getVotiSquadraTrasferta() {
		return votiSquadraTrasferta;
	}

	/**
	 * @param votiSquadraTrasferta the votiSquadraTrasferta to set
	 */
	public void setVotiSquadraTrasferta(HashMap<String, Double> votiSquadraTrasferta) {
		this.votiSquadraTrasferta = votiSquadraTrasferta;
	}

	
	
	/**
	 * @param casa
	 * @param trasferta
	 */
	public Partita (Squadra casa, Squadra trasferta) {
		this.squadraCasa=casa;
		this.squadraTrasferta=trasferta;
		this.risultato=" - ";
	}
	
	/**
	 * @return
	 */
	public Squadra getSquadraCasa() {
		return squadraCasa;
	}

	/**
	 * @param squadraCasa
	 */
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
		
		
		
		System.out.println(casa+ " - " +trasferta);
		this.risultato=numeriGolCasa+ " - " +numeriGolTrasferta;
		System.out.println(this.risultato);
	}
	
	public static void giocaPartita(Partita partitaDaGiocare,int giornata) {
		ArrayList<String[]> formazioneCasa = Formazione.getNomiGiocatori(partitaDaGiocare.getFormazioneSquadraCasa());
		ArrayList<String[]> formazioneTrasferta = Formazione.getNomiGiocatori(partitaDaGiocare.getFormazioneSquadraTrasferta());
		partitaDaGiocare.setPanoramicaVotiCasa(UtilityVotiGiocatori.creaPanoramicaVoti(formazioneCasa, giornata));
		partitaDaGiocare.setPanoramicaVotiTrasferta(UtilityVotiGiocatori.creaPanoramicaVoti(formazioneTrasferta,giornata));
		partitaDaGiocare.setVotiSquadraCasa(UtilityVotiGiocatori.assegnaVoti(formazioneCasa, giornata));
		partitaDaGiocare.setVotiSquadraTrasferta(UtilityVotiGiocatori.assegnaVoti(formazioneTrasferta, giornata));
		partitaDaGiocare.calcolaRisultato();
	}
	
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
