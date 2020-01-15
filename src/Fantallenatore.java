import java.io.*;

/**
 * Classe che rappresenta l'entità Fantallenatore
 * 
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */

public class Fantallenatore implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4128003979802930265L;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String nomeSquadra;
	private int fantaCrediti;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public int getFantaCrediti() {
		return fantaCrediti;
	}

	public void setFantaCrediti(int fantaCrediti) {
		this.fantaCrediti = fantaCrediti;
	}
	
	/**
	 * Metodo che ritorna il fantallenatore dal file
	 * @param nomeSquadra a cui appartiene il fantallenatore
	 * @return entità Fantallenatore
	 */
	public static Fantallenatore getFantallenatoreFromCsv(String nomeSquadra) throws IOException {
		Fantallenatore f = new Fantallenatore();
		FileReader fr = new FileReader("src/dati.csv");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String [] fields = line.split(",");
			if(fields[4].equalsIgnoreCase(nomeSquadra)) {
				f.setNome(fields[0]);
				f.setCognome(fields[1]);
				f.setUsername(fields[2]);
				f.setPassword(fields[3]);
				f.setNomeSquadra(fields[4]);
				f.setFantaCrediti(Integer.parseInt(fields[5]));
				break;
			}
		}
		br.close();
		fr.close();
		return f;
	}

	@Override
	public String toString() {
		return "Fantallenatore [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
				+ password + ", nomeSquadra=" + nomeSquadra + ", fantaCrediti=" + fantaCrediti + "]";
	}

}
