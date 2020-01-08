/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione442 extends Formazione{
	
	public Formazione442() {
		difensoriTitolari=new Difensore[4];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [2];
		attaccantiRiserva=new Attaccante [2];
	}
	
	@Override
	protected Formazione creaFormazione() {
		Formazione f=new Formazione442();
		return f;
	}
}
