import java.io.Serializable;
import java.util.HashMap;

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
	private HashMap<String,Integer> votiSquadraCasa;
	
	
	/**
	 * @return the votiSquadraCasa
	 */
	public HashMap<String, Integer> getVotiSquadraCasa() {
		return votiSquadraCasa;
	}

	/**
	 * @param votiSquadraCasa the votiSquadraCasa to set
	 */
	public void setVotiSquadraCasa(HashMap<String, Integer> votiSquadraCasa) {
		this.votiSquadraCasa = votiSquadraCasa;
	}

	/**
	 * @return the votiSquadraTrasferta
	 */
	public HashMap<String, Integer> getVotiSquadraTrasferta() {
		return votiSquadraTrasferta;
	}

	/**
	 * @param votiSquadraTrasferta the votiSquadraTrasferta to set
	 */
	public void setVotiSquadraTrasferta(HashMap<String, Integer> votiSquadraTrasferta) {
		this.votiSquadraTrasferta = votiSquadraTrasferta;
	}

	private HashMap<String,Integer> votiSquadraTrasferta;
	
	
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
	
}
