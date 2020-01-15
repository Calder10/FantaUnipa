import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Classe astratta che permette la gestione della formazione
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public abstract class Formazione implements Serializable {

	@Override
	public String toString() {
		return "Formazione [portiereTitolare=" + portiereTitolare + ", difensoriTitolari="
				+ Arrays.toString(difensoriTitolari) + ", centrocampistiTitolari="
				+ Arrays.toString(centrocampistiTitolari) + ", attaccantiTitolari="
				+ Arrays.toString(attaccantiTitolari) + ", portiereRiserva=" + portiereRiserva + ", difensoriRiserva="
				+ Arrays.toString(difensoriRiserva) + ", centrocampistiRiserva="
				+ Arrays.toString(centrocampistiRiserva) + ", attaccantiRiserva=" + Arrays.toString(attaccantiRiserva)
				+ "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9015693335444170514L;
	protected Portiere portiereTitolare;
	protected Difensore[] difensoriTitolari;
	protected Centrocampista[] centrocampistiTitolari;
	protected Attaccante[] attaccantiTitolari;

	protected Portiere portiereRiserva;
	protected Difensore[] difensoriRiserva;
	protected Centrocampista[] centrocampistiRiserva;
	protected Attaccante[] attaccantiRiserva;

	/**
	 * Metodo astratto che permette di settare la formazione
	 * @param p  ArrayList contenente i portieri
	 * @param d	 ArrayList contenente i difensori
	 * @param c  ArrayList contenente i centrocampisti
	 * @param a  ArrayList contenente gli attaccanti
	 * @param s  squadra su cui settare la formazione
	 */
	protected abstract void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,
			ArrayList<String> a, Squadra s);

	/**
	 * Metodo astratto che genera la formazione della squadra virtuale
	 * @param s squadra su cui generare la formazione
	 * @return la formazione delle squadre virtuali
	 */
	public abstract Formazione generaFormazioneVirtuale(Squadra s);

	
	public Portiere getPortiereTitolare() {
		return portiereTitolare;
	}

	
	public void setPortiereTitolare(Portiere portiereTitolare) {
		this.portiereTitolare = portiereTitolare;
	}

	
	public Difensore[] getDifensoriTitolari() {
		return difensoriTitolari;
	}

	
	public void setDifensoriTitolari(Difensore[] difensoriTitolari) {
		this.difensoriTitolari = difensoriTitolari;
	}

	
	public Centrocampista[] getCentrocampistiTitolari() {
		return centrocampistiTitolari;
	}

	
	public void setCentrocampistiTitolari(Centrocampista[] centrocampistiTitolari) {
		this.centrocampistiTitolari = centrocampistiTitolari;
	}

	
	public Attaccante[] getAttaccantiTitolari() {
		return attaccantiTitolari;
	}

	
	public void setAttaccantiTitolari(Attaccante[] attaccantiTitolari) {
		this.attaccantiTitolari = attaccantiTitolari;
	}

	public Portiere getPortiereRiserva() {
		return portiereRiserva;
	}

	
	public void setPortiereRiserva(Portiere portiereRiserva) {
		this.portiereRiserva = portiereRiserva;
	}

	
	public Difensore[] getDifensoriRiserva() {
		return difensoriRiserva;
	}

	
	public void setDifensoriRiserva(Difensore[] difensoriRiserva) {
		this.difensoriRiserva = difensoriRiserva;
	}

	
	public Centrocampista[] getCentrocampistiRiserva() {
		return centrocampistiRiserva;
	}

	
	public void setCentrocampistiRiserva(Centrocampista[] centrocampistiRiserva) {
		this.centrocampistiRiserva = centrocampistiRiserva;
	}

	
	public Attaccante[] getAttaccantiRiserva() {
		return attaccantiRiserva;
	}

	
	public void setAttaccantiRiserva(Attaccante[] attaccantiRiserva) {
		this.attaccantiRiserva = attaccantiRiserva;
	}

	/**
	 * 
	 * Metodo che ritorna i nomi dei calciaotri
	 * @param f formazione della squadra 
	 * @return ArrayList contenente i nomi dei giocatori
	 */
	public static ArrayList<String[]> getNomiGiocatori(Formazione f) {
		ArrayList<String[]> nomiGiocatori = new ArrayList<>();
		String[] aus = { f.getPortiereTitolare().getNomeGiocatore(), "P" };
		nomiGiocatori.add(aus);

		for (Difensore d : f.getDifensoriTitolari()) {
			String[] aus1 = { d.getNomeGiocatore(), "D" };
			nomiGiocatori.add(aus1);
		}

		for (Centrocampista c : f.getCentrocampistiTitolari()) {
			String[] aus2 = { c.getNomeGiocatore(), "C" };
			nomiGiocatori.add(aus2);
		}

		for (Attaccante a : f.getAttaccantiTitolari()) {
			String[] aus3 = { a.getNomeGiocatore(), "A" };
			nomiGiocatori.add(aus3);
		}

		String[] aus4 = { f.getPortiereRiserva().getNomeGiocatore(), "P" };
		nomiGiocatori.add(aus4);

		for (Difensore d : f.getDifensoriRiserva()) {
			String[] aus5 = { d.getNomeGiocatore(), "A" };
			nomiGiocatori.add(aus5);
		}

		for (Centrocampista c : f.getCentrocampistiRiserva()) {
			String[] aus6 = { c.getNomeGiocatore(), "A" };
			nomiGiocatori.add(aus6);
		}

		for (Attaccante a : f.getAttaccantiRiserva()) {
			String[] aus7 = { a.getNomeGiocatore(), "A" };
			nomiGiocatori.add(aus7);
		}

		return nomiGiocatori;

	}
}
