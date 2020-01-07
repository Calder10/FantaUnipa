import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Giornata implements Serializable{

	private Partite partite;
	
	public Giornata(Partite partite) {
		this.partite=partite;
	}

	public Partite getPartite() {
		return partite;
	}

	public void setPartite(Partite partite) {
		this.partite = partite;
	}	
}
