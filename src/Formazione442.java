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

	public Formazione442(TipoFormazione tipo,ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a) {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [2];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
		settaFormazione(p,d,c,a);
	}

	@Override
	protected void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a) {
		
		
	}
	
}
