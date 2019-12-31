import java.io.IOException;
import java.util.ArrayList;

public interface SubjectAsta {
	
	public void loadFantallenatori() throws IOException,ClassNotFoundException;
	public void notifyAllObserver(String username,int puntata);


}
