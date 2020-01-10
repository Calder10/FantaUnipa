import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione433 extends Formazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -576114747978238396L;
	
	public Formazione433() {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [3];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [3];
		attaccantiRiserva=new Attaccante [2];
	}

	public Formazione433(TipoFormazione tipo, ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a,Squadra s) {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [3];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [3];
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

