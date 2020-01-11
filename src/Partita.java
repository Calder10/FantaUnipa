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
		Set<String> keys = this.votiSquadraCasa.keySet();
		for(String key : keys) {
			casa+=this.votiSquadraCasa.get(key);
		}
		
		for(String key : keys) {
			trasferta+=this.votiSquadraTrasferta.get(key);
		}
		
		this.risultato=casa+ " - " +trasferta;
	}
	
	public static void giocaPartita(Partita partitaDaGiocare,int giornata) {
		ArrayList<String> formazioneCasa = Formazione.getNomiGiocatori(partitaDaGiocare.getFormazioneSquadraCasa());
		ArrayList<String> formazioneTrasferta = Formazione.getNomiGiocatori(partitaDaGiocare.getFormazioneSquadraTrasferta());
		partitaDaGiocare.setPanoramicaVotiCasa(UtilityVotiGiocatori.creaPanoramicaVoti(formazioneCasa, giornata));
		partitaDaGiocare.setPanoramicaVotiTrasferta(UtilityVotiGiocatori.creaPanoramicaVoti(formazioneTrasferta,giornata));
		partitaDaGiocare.setVotiSquadraCasa(UtilityVotiGiocatori.assegnaVoti(formazioneCasa, giornata));
		partitaDaGiocare.setVotiSquadraTrasferta(UtilityVotiGiocatori.assegnaVoti(formazioneTrasferta, giornata));
		partitaDaGiocare.calcolaRisultato();
	}
}
