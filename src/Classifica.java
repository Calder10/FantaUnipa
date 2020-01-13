import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Classifica implements Serializable{

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
		int i=1;
		for(Squadra s: squadre) {
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
	
	public static void updateClassifica(Giornata g) throws IOException, ClassNotFoundException {
		File f = new File ("src/torneo.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Torneo t = (Torneo) ois.readObject();
		ois.close();
		fis.close();
		 ArrayList<Partita> partite = g.getPartite().getPartite();
		 ArrayList<Object> aus= new ArrayList<Object>();
		 String [] fields;
		 ArrayList<ArrayList<Object>> c= t.getClassifica().getClassifica();
		 for(Partita p : partite) {
			 fields=p.getRisultato().split("-");
			 int casa = Integer.parseInt(fields[0]);
			 int trasferta = Integer.parseInt(fields[1]);
			 for (ArrayList<Object> o : c) {
				 for(ArrayList<Object> o1 :c) {
					 if(((String) o.get(2)).equalsIgnoreCase(p.getSquadraCasa().getNomeSquadra())&& ((String) o1.get(2)).equalsIgnoreCase(p.getSquadraTrasferta().getNomeSquadra())) {
						 if(casa==trasferta) {
							 
							 o.set(7,((Integer) o.get(6)+1));
							 o.set(4, fields[0]);
							 o.set(5,fields[1]);
							 o.set(3, ((Integer)o.get(4)- (Integer)o.get(5)));
							 
							 o1.set(7,(Integer)o1.get(6)+1);
							 o1.set(4, fields[1]);
							 o1.set(5,fields[0]);
							 o1.set(3, ((Integer) o1.get(4)- (Integer)o1.get(5)));
						 }
						if(casa>trasferta) {
							o.set(7,(Integer) o.get(6)+3);
							 o.set(4, fields[0]);
							 o.set(5,fields[1]);
							 o.set(3, ((Integer) o.get(4)- (Integer) o.get(5)));
							 
							 o1.set(7,(Integer)o.get(6)+0);
							 o1.set(4, fields[1]);
							 o1.set(5,fields[0]);
							 o1.set(3, ((Integer) o1.get(4)- (Integer)o1.get(5)));
						}
						
						if(casa<trasferta) {
							o.set(7,(Integer) o.get(6)+0);
							 o.set(4, fields[0]);
							 o.set(5,fields[1]);
							 o.set(3, ((Integer) o.get(4)- (Integer) o.get(5)));
							 
							 o1.set(7,(Integer)o.get(6)+3);
							 o1.set(4, fields[1]);
							 o1.set(5,fields[0]);
							 o1.set(3, ((Integer)o1.get(4)- (Integer)o1.get(5)));
						}
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
