import java.io.*;

public class  Registrazione {
	//private FantallenatoreBuilder fantallenatore;
	
	public void salvaUtente(Fantallenatore fantallenatore) throws IOException{
		try {
			FileWriter fw = new FileWriter("dati.csv",true);
			fw.append(fantallenatore.getNome());
			fw.append(",");
			fw.append(fantallenatore.getCognome());
			fw.append(",");
			fw.append(fantallenatore.getUsername());
			fw.append(",");
			fw.append(fantallenatore.getPassword());
			fw.append(",");
			fw.append(Integer.toString(fantallenatore.getFantaCrediti()));
			fw.append("\n");
			fw.close();
			
		}catch (Exception e) {
			System.out.println("Errore nella scrittura su file !");
		}
	}
	
	
	public boolean checkUsername(String username) throws IOException{
		boolean flag = false;
		try {
			String line="";
			FileReader f = new FileReader("dati.csv");
			BufferedReader br = new BufferedReader(f);
			br.readLine();
			while((line=br.readLine())!=null) {
				String [] fields = line.split(",");
				if(fields[2].equalsIgnoreCase(username)==true) {
					flag=false;
					break;
				}
				else
					flag = true;
			}
			br.close();
		}catch (Exception e) {
			System.out.println("Errore nella lettura del file !");
		}
		
		return flag;
	}
	
	public boolean checkPassword(String password){
		int digits=0;
		int upper_char=0;
		for (int i=0 ;i<password.length();i++) {
			char c = password.charAt(i);
			if(Character.isDigit(c))
				digits++;
			if(c>='A' && c<='Z')
				upper_char++;
		}
		
		if(password.length()>=6 && digits>=1 && upper_char>=1)
			return true;
		else
			return false;
	}
}
