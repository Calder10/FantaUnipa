import java.util.ArrayList;

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class FormazioneFactory {

	/**
	 * @param tipo
	 * @return
	 */
	public Formazione getFormazione(TipoFormazione tipo, ArrayList<String> p, ArrayList<String> d, ArrayList<String> c,
			ArrayList<String> a,Squadra s) {
		Formazione f = null;
		switch (tipo) {
		case F442:
			f = new Formazione442(tipo, p, d, c, a,s);
			break;
		case F343:
			f = new Formazione343(tipo, p, d, c, a,s);
			break;

		case F433:
			f = new Formazione433(tipo, p, d, c, a,s);
			break;

		case F352:
			f = new Formazione352(tipo, p, d, c, a,s);
			break;

		default:
			System.out.println("Scelta non consentita");
		}

		return f;
	}

}
