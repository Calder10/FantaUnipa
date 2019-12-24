import java.awt.Image;

import java.util.List;

public class Squadra {
	private Fantallenatore fantallenatore;
	private String nomeSquadra;
	private Image logo;
	private List<Portiere> portieri;
	private List <Difensore> difensori;
	private List <Centrocampista> centrocampisti;
	private List <Attaccante> attaccanti;
	public Fantallenatore getFantallenatore() {
		return fantallenatore;
	}
	public void setFantallenatore(Fantallenatore fantallenatore) {
		this.fantallenatore = fantallenatore;
	}
	public String getNomeSquadra() {
		return nomeSquadra;
	}
	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}
	public Image getLogo() {
		return logo;
	}
	public void setLogo(Image logo) {
		this.logo = logo;
	}
	public List<Portiere> getPortieri() {
		return portieri;
	}
	public List<Difensore> getDifensori() {
		return difensori;
	}
	public List<Centrocampista> getCentrocampisti() {
		return centrocampisti;
	}
	public List<Attaccante> getAttaccanti() {
		return attaccanti;
	}
	
}
