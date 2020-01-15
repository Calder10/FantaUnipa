import java.util.ArrayList;

/**
 * Classe che permette di creare la formazione in base al modulo scelto
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class FormazioneFactory {

	/**
	 * Metodo che restituisce la formazione creata
	 * @param tipo indica il modulo della formazione
	 * @param p ArrayList dei portieri
	 * @param d ArrayList dei difensori
	 * @param c ArrayList dei centrocampisti
	 * @param a ArrayList degli attaccanti
	 * @param s squadra su cui settare il modulo
	 * @return entità Formazione
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
