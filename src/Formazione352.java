import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione352 extends Formazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2524469794411334665L;
	
	public Formazione352() {
		difensoriTitolari=new Difensore[3];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [5];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
	}

	public Formazione352(TipoFormazione tipo, ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a,Squadra s) {
		difensoriTitolari=new Difensore[3];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [5];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
		settaFormazione(p, d, c, a,s);
	}

	@Override
	protected void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c, ArrayList<String> a,Squadra s) {
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
					if(i<=2) {
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
					if(i<=4) {
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

	@Override
	public Formazione generaFormazioneVirtuale(Squadra s) {
		Formazione f = new Formazione352();
		int i=0;
		i=new Random().nextInt(s.getPortieri().size()-1);
		f.portiereTitolare=s.getPortieri().get(i);
		s.getPortieri().remove(i);
		
		i=new Random().nextInt(s.getPortieri().size()-1);
		f.portiereRiserva=s.getPortieri().get(i);
		s.getPortieri().remove(i);
		
		for (int j=0; j<=2;j++) {
			i=new Random().nextInt(s.getDifensori().size()-1);
			f.difensoriTitolari[j]=s.getDifensori().get(i);
			s.getDifensori().remove(i);
			
		}
		
		for(int j=0;j<=1;j++) {
			i=new Random().nextInt(s.getDifensori().size()-1);
			f.difensoriRiserva[j]=s.getDifensori().get(i);
			s.getDifensori().remove(i);
		}
		
		
		for (int j=0; j<=4;j++) {
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
		
		if(checkPortieri==2 && checkDifensori==5 && checkCentrocampisti==7 && checkAttaccanti==4)
			return true;
		else 
			return false;
	}

}
