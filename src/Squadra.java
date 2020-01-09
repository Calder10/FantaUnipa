import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.*;

public class Squadra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772300263662162498L;
	protected Fantallenatore fantallenatore;
	protected String nomeSquadra;
	protected String pathLogo;
	protected List<Portiere> portieri;
	protected List<Difensore> difensori;
	protected List<Centrocampista> centrocampisti;
	protected List<Attaccante> attaccanti;

	public Squadra() {
		this.portieri = new ArrayList<Portiere>();
		this.difensori = new ArrayList<Difensore>();
		this.centrocampisti = new ArrayList<Centrocampista>();
		this.attaccanti = new ArrayList<Attaccante>();
	}

	public Fantallenatore getFantallenatore() {
		return fantallenatore;
	}

	public void setFantallenatore(Fantallenatore fantallenatore) {
		this.fantallenatore = fantallenatore;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String logo) {
		this.pathLogo = logo;
	}

	public List<Portiere> getPortieri() {
		return portieri;
	}

	public List<Difensore> getDifensori() {
		return difensori;
	}

	public List<Centrocampista> getCentrocampisti() {
		return centrocampisti;
	}

	public List<Attaccante> getAttaccanti() {
		return attaccanti;
	}

	public void addNomeSquadraToCsv(String username, String nomeSquadra) throws IOException {
		try {
			File f = new File("src/dati.csv");
			File f1 = new File("dat1.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f1, true);
			String line = "";
			String[] fields;
			line = br.readLine();
			fw.append(line);
			fw.append("\n");
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				if (fields[2].equalsIgnoreCase(username) && fields[4].equalsIgnoreCase("")) {
					fields[4] = nomeSquadra;
					fw.append(fields[0]);
					fw.append(",");
					fw.append(fields[1]);
					fw.append(",");
					fw.append(fields[2]);
					fw.append(",");
					fw.append(fields[3]);
					fw.append(",");
					fw.append(fields[4]);
					fw.append(",");
					fw.append(fields[5]);
					fw.append("\n");
				} else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			fw.close();
			f1.renameTo(f);
		} catch (Exception e) {
			System.out.println("Errore nella scrittura su file !");
		}
	}

	public void salvaLogo(File f) {
		BufferedImage i = null;
		try {
			boolean dest = new File("src/Loghi").mkdir();
			i = ImageIO.read(f);
			String pathDest = ("src/Loghi/" + this.nomeSquadra.trim() + ".png").trim();
			File f1 = new File(pathDest);
			ImageIO.write(i, "png", f1);
			this.pathLogo = pathDest;
		} catch (IOException e) {
			System.out.println("Errore nel salvataggio dell'immagine !");
		}
	}

	public void salvaSquadraSuFile() throws IOException {
		boolean dest = new File("src/Squadre").mkdir();
		String pathDest = ("src/Squadre/" + this.nomeSquadra.trim() + ".dat").trim();
		Fantallenatore g = Fantallenatore.getFantallenatoreFromCsv(this.nomeSquadra);
		this.fantallenatore = g;
		File f = new File(pathDest);
		FileOutputStream fos = new FileOutputStream(f);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (Exception e) {
			System.out.println("Errore durante il salvatggio su file !");
		}
	}

	public void addGiocatore(Giocatore g, int tipo) {
		switch (tipo) {
		case 0:
			this.portieri.add((Portiere) g);
			break;

		case 1:
			this.difensori.add((Difensore) g);
			break;

		case 2:
			this.centrocampisti.add((Centrocampista) g);
			break;

		case 3:
			this.attaccanti.add((Attaccante) g);
			break;
		default:
			System.out.println("Scelta non consentita");
		}
	}

	@Override
	public String toString() {
		return "Squadra [fantallenatore=" + fantallenatore + ", nomeSquadra=" + nomeSquadra + ", pathLogo=" + pathLogo
				+ ", portieri=" + portieri + ", difensori=" + difensori + ", centrocampisti=" + centrocampisti
				+ ", attaccanti=" + attaccanti + "]";
	}

	public void updateSquadra() throws IOException {
		String path = "src/Squadre/" + this.getNomeSquadra() + ".dat";
		String path1 = "src/Squadre/" + this.getNomeSquadra() + "1.dat";
		File f = new File(path);
		File f1 = new File(path1);
		FileOutputStream fos = new FileOutputStream(f1);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject((Squadra) this);
			oos.close();
		} catch (Exception e) {
			System.out.println("Errore durante il salvatggio su file !");
		}
		fos.close();
		f1.renameTo(f);
	}

	public static Squadra getSquadraFromFile(String username) throws IOException {
		String nomeSquadra;
		String pathSquadra;
		Squadra squadra = null;
		List<List<String>> values = null;
		try (Stream<String> stream = Files.lines(Paths.get("src/dati.csv"))) {

			values = stream.skip(1).filter(line -> line.contains(username)).map(line -> Arrays.asList(line.split(",")))
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
		nomeSquadra = values.get(0).get(4);
		List<String> result = null;
		try (Stream<Path> walk = Files.walk(Paths.get("src/Squadre"))) {

			result = walk.map(x -> x.toString()).filter(f -> f.contains(nomeSquadra)).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Errore nelal lettura del file !");
		}
		pathSquadra = result.get(0);
		File f = new File(pathSquadra);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			squadra = (Squadra) ois.readObject();
			ois.close();
			fis.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.out.println("Errore nella lettura da file !");
		}
		return squadra;
	}
	
	public static ArrayList<Squadra> getSquadreVirtualiFromFile(String nomeSquadra) throws ClassNotFoundException{
		ArrayList<Squadra> squadre = new ArrayList<>();
		List<String> paths=null;
		try (Stream<Path> walk = Files.walk(Paths.get("src/Squadre"))) {
			paths = walk.map(x -> x.toString()).filter(f -> f.contains(nomeSquadra)==false).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file !");
		}
		
		paths.remove(0);
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Squadra s = null;
		for(String path : paths) {
			f = new File(path);
			try {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				s = (Squadra) ois.readObject();
				squadre.add(s);
				ois.close();
				fis.close();
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file !");
			}
			
		}
		return squadre;
	}

}
