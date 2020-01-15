import java.awt.EventQueue;
import java.io.IOException;

/**
 * Classe che permette l'esecuzione del software
 * 
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */
public class FantaUnipa {
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
					UtilityListaGiocatori.creaListe();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
