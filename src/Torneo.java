import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Torneo implements Serializable {
	/**
	 * Classe per la gestione dell'entità torneo
	 * @author Salvatore Calderaro
	 * @author Gaspare Casano
	 */
	private static final long serialVersionUID = 7858483060552979173L;
	private String nomeTorneo;
	private ArrayList<Squadra> squadre;
	private Giornate giornate;
	private Classifica classifica;
	private static Torneo torneo;

	private Torneo() {
	}

	/** Metodo che restituisce il torneo
	 * @return torneo
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Torneo getTorneo() throws ClassNotFoundException, IOException {
		if (torneo == null) {
			torneo = new Torneo();
			torneo.nomeTorneo = "FantaUnipa";
			torneo.uploadSquadre();
			torneo.giornate = new Giornate(torneo.squadre);
			torneo.classifica=new Classifica(torneo.squadre);
		}
		return torneo;
	}

	public String getNomeTorneo() {
		return nomeTorneo;
	}

	public void setNomeTorneo(String nomeTorneo) {
		this.nomeTorneo = nomeTorneo;
	}

	public ArrayList<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(ArrayList<Squadra> squadre) {
		this.squadre = squadre;
	}

	public Giornate getGiornate() {
		return giornate;
	}

	public void setGiornate(Giornate giornate) {
		this.giornate = giornate;
	}

	

	public Classifica getClassifica() {
		return classifica;
	}

	public void setClassifica(Classifica classifica) {
		this.classifica = classifica;
	}

	/** Metodo che carica da file le squadre che devono partecipare al torneo
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void uploadSquadre() throws IOException, ClassNotFoundException {
		this.squadre = new ArrayList<>();
		File f = new File("src/Squadre");
		File[] files = f.listFiles();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		for (File x : files) {
			fis = new FileInputStream(x);
			ois = new ObjectInputStream(fis);
			Squadra s = (Squadra) ois.readObject();
			this.squadre.add(s);
		}
		ois.close();
		fis.close();
	}

	/**
	 *  Metodo che salva il torneo su file
	 */
	public void saveTorneo() {
		File f = new File("src/torneo.dat");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject((Torneo) this);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Errore nella scrittura su file !");
		}
	}
	
	/** Metodo che cancella file torneo, i file delle squadre in modo da poter inziiare un nuovo torneo 
	 * @throws IOException
	 */
	public static void resetTorneo() throws IOException {
		File dir = new File("src/Squadre");
		File [] files = dir.listFiles();
		for (File x : files) {
			x.delete();
		}
		dir.delete();
		File t = new File("src/torneo.dat");
		t.delete();
		Registrazione.resetDati();
		
		File p = new File("src/Lista/portieri.csv");
		p.delete();
		File d = new File("src/Lista/difensori.csv");
		d.delete();
		File c = new File("src/Lista/centrocampisti.csv");
		c.delete();
		File a = new File("src/Lista/attaccanti.csv");
		a.delete();
		UtilityListaGiocatori.creaListe();
		Torneo.torneo=null;
	}

}
