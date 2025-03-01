import java.io.*;


/** Classe per la gestione delle operazioni di login e registrazione
 * @author Salvatore Calderaro
 *@author Gaspare Casano
 */
public class Registrazione {
	private FantallenatoreBuilder fantallenatore;

	/**Metodo che che crea il file CSV dove verranno salvati i dati sia dell'utente che dei fantallenatori virtuali
	 * @throws IOException
	 */
	public void createDataFile() throws IOException {
		File f = new File("src/dati.csv");
		if (f.exists() == false) {
			FileWriter fw = new FileWriter(f);
			fw.append("Nome,Cognome,Username,Password,Squadra,FantaCrediti\n");
			fw.close();
		}

	}

	/** Metodo che controlla se è associata una squadra ad un determinato username
	 * @param username su cui effettuare il controllo
	 * @return false se la squadra deve essere ancora inserita, true altrimenti
	 */
	public boolean existSquadra(String username) {
		boolean flag = false;
		try {
			String line = "";
			FileReader f = new FileReader("src/dati.csv");
			BufferedReader br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields[2].equalsIgnoreCase(username) && (fields[4].equalsIgnoreCase(""))) {

					flag = false;
					break;
				}
				else
					flag=true;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Errore nella lettura del file !");
		}

		return flag;
	}

	/** Metodo che salva su file CSV alcune informazioni inerenti il fantallenatore
	 * @param fantallenatore Fantallenatore da cui prelevare le informazioni da inserire nel file
	 * @throws IOException
	 */
	public void salvaUtente(Fantallenatore fantallenatore) throws IOException {
		try {
			FileWriter fw = new FileWriter("src/dati.csv", true);
			fw.append(fantallenatore.getNome());
			fw.append(",");
			fw.append(fantallenatore.getCognome());
			fw.append(",");
			fw.append(fantallenatore.getUsername());
			fw.append(",");
			fw.append(fantallenatore.getPassword());
			fw.append(",");
			fw.append("");
			fw.append(",");
			fw.append(Integer.toString(fantallenatore.getFantaCrediti()));
			fw.append("\n");
			fw.close();

		} catch (Exception e) {
			System.out.println("Errore nella scrittura su file !");
		}
	}
	
	/** Metodo che ritorna i fantacrediti associati ad un determinato username
	 * @param username su cui effettuare il controllo.
	 * @return stringa che rappresenta i fantacrediti
	 * @throws IOException
	 */
	public static String getFantaCreditiFromCsv(String username) throws IOException {
		String ris = "";
		String line = "";
		FileReader f = new FileReader("src/dati.csv");
		BufferedReader br = new BufferedReader(f);
		line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(",");
			if (fields[2].equalsIgnoreCase(username)) {
				ris = fields[5];
				break;
			}

		}
		return ris;
	}

	/** Metodo che controlla se un determinato username è stato già utilizzato o meno 
	 * @param username su cui effettuare il controllo 
	 * @return false se l'username è stato già usato , true altrimenti.
	 * @throws IOException
	 */
	public boolean checkUsername(String username) throws IOException {
		boolean flag = true;

		try {
			String line = "";
			FileReader f = new FileReader("src/dati.csv");
			BufferedReader br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields[2].equalsIgnoreCase(username)) {

					flag = false;
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Errore nella lettura del file !");
		}

		return flag;
	}

	/** Metodo che controlla se la password rispetta o meno determinati parametri 
	 * @param password su cui effettuare il controllo
	 * @return true se la password rispetta i parametri, false altrimenti
	 */
	public boolean checkPassword(String password) {
		int digits = 0;
		int upper_char = 0;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isDigit(c))
				digits++;
			if (c >= 'A' && c <= 'Z')
				upper_char++;
		}

		if (password.length() >= 6 && digits >= 1 && upper_char >= 1)
			return true;
		else
			return false;
	}

	public boolean login(String usr, String pwd) throws IOException {
		boolean ris = false;
		try {
			String line = "";
			FileReader f = new FileReader("src/dati.csv");
			BufferedReader br = new BufferedReader(f);
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields[2].equals(usr) && fields[3].equals(pwd)) {
					ris = true;
					break;
				} else
					ris = false;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Errore nella lettura del file !");
		}
		return ris;
	}

	public boolean controlloCampiNonNulli(String nome, String cognome, String username, String password) {
		if (nome.equalsIgnoreCase("") || cognome.equalsIgnoreCase("") || username.equalsIgnoreCase("")
				|| password.equalsIgnoreCase(""))
			return false;
		else
			return true;
	}

	public void creaFantallenatoriVirtuali() throws IOException {
		ConcreteFantallenatoreVirtualBuilder b = new ConcreteFantallenatoreVirtualBuilder();
		Director e = new Director(b);
		for (int i = 0; i < 5; i++) {
			String nome = "", cognome = "", username = "", password = "";
			e.createFantallenatore(nome, cognome, username, password);
			Fantallenatore f = e.getFantallenatore();
			this.salvaUtente(f);
		}
	}
	
	public static void resetDati() throws IOException {
		File f = new File("src/dati.csv");
		File f1 = new File("src/dati1.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fv = new FileWriter(f1,true);
		String line="";
		String aus="";
		String [] fields;
		while((line=br.readLine())!=null) {
			fields=line.split(",");
			fv.append(fields[0]);
			fv.append(",");
			fv.append(fields[1]);
			fv.append(",");
			fv.append(fields[2]);
			fv.append(",");
			fv.append(fields[3]);
			fv.append(",");
			fv.append("");
			fv.append(",");
			fv.append("500");
			fv.append(",");
			fv.append("\n");
		}
		fv.close();
		br.close();
		fr.close();
		f1.renameTo(f);
	}
}
