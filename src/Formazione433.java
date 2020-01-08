/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione433 extends Formazione{
	
	public Formazione433() {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [3];
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [3];
		attaccantiRiserva=new Attaccante [2];
	}
	
	@Override
	protected Formazione creaFormazione() {
		Formazione f=new Formazione433();
		return f;
	}
}

