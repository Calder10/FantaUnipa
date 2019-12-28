import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files; 
import java.nio.file.*; 

public class Squadra {
	private Fantallenatore fantallenatore;
	private String nomeSquadra;
	private String pathLogo;
	private List<Portiere> portieri;
	private List <Difensore> difensori;
	private List <Centrocampista> centrocampisti;
	private List <Attaccante> attaccanti;
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
	
	public void addNomeSquadraToCsv(String username,String nomeSquadra) throws IOException{
		try {
			File f = new File("dati.csv");
			File f1 = new File("dat1.csv");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw  = new FileWriter(f1,true);
			String line="";
			String [] fields;
			line=br.readLine();
			fw.append(line);
			fw.append("\n");
			while((line=br.readLine())!=null) {
				fields=line.split(",");
				if(fields[2].equalsIgnoreCase(username) && fields[4].equalsIgnoreCase("")) {
					fields[4]=nomeSquadra;
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
				}
				else {
					fw.append(line);
					fw.append("\n");
				}
			}
			br.close();
			//f.delete();
			fw.close();
			f1.renameTo(f);
		}catch(Exception e) {
			System.out.println("Errore nella scrittura su file !");
		}
	}
	
	public void salvaLogo(File f) {
		BufferedImage i = null;
		//boolean dir = new File("src/Loghi").mkdir();
        try {
        	i = ImageIO.read(f);
        	String pathDest=("src/Loghi/"+this.nomeSquadra.trim()+".png").trim();
        	File f1= new File(pathDest);
        	ImageIO.write(i, "png", f1);
      } catch (IOException e) {
              System.out.println("Errore nel salvataggio dell'immagine !");
        } 
   }
		
	}
	
	

