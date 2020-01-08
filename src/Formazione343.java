/**
 * 
 */

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class Formazione343 extends Formazione{
	
	public Formazione343() {
		difensoriTitolari=new Difensore[3];
		difensoriRiserva=new Difensore[2];
		centrocampistiTitolari= new Centrocampista [4];
		centrocampistiRiserva= new Centrocampista [4];
		attaccantiTitolari=new Attaccante [3];
		attaccantiRiserva=new Attaccante [2];
	}
	
	@Override
	protected Formazione creaFormazione() {
		Formazione f=new Formazione343();
		return f;
	}
}
