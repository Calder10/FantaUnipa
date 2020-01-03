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
				fields=line.split(",");
				if(fields[1].equalsIgnoreCase("0")){
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
				if(fields[1].equalsIgnoreCase("0"))
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
				if(fields[1].equalsIgnoreCase("0"))
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
				if(fields[1].equalsIgnoreCase("0"))
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
	
	public static void giocatoreAcquistato(int tipo,String nomeGiocatore) throws IOException {
		File f = null;
		File f1 = null;
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		String path1=null;
		String line = "";
		String fields[];

		switch (tipo) {
		case 0:
			f = new File(pathListaPortieri);
			fr = new FileReader(pathListaPortieri);
			path1 = "src/Lista/portieri1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw= new FileWriter(f1,true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if(fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0]+",1");
					fw.append("\n");
				}
				else {
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
			fw= new FileWriter(f1,true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if(fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0]+",1");
					fw.append("\n");
				}
				else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			f1.renameTo(f);
			break;
		case 2:
			f = new File(pathListaCentrocampisti);
			fr = new FileReader(pathListaCentrocampisti);
			path1 = "src/Lista/centrocampisti1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw= new FileWriter(f1,true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if(fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0]+",1");
					fw.append("\n");
				}
				else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			f1.renameTo(f);
			break;
		case 3:
			f = new File(pathListaAttaccanti);
			fr = new FileReader(pathListaAttaccanti);
			path1 = "src/Lista/attaccanti1.csv";
			br = new BufferedReader(fr);
			f1 = new File(path1);
			fw= new FileWriter(f1,true);
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if(fields[0].equalsIgnoreCase(nomeGiocatore)) {
					fw.append(fields[0]+",1");
					fw.append("\n");
				}
				else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			f1.renameTo(f);
			break;
		default:
			System.out.println("Scelta non consentita");
		}
	}
}
