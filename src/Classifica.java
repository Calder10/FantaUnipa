import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
	
	public static void sortClassifica(ArrayList<ArrayList<Object>> c) {
		c.sort(c);
	}

	public static void updateClassifica(Giornata g) throws IOException, ClassNotFoundException {
		File f = new File("src/torneo.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Torneo t = (Torneo) ois.readObject();
		ois.close();
		fis.close();
		ArrayList<Partita> partite = g.getPartite().getPartite();
		String[] fields;
		ArrayList<ArrayList<Object>> c = t.getClassifica().getClassifica();
		ArrayList<Object> a = new ArrayList<Object>();
		ArrayList<Object> b = new ArrayList<Object>();
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
						int val = i+1;
						o.set(6, val);
						o.set(4, casa);
						o.set(5, trasferta);
						int gf = ((Integer) o.get(4)).intValue();
						int gs = ((Integer) o.get(5)).intValue();
						o.set(3, gf-gs);
					}

					if (casa > trasferta) {
						int i = ((Integer) o.get(6)).intValue();
						int val = i+3;
						o.set(6, val);
						o.set(4, casa);
						o.set(5, trasferta);
						int gf = ((Integer) o.get(4)).intValue();
						int gs = ((Integer) o.get(5)).intValue();
						o.set(3, gf-gs);
					}

					if (casa < trasferta) {
						int i = ((Integer) o.get(6)).intValue();
						int val = i+0;
						o.set(6, val);
						o.set(4, casa);
						o.set(5, trasferta);
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
						int val = i+1;
						o1.set(6, val);
						o1.set(4, trasferta);
						o1.set(5, casa);
						int gf = ((Integer) o1.get(4)).intValue();
						int gs = ((Integer) o1.get(5)).intValue();
						o1.set(3, gf-gs);
					}

					if (trasferta>casa) {
						int i = ((Integer) o1.get(6)).intValue();
						int val = i+3;
						o1.set(6, val);
						o1.set(4, trasferta);
						o1.set(5, casa);
						int gf = ((Integer) o1.get(4)).intValue();
						int gs = ((Integer) o1.get(5)).intValue();
						o1.set(3, gf-gs);
					}
					
					if (trasferta<casa) {
						int i = ((Integer) o1.get(6)).intValue();
						int val = i+0;
						o1.set(6, val);
						o1.set(4, trasferta);
						o1.set(5, casa);
						int gf = ((Integer) o1.get(4)).intValue();
						int gs = ((Integer) o1.get(5)).intValue();
						o1.set(3, gf-gs);
					}
				}
			}
		}
		// metodo sorting;
		t.getClassifica().setClassifica(c);
		File f1 = new File("torneo1.dat");
		FileOutputStream fos = new FileOutputStream(f1);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.close();
		fos.close();
		f1.renameTo(f);
	}
}
