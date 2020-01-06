import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public  class Torneo {
	protected String nomeTorneo;
	protected ArrayList<Squadra> squadre;
	protected ArrayList<Giornata> giornate;
	//protected Classifica classifica;
	
	//public abstract void addGiornata();
	//public abstract void addPartita(Partita p);
	
	
	
	public void uploadSquadre() throws IOException, ClassNotFoundException {
		this.squadre=new ArrayList<>();
		File f = new File("src/Squadre");
		File[] files=f.listFiles();
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		for (File x : files) {
			fis = new FileInputStream(x);
			ois = new ObjectInputStream(fis);
			Squadra s = (Squadra) ois.readObject();
			this.squadre.add(s);
		}
		ois.close();
		fis.close();
	}
	
	public ArrayList<Squadra> shiftLeft(ArrayList<Squadra> squadreCasa,Squadra riporto) {
		ArrayList<Squadra> aus = new ArrayList<Squadra>();
		for(int i=0;i<squadreCasa.size()-1;i++) {
			aus.add(squadreCasa.get(i+1));
			
		}
		int n = squadreCasa.size()-1;
		aus.add(n, riporto);
		return aus;
	}
	
	public ArrayList<Squadra> shiftRight(ArrayList<Squadra> squadreTraferta,Squadra pivot) {
		ArrayList<Squadra> aus = new ArrayList<Squadra>();
		for(int i=1;i<squadreTraferta.size();i++) {
			aus.add(squadreTraferta.get(i-1));
			
		}
		int n = squadreTraferta.size()-1;
		aus.add(0, pivot);
		return aus;
	}
	
	public void creaGiornate() {
		int numeroSquadre = this.squadre.size();
		int numeroGiornate = numeroSquadre-1;
		ArrayList<Squadra> squadreCasa = new ArrayList<Squadra>();
		ArrayList<Squadra> squadreTrasferta = new ArrayList<Squadra>();
		
		int count=0;
		for(Squadra s : this.squadre) {
			if(count!=3) {
				squadreTrasferta.add(s);
				count++;
			}
			else {
				squadreCasa.add(s);
			}
		}
		
		for (int i=0;i<numeroGiornate;i++) {
			 System.out.printf("%d^ Giornata\n",i+1);
			 Giornata g = null;
			 if(i%2==0) {
				 for(int j=0;j<numeroSquadre/2;j++) {
					 System.out.printf("%d %s-%s\n",j+1 ,squadreCasa.get(j).getNomeSquadra(),squadreTrasferta.get(j).getNomeSquadra());
					 Partita p = null;
					 p.add
				 }
			 }
			 else {
				 for(int j=0;j<numeroSquadre/2;j++) {
					 System.out.printf("%d %s-%s\n",j+1 ,squadreCasa.get(j).getNomeSquadra(),squadreTrasferta.get(j).getNomeSquadra());

				 }
			 }
			 
			 Squadra pivot = squadreCasa.get(0);
			 Squadra riporto=squadreTrasferta.get(squadreTrasferta.size()-1);
			 squadreTrasferta=shiftRight(squadreTrasferta, squadreCasa.get(1));
			 squadreCasa=shiftLeft(squadreCasa, riporto);
			 squadreCasa.set(0, pivot); 
			 
		}
	}
	public Torneo() throws ClassNotFoundException, IOException{
		this.nomeTorneo="FantaUnipa";
		this.uploadSquadre();
		this.creaGiornate();
	}
	
	public static void main(String args[]) throws ClassNotFoundException, IOException {
		Torneo t = new Torneo();
	}

}
