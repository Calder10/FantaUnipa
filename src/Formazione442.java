import java.io.Serializable;
import java.util.ArrayList;



/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione442 extends Formazione  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1411712447765962165L;

	public Formazione442(TipoFormazione tipo,ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a,Squadra s) {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
		settaFormazione(p,d,c,a,s);
	}

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
	
}
