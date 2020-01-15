import java.awt.EventQueue;
import java.io.IOException;

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
