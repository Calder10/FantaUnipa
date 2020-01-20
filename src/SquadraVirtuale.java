import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SquadraVirtuale extends Squadra {
	/**
	 * Classe per la gestione dell'entita SquadraVirtuale
	 * @author Salvatore Calderaro
	 * @author Gaspare Casano
	 */
	private static final long serialVersionUID = -8111726822249143937L;
	private static String[] nomiSquadra = { "FantaInter", "FantaFiorentina", "FantaJuventus", "FantaMilan",
			"FantaSassuolo", "FantaRoma", "FantaLazio" };

	/** Metodo che crea le squadre virtuali
	 * @throws IOException
	 */
	public static void creaSquadreVirtuali() throws IOException {
		boolean[] isFree = { false, false, false, false, false, false, false };
		String line = "";
		FileReader f = new FileReader("src/dati.csv");
		BufferedReader br = new BufferedReader(f);
		line = br.readLine();
		line = br.readLine();
		while ((line = br.readLine()) != null) {
			if (line.equals(""))
				break;
			else {
				String[] fields = line.split(",");
				int aus = new Random().nextInt(6);
				if (isFree[aus] == true) {
					while (true) {
						aus = new Random().nextInt(6);
						if (isFree[aus] == false)
							break;
					}
				}
				SquadraVirtuale s = new SquadraVirtuale();
				s.setNomeSquadra(nomiSquadra[aus]);
				isFree[aus] = true;
				String pathLogo = ("src/Loghi/" + nomiSquadra[aus].trim() + ".png").trim();
				s.setPathLogo(pathLogo);
				s.addNomeSquadraToCsv(fields[2], nomiSquadra[aus]);
				s.salvaSquadraSuFile();
			}
		}
		br.close();
		f.close();
	}
}
