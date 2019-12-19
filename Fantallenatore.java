
public class Fantallenatore {
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Squadra squadra;
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

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public int getFantaCrediti() {
		return fantaCrediti;
	}

	public void setFantaCrediti(int fantaCrediti) {
		this.fantaCrediti = fantaCrediti;
	}

	@Override
	public String toString() {
		return "Fantallenatore [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
				+ password + ", squadra=" + squadra + ", fantaCrediti=" + fantaCrediti + "]";
	}
	
	

}
