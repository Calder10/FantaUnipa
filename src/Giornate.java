import java.io.Serializable;
import java.util.ArrayList;

public class Giornate implements Serializable{
	private Partite partite;
	private ArrayList<Giornata> giornate;
	
	public Giornate(ArrayList<Squadra> squadre) {
		this.giornate= new ArrayList<Giornata>();
		creaGiornate(squadre);
	}
	
	public ArrayList<Giornata> getGiornate() {
		return giornate;
	}

	public void setGiornate(ArrayList<Giornata> giornate) {
		this.giornate = giornate;
	}

	public Partite getPartite() {
		return partite;
	}

	public void setPartite(Partite partite) {
		this.partite = partite;
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
	
	
	// Algoritmo di Berger
	public void creaGiornate(ArrayList<Squadra> squadre) {
		int numeroSquadre = squadre.size();
		int numeroGiornate = numeroSquadre-1;
		ArrayList<Squadra> squadreCasa = new ArrayList<Squadra>();
		ArrayList<Squadra> squadreTrasferta = new ArrayList<Squadra>();
		
		int count=0;
		for(Squadra s : squadre) {
			if(count!=3) {
				squadreTrasferta.add(s);
				count++;
			}
			else {
				squadreCasa.add(s);
			}
		}
		
		for (int i=0;i<numeroGiornate;i++) {
			 Partite partite = new Partite();
			 if(i%2==0) {
				 for(int j=0;j<numeroSquadre/2;j++) {
					 Squadra casa = squadreCasa.get(j);
					 Squadra trasferta=squadreTrasferta.get(j);
					 Partita p = new Partita( casa,trasferta);
					 partite.getPartite().add(p);
				 }
			 }
			 else {
				 for(int j=0;j<numeroSquadre/2;j++) {
					 Squadra casa = squadreCasa.get(j);
					 Squadra trasferta=squadreTrasferta.get(j);
					 Partita p = new Partita( casa,trasferta);
					 partite.getPartite().add(p);
				 }
			 }
			 Giornata g = new Giornata(partite);
			 this.setPartite(partite);
			 this.giornate.add(g);
			 Squadra pivot = squadreCasa.get(0);
			 Squadra riporto=squadreTrasferta.get(squadreTrasferta.size()-1);
			 squadreTrasferta=shiftRight(squadreTrasferta, squadreCasa.get(1));
			 squadreCasa=shiftLeft(squadreCasa, riporto);
			 squadreCasa.set(0, pivot);
			 
		}
	}
}
