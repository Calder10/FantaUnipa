import java.io.Serializable;
import java.util.ArrayList;

public class Partite implements Serializable{
	private ArrayList<Partita> partite;
	
	public Partite() {
		this.partite=new ArrayList<Partita>();
	}

	public ArrayList<Partita> getPartite() {
		return partite;
	}

	public void setPartite(ArrayList<Partita> partite) {
		this.partite = partite;
	}
	
}
