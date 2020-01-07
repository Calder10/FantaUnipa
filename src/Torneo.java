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
	private String nomeTorneo;
	private ArrayList<Squadra> squadre;
	private Giornate giornate;
	// private Classifica classifica;
	private static Torneo torneo;

	private Torneo() {
	}

	public static Torneo getTorneo() throws ClassNotFoundException, IOException {
		if (torneo == null) {
			torneo = new Torneo();
			torneo.nomeTorneo = "FantaUnipa";
			torneo.uploadSquadre();
			torneo.giornate = new Giornate(torneo.squadre);
			// torneo.classifica=new Classifica();
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

	/*
	 * 
	 * public Classifica getClassifica() { return classifica; }
	 * 
	 * public void setClassifica(Classifica classifica) { this.classifica =
	 * classifica; }
	 * 
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

}
