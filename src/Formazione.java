import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano 
 */
public abstract class Formazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9015693335444170514L;
	protected Portiere portiereTitolare;
	protected Difensore [] difensoriTitolari;
	protected Centrocampista [] centrocampistiTitolari;
	protected Attaccante [] attaccantiTitolari;
	
	protected Portiere portiereRiserva;
	protected Difensore [] difensoriRiserva;
	protected Centrocampista [] centrocampistiRiserva;
	protected Attaccante [] attaccantiRiserva;
	
	
	protected abstract void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a);
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
	
	protected static boolean checkFormazione(ArrayList<String> p,ArrayList<String> d,ArrayList<String> c,ArrayList<String> a) {
		
		int checkPortieri=0;
		int checkDifensori=0;
		int checkCentrocampisti=0;
		int checkAttaccanti=0;
		
		for (String s : p) {
			checkPortieri+=Collections.frequency(p, s);
		}
		
		
		for (String s : d) {
			checkDifensori+=Collections.frequency(d, s);
		}
			
		for (String s1 : c) {
			checkCentrocampisti+=Collections.frequency(c, s1);
		}
		
		for (String s2 : a) {
			checkAttaccanti+=Collections.frequency(a, s2);
		}
		
		if(checkPortieri==2 && checkDifensori==6 && checkCentrocampisti==6 && checkAttaccanti==4)
			return true;
		else 
			return false;
	}
	
}
