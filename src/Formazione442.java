import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Classe per la gestione del modulo 352
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione442 extends Formazione  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1411712447765962165L;

	/**
     * Costruttore della classe senza parametri.
     * 
     */
	public Formazione442() {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
	}
	
	
	/**
	 * Costruttore della classe con parametri
	 * @param tipo indica il modulo della formazione
	 * @param p ArrayList dei portieri
	 * @param d ArrayList dei difensori
	 * @param c ArrayList dei centrocampisti
	 * @param a ArrayList degli attaccanti
	 * @param s squadra su cui settare il modulo
	 */
	public Formazione442(TipoFormazione tipo,ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a,Squadra s) {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
		settaFormazione(p,d,c,a,s);
	}

	/**
	 *Modulo che permette di settare la formazione
	 * @param p ArrayList dei portieri
	 * @param d ArrayList dei difensori
	 * @param c ArrayList dei centrocampisti
	 * @param a ArrayList degli attaccanti
	 * @param s squadra su cui settare il modulo
	 */
	@Override
	protected void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a,Squadra s ) {
		int i=0;
		int i1=0;
		
		for (String nome : p) {
			for (Portiere x : s.getPortieri()) {
				if(nome.equalsIgnoreCase(x.getNomeGiocatore())) {
					if(i==0) {
						this.portiereTitolare=x;
						i++;
					}
					else {
						this.portiereRiserva=x;
					}
				}
			}
		}
		
		
		i=0;
		i1=0;
		for (String nome : d) {
			for (Difensore x : s.getDifensori()) {
				if(nome.equalsIgnoreCase(x.getNomeGiocatore())) {
					if(i<=3) {
						this.difensoriTitolari[i]=x;
						i++;
					}
					else {
						this.difensoriRiserva[i1]=x;
						i1++;
					}
				}
			}
		}
		
		i=0;
		i1=0;
		for (String nome : c) {
			for (Centrocampista x : s.getCentrocampisti()) {
				if(nome.equalsIgnoreCase(x.getNomeGiocatore())) {
					if(i<=3) {
						this.centrocampistiTitolari[i]=x;
						i++;
					}
					else {
						this.centrocampistiRiserva[i1]=x;
						i1++;
					}
				}
			}
		}
		
		i=0;
		i1=0;
		for (String nome : a) {
			for (Attaccante x : s.getAttaccanti()) {
				if(nome.equalsIgnoreCase(x.getNomeGiocatore())) {
					if(i<=1) {
						this.attaccantiTitolari[i]=x;
						i++;
					}
					else {
						this.attaccantiRiserva[i1]=x;
						i1++;
					}
				}
			}
		}
		
	}
	
	/**
	 *Metodo che permette di generare la formazione delle squadre virtuali
	 *@param s squadra su cui generare la formazione
	 */
	@Override
	public  Formazione generaFormazioneVirtuale (Squadra s) {
		Formazione f = new Formazione442();
		int i=0;
		i=new Random().nextInt(s.getPortieri().size()-1);
		f.portiereTitolare=s.getPortieri().get(i);
		s.getPortieri().remove(i);
		
		i=new Random().nextInt(s.getPortieri().size()-1);
		f.portiereRiserva=s.getPortieri().get(i);
		s.getPortieri().remove(i);
		
		for (int j=0; j<=3;j++) {
			i=new Random().nextInt(s.getDifensori().size()-1);
			f.difensoriTitolari[j]=s.getDifensori().get(i);
			s.getDifensori().remove(i);
			
		}
		
		for(int j=0;j<=1;j++) {
			i=new Random().nextInt(s.getDifensori().size()-1);
			f.difensoriRiserva[j]=s.getDifensori().get(i);
			s.getDifensori().remove(i);
		}
		
		
		for (int j=0; j<=3;j++) {
			i=new Random().nextInt(s.getCentrocampisti().size()-1);
			f.centrocampistiTitolari[j]=s.getCentrocampisti().get(i);
			s.getCentrocampisti().remove(i);
			
		}
		
		for(int j=0;j<=1;j++) {
			i=new Random().nextInt(s.getCentrocampisti().size()-1);
			f.centrocampistiRiserva[j]=s.getCentrocampisti().get(i);
			s.getCentrocampisti().remove(i);
		}
		
		for (int j=0; j<=1;j++) {
			i=new Random().nextInt(s.getAttaccanti().size()-1);
			f.attaccantiTitolari[j]=s.getAttaccanti().get(i);
			s.getAttaccanti().remove(i);
			
		}
		
		for(int j=0;j<=1;j++) {
			i=new Random().nextInt(s.getAttaccanti().size()-1);
			f.attaccantiRiserva[j]=s.getAttaccanti().get(i);
			s.getAttaccanti().remove(i);
		}
		
		return f;
	}
	/**
	 * Metodo che controlla che non ci siano giocatori duplicati con lo stesso nome schierati in campo e che il numero delle riserve sia corretto
	 * @param p ArrayList dei portieri
	 * @param d ArrayList dei difensori
	 * @param c ArrayList dei centrocampisti
	 * @param a ArrayList degli attaccanti
	 * @return true se la formazione inserita è corretta, false altrimenti
	 */
public static boolean checkFormazione(ArrayList<String> p,ArrayList<String> d,ArrayList<String> c,ArrayList<String> a) {
		
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
