import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione343 extends Formazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1249966855139758L;

	public Formazione343(TipoFormazione tipo, ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,ArrayList<String> a) {
		difensoriTitolari=new Difensore[3];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [3];
		attaccantiRiserva=new Attaccante [2];
		settaFormazione(p, d, c, a);
	}

	@Override
	protected void settaFormazione(ArrayList<String> p, ArrayList<String> d, ArrayList<String> c, ArrayList<String> a) {
		// TODO Auto-generated method stub
		
	}
	
}
