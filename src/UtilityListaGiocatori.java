import java.io.*;
import java.util.ArrayList;

public class UtilityListaGiocatori {
	private static String pathListaCompleta = "src/Lista/listaCalciatoriCompleta.csv";
	private static String pathListaPortieri = "src/Lista/portieri.csv";
	private static String pathListaDifensori = "src/Lista/difensori.csv";
	private static String pathListaCentrocampisti = "src/Lista/centrocampisti.csv";
	private static String pathListaAttaccanti = "src/Lista/attaccanti.csv";

	public static void creaListaPortieri() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		File f = new File(pathListaPortieri);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome,Acquistato\n");
		FileReader fr = new FileReader(pathListaCompleta);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String fields[] = line.split(",");
			if (fields[0].equals("P")) {
				fw.append(fields[1]);
				fw.append(",");
				fw.append('0');
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}

	public static void creaListaDifensori() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		File f = new File(pathListaDifensori);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome,Acquistato\n");
		FileReader fr = new FileReader(pathListaCompleta);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String fields[] = line.split(",");
			if (fields[0].equals("D")) {
				fw.append(fields[1]);
				fw.append(",");
				fw.append('0');
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}

	public static void creaListaCentrocampisti() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		File f = new File(pathListaCentrocampisti);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome,Acquistato\n");
		FileReader fr = new FileReader(pathListaCompleta);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String fields[] = line.split(",");
			if (fields[0].equals("C")) {
				fw.append(fields[1]);
				fw.append(",");
				fw.append('0');
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}

	public static void creaListaAttaccanti() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		File f = new File(pathListaAttaccanti);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome,Acquistato\n");
		FileReader fr = new FileReader(pathListaCompleta);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String fields[] = line.split(",");
			if (fields[0].equals("A")) {
				fw.append(fields[1]);
				fw.append(",");
				fw.append('0');
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}

	public static void creaListe() throws IOException {
		UtilityListaGiocatori.creaListaPortieri();
		UtilityListaGiocatori.creaListaDifensori();
		UtilityListaGiocatori.creaListaCentrocampisti();
		UtilityListaGiocatori.creaListaAttaccanti();
	}

	public static String cercaGiocatore(String giocatore, int tipo) throws IOException {
		String ris = "";
		FileReader f = null;
		BufferedReader br = null;
		String line = "";
		String fields[];

		switch (tipo) {
		case 0:
			f = new FileReader(pathListaPortieri);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(giocatore)) {
					ris = fields[0];
					break;
				}
			}
			br.close();
			f.close();
			break;
		case 1:
			f = new FileReader(pathListaDifensori);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(giocatore)) {
					ris = fields[0];
					break;
				}
			}
			br.close();
			f.close();
			break;
		case 2:
			f = new FileReader(pathListaCentrocampisti);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(giocatore)) {
					ris = fields[0];
					break;
				}
			}
			br.close();
			f.close();
			break;
		case 3:
			f = new FileReader(pathListaAttaccanti);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(giocatore)) {
					ris = fields[0];
					break;
				}
			}
			br.close();
			f.close();
			break;
		default:
			System.out.println("Scelta non consentita");
		}

		return ris;

	}

	public static ArrayList<String> showAllPlayers(int tipo) throws IOException {
		ArrayList<String> ris = new ArrayList<>();
		FileReader f = null;
		BufferedReader br = null;
		String line = "";
		String fields[];

		switch (tipo) {
		case 0:
			f = new FileReader(pathListaPortieri);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				ris.add(fields[0]);
			}
			br.close();
			f.close();
			break;
		case 1:
			f = new FileReader(pathListaDifensori);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				ris.add(fields[0]);
			}
			br.close();
			f.close();
			break;
		case 2:
			f = new FileReader(pathListaCentrocampisti);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				ris.add(fields[0]);
			}
			br.close();
			f.close();
			break;
		case 3:
			f = new FileReader(pathListaAttaccanti);
			br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				ris.add(fields[0]);
			}
			br.close();
			f.close();
			break;
		default:
			System.out.println("Scelta non consentita");
		}

		return ris;
	}
}
