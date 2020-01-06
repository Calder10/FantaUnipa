import java.io.*;

public class Registrazione {
	private FantallenatoreBuilder fantallenatore;

	public void createDataFile() throws IOException {
		File f = new File("dati.csv");
		if (f.exists() == false) {
			FileWriter fw = new FileWriter(f);
			fw.append("Nome,Cognome,Username,Password,Squadra,FantaCrediti\n");
			fw.close();
		}

	}

	public boolean existSquadra(String username) {
		boolean flag = false;
		try {
			String line = "";
			FileReader f = new FileReader("dati.csv");
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

	public void salvaUtente(Fantallenatore fantallenatore) throws IOException {
		try {
			FileWriter fw = new FileWriter("dati.csv", true);
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
	
	public static String getFantaCreditiFromCsv(String username) throws IOException {
		String ris= "";
		String line = "";
		FileReader f = new FileReader("dati.csv");
		BufferedReader br = new BufferedReader(f);
		line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(",");
			if (fields[2].equalsIgnoreCase(username)) {
				ris=fields[4];
				break;
			}
		
	}
		return ris;	
	}

	public boolean checkUsername(String username) throws IOException {
		boolean flag = true;

		try {
			String line = "";
			FileReader f = new FileReader("dati.csv");
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
			FileReader f = new FileReader("dati.csv");
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
}
