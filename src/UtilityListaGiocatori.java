import java.io.*;

public class UtilityListaGiocatori {
	
	public static void creaListaPortieri() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		String path="src/Lista/portieri.csv";
		File f = new File (path);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome\n");
		String path1="src/Lista/listaCalciatoriCompleta.csv";
		FileReader fr = new FileReader(path1);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while((line=br.readLine())!=null) {
			String fields [] = line.split(",");
			if(fields[0].equals("P")) {
				fw.append(fields[1]);
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}
	
	public static void creaListaDifensori() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		String path="src/Lista/difensori.csv";
		File f = new File (path);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome\n");
		String path1="src/Lista/listaCalciatoriCompleta.csv";
		FileReader fr = new FileReader(path1);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while((line=br.readLine())!=null) {
			String fields [] = line.split(",");
			if(fields[0].equals("D")) {
				fw.append(fields[1]);
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}
	
	public static void creaListaCentrocampisti() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		String path="src/Lista/centrocampisti.csv";
		File f = new File (path);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome\n");
		String path1="src/Lista/listaCalciatoriCompleta.csv";
		FileReader fr = new FileReader(path1);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while((line=br.readLine())!=null) {
			String fields [] = line.split(",");
			if(fields[0].equals("C")) {
				fw.append(fields[1]);
				fw.append("\n");
			}
		}
		br.close();
		fr.close();
		fw.close();
	}
	
	public static void creaListaAttaccanti() throws IOException {
		boolean dir = new File("src/Lista").mkdir();
		String path="src/Lista/attaccanti.csv";
		File f = new File (path);
		FileWriter fw = new FileWriter(f);
		fw.append("Nome\n");
		String path1="src/Lista/listaCalciatoriCompleta.csv";
		FileReader fr = new FileReader(path1);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while((line=br.readLine())!=null) {
			String fields [] = line.split(",");
			if(fields[0].equals("A")) {
				fw.append(fields[1]);
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

}
