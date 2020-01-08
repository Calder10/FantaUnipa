/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione352 extends Formazione{
	
	public Formazione352() {
		difensoriTitolari=new Difensore[3];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [5];
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
	}
	
	@Override
	protected Formazione creaFormazione() {
		Formazione f= new Formazione352();
		return f;
	}
}
