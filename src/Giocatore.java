import java.io.Serializable;

public class Giocatore implements Serializable{
	private String nomeGiocatore;
	
	public Giocatore(String nomeGiocatore) {
		this.nomeGiocatore=nomeGiocatore;
	}


	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}
	
}
