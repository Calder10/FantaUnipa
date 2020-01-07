import java.io.Serializable;

public class Partita implements Serializable{
	private Squadra squadraCasa;
	private Squadra squadraTrasferta;
	private String risultato;
	//private Formazione formazioneSquadraCasa;
	//private Formazione formazioneSquadraTrasferta;
	
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
	
	/*
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
	*/

	public Partita (Squadra casa, Squadra trasferta) {
		this.squadraCasa=casa;
		this.squadraTrasferta=trasferta;
		this.risultato=null;
	}

	@Override
	public String toString() {
		return "Partita [squadraCasa=" + squadraCasa + ", squadraTrasferta=" + squadraTrasferta + ", risultato="
				+ risultato + "]";
	}
	
	
}
