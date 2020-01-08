
/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class FormazioneFactory {
	
	public enum Tipo{
		F442,F343,F433,F352
	}
	
	
	/**
	 * @param tipo
	 * @return
	 */
	public Formazione getFormazione(Tipo tipo) {
		Formazione f=null;
		switch(tipo) {
		case F442:
			f = new Formazione442();
			break;
		
		case F343:
			f = new Formazione343();
			break;
			
		case F433:
			f=new Formazione433();
			break;
		case F352:
			f=new Formazione352();
			break;
		default: System.out.println("Scelta non consentita !");
		}
		return f;
	}
	

}
