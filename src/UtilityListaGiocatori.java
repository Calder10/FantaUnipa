import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/** Classe per la gestione della lista dei giocatori 
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class UtilityListaGiocatori {
	private static String pathListaCompleta = "src/Lista/listaCalciatoriCompleta.csv";
	private static String pathListaPortieri = "src/Lista/portieri.csv";
	private static String pathListaDifensori = "src/Lista/difensori.csv";
	private static String pathListaCentrocampisti = "src/Lista/centrocampisti.csv";
	private static String pathListaAttaccanti = "src/Lista/attaccanti.csv";
	


	/** Metodo che crea il file csv contenente i portieri 
	 * @throws IOException
	 */
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

	/** Metodo che crea il file csv contenente i difensori
	 * @throws IOException
	 */
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
	
	/** Metodo che crea il file csv contenente i centrocampisti
	 * @throws IOException
	 */
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
	
	/** Metodo che crea il file csv contenente gli attaccanti
	 * @throws IOException
	 */
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

	
	/** Metodo che crea le liste dei giocatori 
	 * @throws IOException
	 */
	public static void creaListe() throws IOException {
		UtilityListaGiocatori.creaListaPortieri();
		UtilityListaGiocatori.creaListaDifensori();
		UtilityListaGiocatori.creaListaCentrocampisti();
		UtilityListaGiocatori.creaListaAttaccanti();
	}

	/** Metod che controlla se un determinato giocatore è presente o meno nelle liste
	 * @param giocatore nome del giocatore da cercare 
	 * @param tipo intero che rappresenta il ruolo del calciatore
	 * @return il nome del calciatore se viene trovato, la stringa vuota altrimenti 
	 * @throws IOException
	 */
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
					ris = line;
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
					ris = line;
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
					ris = line;
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
					ris = line;
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

	/** Metodo che restituisce un ArrayList contenente i nomi dei giocatori di un determinato ruolo
	 * @param tipo intero che rappresenta il tipo del giocatore
	 * @return ArrayList di stringhe contenente i nomi dei giocatori
	 * @throws IOException
	 */
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
				if (fields[1].equalsIgnoreCase("0")) {
					ris.add(fields[0]);
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
				if (fields[1].equalsIgnoreCase("0"))
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
				if (fields[1].equalsIgnoreCase("0"))
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
				if (fields[1].equalsIgnoreCase("0"))
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

	/** Metodo che modifica il file csv contrassegnando  il giocatore passato a parametro come acquistato
	 * @param tipo intero che rappresenta il tipo del giocatore 
	 * @param nomeGiocatore da marcare come acquistato
	 * @throws IOException
	 */
	public static void giocatoreAcquistato(int tipo, String nomeGiocatore) throws IOException {
		File f = null;
		File f1 = null;
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		String path1 = null;
		String line = "";
		String fields[];

		switch (tipo) {
		case 0:
			f = new File(pathListaPortieri);
			fr = new FileReader(pathListaPortieri);
			path1 = "src/Lista/portieri1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw = new FileWriter(f1, true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0] + ",1");
					fw.append("\n");
				} else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			fr.close();
			f1.renameTo(f);
			break;
		case 1:
			f = new File(pathListaDifensori);
			fr = new FileReader(pathListaDifensori);
			path1 = "src/Lista/difensori1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw = new FileWriter(f1, true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0] + ",1");
					fw.append("\n");
				} else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			fr.close();
			f1.renameTo(f);
			break;
		case 2:
			f = new File(pathListaCentrocampisti);
			fr = new FileReader(pathListaCentrocampisti);
			path1 = "src/Lista/centrocampisti1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw = new FileWriter(f1, true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0] + ",1");
					fw.append("\n");
				} else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			fr.close();
			f1.renameTo(f);
			break;
		case 3:
			f = new File(pathListaAttaccanti);
			fr = new FileReader(pathListaAttaccanti);
			path1 = "src/Lista/attaccanti1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw = new FileWriter(f1, true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0] + ",1");
					fw.append("\n");
				} else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			fr.close();
			f1.renameTo(f);
			break;
		default:
			System.out.println("Scelta non consentita");
		}
	}

	/** Metodo che estrae randomicamente un giocatore di un determinato tipo
	 * @param tipo intero che rappresenta il ruolo del giocatore
	 * @return
	 * @throws IOException
	 */
	public static String randomPlayer(int tipo) throws IOException {
		int s = 0;
		int i=0;
		boolean flag = false;
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		String[] fields;
		String ris = "";
		ArrayList<String> freePlayers ;
		switch (tipo) {
		case 0:
			f = new File(pathListaPortieri);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			line = br.readLine();
			freePlayers = new ArrayList<>();
			while((line=br.readLine())!=null) {
				fields=line.split(",");
				if(fields[1].equalsIgnoreCase("0"))
					freePlayers.add(fields[0]);
			}
			s = new Random().nextInt(freePlayers.size());
			ris = freePlayers.get(s);
			break;

		case 1:
			f = new File(pathListaDifensori);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			line = br.readLine();
			freePlayers = new ArrayList<>();
			while((line=br.readLine())!=null) {
				fields=line.split(",");
				if(fields[1].equalsIgnoreCase("0"))
					freePlayers.add(fields[0]);
			}
			s = new Random().nextInt(freePlayers.size());
			ris = freePlayers.get(s);
			break;
		case 2:
			f = new File(pathListaCentrocampisti);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			line = br.readLine();
			freePlayers = new ArrayList<>();
			while((line=br.readLine())!=null) {
				fields=line.split(",");
				if(fields[1].equalsIgnoreCase("0"))
					freePlayers.add(fields[0]);
			}
			s = new Random().nextInt(freePlayers.size());
			ris = freePlayers.get(s);
			break;
		case 3:
			f = new File(pathListaAttaccanti);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			line = br.readLine();
			freePlayers = new ArrayList<>();
			while((line=br.readLine())!=null) {
				fields=line.split(",");
				if(fields[1].equalsIgnoreCase("0"))
					freePlayers.add(fields[0]);
			}
			s = new Random().nextInt(freePlayers.size());
			ris = freePlayers.get(s);
			break;
		default:
			System.out.println("Scelta non consentita !");
		}
		return ris;
	}
}
