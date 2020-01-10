import java.io.Serializable;
import java.util.ArrayList;

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
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
	}

	public Formazione352(TipoFormazione tipo, ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a,Squadra s) {
		difensoriTitolari=new Difensore[3];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [5];
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
		settaFormazione(p, d, c, a,s);
	}

	@Override
	protected void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c, ArrayList<String> a,Squadra s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Formazione generaFormazioneVirtuale(Squadra s) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
