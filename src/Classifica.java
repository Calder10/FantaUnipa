import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Classe per la gestione della classifica
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */


public class Classifica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3870458223506593474L;
	private ArrayList<ArrayList<Object>> classifica;

	public ArrayList<ArrayList<Object>> getClassifica() {
		return classifica;
	}

	public void setClassifica(ArrayList<ArrayList<Object>> classifica) {
		this.classifica = classifica;
	}

	/**
     * Costruttore della classe.
     * @param squadre arraylist contenente le squadre partecipanti
     * 
     */

	public Classifica(ArrayList<Squadra> squadre) {
		classifica = new ArrayList<>();
		int i = 1;
		for (Squadra s : squadre) {
			ArrayList<Object> aus = new ArrayList<Object>();
			aus.add(i);
			aus.add(s.getPathLogo());
			aus.add(s.getNomeSquadra());
			aus.add(0);
			aus.add(0);
			aus.add(0);
			aus.add(0);
			i++;
			this.getClassifica().add(aus);
		}

	}
	
	
	/**
	 * Metodo che permette di ordinare la mappa contenente la squadra e il punteggio in classifica
	 * @param punti mappa contenente punti e classifica non ordinata
	 * @return mappa contenente punti e classifica ordinata
	 */
	public static Map<String, Integer> sortByValue(Map<String, Integer> punti) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(punti.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedMap;
	}

	/**
	 * 
	 * Metodo che permette di ordinare la classifica generale
	 * @param c ArrayList di ArrayList contenente la classifica da ordinare
	 * @return  ArrayList di ArrayList contenente la classifica ordinata
	 */
	public static ArrayList<ArrayList<Object>> sortClassifica(ArrayList<ArrayList<Object>> c) {
		ArrayList<ArrayList<Object>> ris = new ArrayList<>();
		

		Map<String, Integer> punti = new HashMap<>();
		for (ArrayList<Object> o : c) {
			String nomeSquadra = (String) o.get(2);
			int val = ((Integer) o.get(6)).intValue();
			punti.put(nomeSquadra, val);
		}
		int z=1;
		Map<String,Integer> sorted = Classifica.sortByValue(punti);
		Set<String> keys = sorted.keySet();
		for (String k: keys) {
			for (ArrayList<Object> o : c) {
				if (o.get(2).toString().equalsIgnoreCase(k)) {
					ArrayList<Object> aus = new ArrayList<>();
					aus.add(z);
					aus.add((String)o.get(1));
					aus.add(o.get(2));
					aus.add(o.get(3));
					aus.add(o.get(4));
					aus.add(o.get(5));
					aus.add(o.get(6));
					ris.add(aus);
					z++;
					break;
				}
			}
		}
		
		for (int i = 0; i < ris.size(); i++) {
			if(i==ris.size()-1)
				break;
			int val = ((Integer) ris.get(i).get(6)).intValue();
			int val1 = ((Integer) ris.get(i + 1).get(6)).intValue();
			if (val == val1) {
				int dr1 = ((Integer) ris.get(i + 1).get(3)).intValue();
				int dr2 = ((Integer) ris.get(i).get(3)).intValue();
				if (dr1 > dr2) {
					ArrayList<Object> succ = ris.get(i+1);
					ArrayList<Object> corr = ris.get(i);
					int w= (int) ris.get(i+1).get(0);
					succ.set(0, corr.get(0));
					ris.set(i, succ);
					corr.set(0, w);
					ris.set(i+1, corr);
				}
			}
		}
		
		return ris;
	}

	/**
	 * 
	 * Metodo che permette di aggiornare la classifica in base ai risultati
	 * @param g Giornata giocata
	 
	 */
	public static void updateClassifica(Giornata g) throws IOException, ClassNotFoundException {
		File f = new File("src/torneo.dat");
		FileInputStream fis = new FileInputStream(f);
		ArrayList<ArrayList<Object>> sortedClassifica = new ArrayList<>();
		ObjectInputStream ois = new ObjectInputStream(fis);
		Torneo t = (Torneo) ois.readObject();
		ois.close();
		fis.close();
		ArrayList<Partita> partite = g.getPartite().getPartite();
		String[] fields;
		ArrayList<ArrayList<Object>> c = t.getClassifica().getClassifica();
		for (Partita p : partite) {
			fields = p.getRisultato().split("-");
			int casa = Integer.parseInt(fields[0].trim());
			int trasferta = Integer.parseInt(fields[1].trim());
			int x = 0;
			int y = 0;
			for (ArrayList<Object> o : c) {
				if (o.get(2).toString().equalsIgnoreCase(p.getSquadraCasa().getNomeSquadra())) {
					if (casa == trasferta) {
						int i = ((Integer) o.get(6)).intValue();
						int val = i + 1;
						o.set(6, val);
						int golFatti= ((Integer) o.get(4)).intValue();
						o.set(4, casa+golFatti);
						int golSubiti= ((Integer) o.get(5)).intValue();
						o.set(5, trasferta+golSubiti);
						int gf = ((Integer) o.get(4)).intValue();
						int gs = ((Integer) o.get(5)).intValue();
						o.set(3, gf - gs);
					}

					if (casa > trasferta) {
						int i = ((Integer) o.get(6)).intValue();
						int val = i + 3;
						o.set(6, val);
						int golFatti= ((Integer) o.get(4)).intValue();
						o.set(4, casa+golFatti);
						int golSubiti= ((Integer) o.get(5)).intValue();
						o.set(5, trasferta+golSubiti);
						int gf = ((Integer) o.get(4)).intValue();
						int gs = ((Integer) o.get(5)).intValue();
						o.set(3, gf-gs);
					}

					if (casa < trasferta) {
						int i = ((Integer) o.get(6)).intValue();
						int val = i + 0;
						o.set(6, val);
						int golFatti= ((Integer) o.get(4)).intValue();
						o.set(4, casa+golFatti);
						int golSubiti= ((Integer) o.get(5)).intValue();
						o.set(5, trasferta+golSubiti);
						int gf = ((Integer) o.get(4)).intValue();
						int gs = ((Integer) o.get(5)).intValue();
						o.set(3, gf-gs);
					}

				}

			}

		}
		for (Partita p : partite) {
			fields = p.getRisultato().split("-");
			int casa = Integer.parseInt(fields[0].trim());
			int trasferta = Integer.parseInt(fields[1].trim());
			for (ArrayList<Object> o1 : c) {
				if (o1.get(2).toString().equalsIgnoreCase(p.getSquadraTrasferta().getNomeSquadra())) {
					if (casa == trasferta) {
						int i = ((Integer) o1.get(6)).intValue();
						int val = i + 1;
						o1.set(6, val);
						int gf = ((Integer) o1.get(4)).intValue();
						int gs = ((Integer) o1.get(5)).intValue();
						o1.set(4, trasferta+gf);
						o1.set(5, casa+gs);
						int golFatti = ((Integer) o1.get(4)).intValue();
						int golSubiti = ((Integer) o1.get(5)).intValue();
						o1.set(3, golFatti - golSubiti);
					}

					if (trasferta > casa) {
						int i = ((Integer) o1.get(6)).intValue();
						int val = i + 3;
						o1.set(6, val);
						int gf = ((Integer) o1.get(4)).intValue();
						int gs = ((Integer) o1.get(5)).intValue();
						o1.set(4, trasferta+gf);
						o1.set(5, casa+gs);
						int golFatti = ((Integer) o1.get(4)).intValue();
						int golSubiti = ((Integer) o1.get(5)).intValue();
						o1.set(3, golFatti - golSubiti);
					}

					if (trasferta < casa) {
						int i = ((Integer) o1.get(6)).intValue();
						int val = i + 0;
						o1.set(6, val);
						int gf = ((Integer) o1.get(4)).intValue();
						int gs = ((Integer) o1.get(5)).intValue();
						o1.set(4, trasferta+gf);
						o1.set(5, casa+gs);
						int golFatti = ((Integer) o1.get(4)).intValue();
						int golSubiti = ((Integer) o1.get(5)).intValue();
						o1.set(3, golFatti - golSubiti);
				
					}
				}
			}
		}

		sortedClassifica = Classifica.sortClassifica(c);
		t.getClassifica().setClassifica(sortedClassifica);
		File f1 = new File("torneo1.dat");
		FileOutputStream fos = new FileOutputStream(f1);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.close();
		fos.close();
		f1.renameTo(f);
	}
	
	/**
	 * Metodo che ritorna le squadre arrivate nelle prime tre posizioni del torneo
	 * 
	 * @return ArrayList contenente le squadre classificatosi nelle prime tre posizioni
	 */
	public static ArrayList<String> returnPodio() throws IOException, ClassNotFoundException{
		ArrayList<String> podio = new ArrayList<>();
		File f = new File("src/torneo.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Torneo t = (Torneo) ois.readObject();
		ois.close();
		fis.close();
		podio.add(t.getClassifica().getClassifica().get(0).get(2).toString());
		podio.add(t.getClassifica().getClassifica().get(1).get(2).toString());
		podio.add(t.getClassifica().getClassifica().get(2).get(2).toString());
		return podio;
		
	}
}
