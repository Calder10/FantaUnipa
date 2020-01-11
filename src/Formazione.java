import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 */

/**
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

	protected abstract void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,
			ArrayList<String> a, Squadra s);

	public abstract Formazione generaFormazioneVirtuale(Squadra s);

	/**
	 * @return the portiereTitolare
	 */
	public Portiere getPortiereTitolare() {
		return portiereTitolare;
	}

	/**
	 * @param portiereTitolare the portiereTitolare to set
	 */
	public void setPortiereTitolare(Portiere portiereTitolare) {
		this.portiereTitolare = portiereTitolare;
	}

	/**
	 * @return the difensoriTitolari
	 */
	public Difensore[] getDifensoriTitolari() {
		return difensoriTitolari;
	}

	/**
	 * @param difensoriTitolari the difensoriTitolari to set
	 */
	public void setDifensoriTitolari(Difensore[] difensoriTitolari) {
		this.difensoriTitolari = difensoriTitolari;
	}

	/**
	 * @return the centrocampistiTitolari
	 */
	public Centrocampista[] getCentrocampistiTitolari() {
		return centrocampistiTitolari;
	}

	/**
	 * @param centrocampistiTitolari the centrocampistiTitolari to set
	 */
	public void setCentrocampistiTitolari(Centrocampista[] centrocampistiTitolari) {
		this.centrocampistiTitolari = centrocampistiTitolari;
	}

	/**
	 * @return the attaccantiTitolari
	 */
	public Attaccante[] getAttaccantiTitolari() {
		return attaccantiTitolari;
	}

	/**
	 * @param attaccantiTitolari the attaccantiTitolari to set
	 */
	public void setAttaccantiTitolari(Attaccante[] attaccantiTitolari) {
		this.attaccantiTitolari = attaccantiTitolari;
	}

	/**
	 * @return the portiereRiserva
	 */
	public Portiere getPortiereRiserva() {
		return portiereRiserva;
	}

	/**
	 * @param portiereRiserva the portiereRiserva to set
	 */
	public void setPortiereRiserva(Portiere portiereRiserva) {
		this.portiereRiserva = portiereRiserva;
	}

	/**
	 * @return the difensoriRiserva
	 */
	public Difensore[] getDifensoriRiserva() {
		return difensoriRiserva;
	}

	/**
	 * @param difensoriRiserva the difensoriRiserva to set
	 */
	public void setDifensoriRiserva(Difensore[] difensoriRiserva) {
		this.difensoriRiserva = difensoriRiserva;
	}

	/**
	 * @return the centrocampistiRiserva
	 */
	public Centrocampista[] getCentrocampistiRiserva() {
		return centrocampistiRiserva;
	}

	/**
	 * @param centrocampistiRiserva the centrocampistiRiserva to set
	 */
	public void setCentrocampistiRiserva(Centrocampista[] centrocampistiRiserva) {
		this.centrocampistiRiserva = centrocampistiRiserva;
	}

	/**
	 * @return the attaccantiRiserva
	 */
	public Attaccante[] getAttaccantiRiserva() {
		return attaccantiRiserva;
	}

	/**
	 * @param attaccantiRiserva the attaccantiRiserva to set
	 */
	public void setAttaccantiRiserva(Attaccante[] attaccantiRiserva) {
		this.attaccantiRiserva = attaccantiRiserva;
	}

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
