import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Giornate implements Serializable {

	/** Classe per la gestione delle Giornate del torneo
	 * @author Salvatore Calderaro
	 * @author Gaspare Casano 
	 */
	private static final long serialVersionUID = -2567694931019254675L;
	private ArrayList<Giornata> giornate;

	/**
	 * @param squadre che partecipano al torneo
	 */
	public Giornate(ArrayList<Squadra> squadre) {
		this.giornate = new ArrayList<Giornata>();
		creaGiornate(squadre);
	}

	public ArrayList<Giornata> getGiornate() {
		return giornate;
	}

	public void setGiornate(ArrayList<Giornata> giornate) {
		this.giornate = giornate;
	}
	
	
	
	/**Metodo che sostituisce l'ultimo elemento delle squadre selezionate per giocare in casa  con l'ultimo elemento delle squadre che giocano in trasferta
	 * @param squadreCasa ArrayList delle squadre che sono state selezionate per giocare in casa
	 * @param riporto ultimo elemento dell'ArrayList delle squadre di trasferta
	 * @return ArrayList di squadre
	 */
	public ArrayList<Squadra> shiftLeft(ArrayList<Squadra> squadreCasa, Squadra riporto) {
		ArrayList<Squadra> aus = new ArrayList<Squadra>();
		for (int i = 0; i < squadreCasa.size() - 1; i++) {
			aus.add(squadreCasa.get(i + 1));

		}
		int n = squadreCasa.size() - 1;
		aus.add(n, riporto);
		return aus;
	}
	

	/**
	 * Metodo che sostituisce il primo elemento delle squadre selezionate per giocare in trasferta con primo elemento delle squadre che giocano in casa
	 * @param squadreTraferta ArrayList delle squadre che sono state selezionate per giocare in trasferta
	 * @param pivot primo elemento dell'ArrayList delle squadre di casa 
	 * @return ArrayList di squadre
	 */
	public ArrayList<Squadra> shiftRight(ArrayList<Squadra> squadreTraferta, Squadra pivot) {
		ArrayList<Squadra> aus = new ArrayList<Squadra>();
		for (int i = 1; i < squadreTraferta.size(); i++) {
			aus.add(squadreTraferta.get(i - 1));

		}
		aus.add(0, pivot);
		return aus;
	}

	
	/** Metodo che tramite l'algorimto di Berger, crea campionato strutturato in giornate con la formula del girone all'italiana 
	 * @param squadre ArrayList delle squadre che parteciperanno al campionato.
	 */
	public void creaGiornate(ArrayList<Squadra> squadre) {
		int numeroSquadre = squadre.size();
		int numeroGiornate = numeroSquadre - 1;
		ArrayList<Squadra> squadreCasa = new ArrayList<Squadra>();
		ArrayList<Squadra> squadreTrasferta = new ArrayList<Squadra>();

		int count = 0;
		for (Squadra s : squadre) {
			if (count != 3) {
				squadreTrasferta.add(s);
				count++;
			} else {
				squadreCasa.add(s);
			}
		}

		for (int i = 0; i < numeroGiornate; i++) {
			Partite partite = new Partite();
			if (i % 2 == 0) {
				for (int j = 0; j < numeroSquadre / 2; j++) {
					Squadra casa = squadreCasa.get(j);
					Squadra trasferta = squadreTrasferta.get(j);
					Partita p = new Partita(casa, trasferta);
					partite.getPartite().add(p);
				}
			} else {
				for (int j = 0; j < numeroSquadre / 2; j++) {
					Squadra casa = squadreCasa.get(j);
					Squadra trasferta = squadreTrasferta.get(j);
					Partita p = new Partita(casa, trasferta);
					partite.getPartite().add(p);
				}
			}
			Giornata g = new Giornata(partite);
			this.giornate.add(g);
			Squadra pivot = squadreCasa.get(0);
			Squadra riporto = squadreTrasferta.get(squadreTrasferta.size() - 1);
			squadreTrasferta = shiftRight(squadreTrasferta, squadreCasa.get(1));
			squadreCasa = shiftLeft(squadreCasa, riporto);
			squadreCasa.set(0, pivot);

		}
	}
	
}
