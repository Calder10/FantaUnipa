import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Giornata implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2251213532547137066L;
	private Partite partite;
	boolean giocata=false;
	
	public Giornata(Partite partite) {
		this.partite=partite;
	}

	public Partite getPartite() {
		return partite;
	}

	public void setPartite(Partite partite) {
		this.partite = partite;
	}
	
	public boolean isGiocata() {
		return this.giocata;
	}
	
	public void setGicata(boolean giocata) {
		this.giocata=giocata;
	}
	
	
	public static void visualizzaGiornata(CalendarioGUI calendarioGUI,int numeroGiornata){
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream  ois =null;
		Giornata g = null;
		Torneo t;
		try {
			f = new File("src/torneo.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			t=(Torneo) ois.readObject();
			g=t.getGiornate().getGiornate().get(numeroGiornata-1);
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			//System.out.println("Errore nella lettura dal file !");
		}
		ImageIcon img = null;
		calendarioGUI.getLblNewLabelGiornata().setText("Giornata "+numeroGiornata);
		img = new ImageIcon(g.getPartite().getPartite().get(0).getSquadraCasa().getPathLogo());
		calendarioGUI.getLblNewLabelLogoCasa1().setIcon(img);
		img = new ImageIcon(g.getPartite().getPartite().get(0).getSquadraTrasferta().getPathLogo());
		calendarioGUI.getLblNewLabelLogoTrasferta1().setIcon(img);
		calendarioGUI.getLblNewLabelNomeCasa1().setText(g.getPartite().getPartite().get(0).getSquadraCasa().getNomeSquadra());
		calendarioGUI.getLblNewLabelNomeTrasferta1().setText(g.getPartite().getPartite().get(0).getSquadraTrasferta().getNomeSquadra());
		if(g.getPartite().getPartite().get(0).getRisultato()!=null)
			calendarioGUI.getLblNewLabelRis1().setText(g.getPartite().getPartite().get(0).getRisultato());
		else
			calendarioGUI.getLblNewLabelRis1().setText(" - ");
		
	
		img = new ImageIcon(g.getPartite().getPartite().get(1).getSquadraCasa().getPathLogo());
		calendarioGUI.getLblNewLabelLogoCasa2().setIcon(img);
		img = new ImageIcon(g.getPartite().getPartite().get(1).getSquadraTrasferta().getPathLogo());
		calendarioGUI.getLblNewLabelLogoTrasferta2().setIcon(img);
		calendarioGUI.getLblNewLabelNomeCasa2().setText(g.getPartite().getPartite().get(1).getSquadraCasa().getNomeSquadra());
		calendarioGUI.getLblNewLabelNomeTrasferta2().setText(g.getPartite().getPartite().get(1).getSquadraTrasferta().getNomeSquadra());
		if(g.getPartite().getPartite().get(1).getRisultato()!=null)
			calendarioGUI.getLblNewLabelRis2().setText(g.getPartite().getPartite().get(1).getRisultato());
		else
			calendarioGUI.getLblNewLabelRis2().setText(" - ");
		
		img = new ImageIcon(g.getPartite().getPartite().get(2).getSquadraCasa().getPathLogo());
		calendarioGUI.getLblNewLabelLogoCasa3().setIcon(img);
		img = new ImageIcon(g.getPartite().getPartite().get(2).getSquadraTrasferta().getPathLogo());
		calendarioGUI.getLblNewLabelLogoTrasferta3().setIcon(img);
		calendarioGUI.getLblNewLabelNomeCasa3().setText(g.getPartite().getPartite().get(2).getSquadraCasa().getNomeSquadra());
		calendarioGUI.getLblNewLabelNomeTrasferta3().setText(g.getPartite().getPartite().get(2).getSquadraTrasferta().getNomeSquadra());
		if(g.getPartite().getPartite().get(1).getRisultato()!=null)
			calendarioGUI.getLblNewLabelRis3().setText(g.getPartite().getPartite().get(2).getRisultato());
		else
			calendarioGUI.getLblNewLabelRis3().setText(" - ");
	}
	
	public static int visualizzaGiornataDaGiocare(HomeGUI homeGUI) {
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream  ois =null;
		Giornate g = null;
		Torneo t = null;
		int numeroGiornata=0;
		try {
			f = new File("src/torneo.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			t=(Torneo) ois.readObject();
			g=t.getGiornate();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura dal file !");
		}
		
		int i=0;
		for(Giornata x : g.getGiornate()) {
			if(x.isGiocata()==false) {
				ImageIcon img = null;
				numeroGiornata=i;
				homeGUI.getLblNewLabelGiornata().setText("Giornata "+(i+1));
				img = new ImageIcon(x.getPartite().getPartite().get(0).getSquadraCasa().getPathLogo());
				homeGUI.getLblNewLabelLogoCasa1().setIcon(img);
				img = new ImageIcon(x.getPartite().getPartite().get(0).getSquadraTrasferta().getPathLogo());
				homeGUI.getLblNewLabelLogoTrasferta1().setIcon(img);
				homeGUI.getLblNewLabelNomeCasa1().setText(x.getPartite().getPartite().get(0).getSquadraCasa().getNomeSquadra());
				homeGUI.getLblNewLabelNomeTrasferta1().setText(x.getPartite().getPartite().get(0).getSquadraTrasferta().getNomeSquadra());
				homeGUI.getLblNewLabelRis1().setText(" - ");
				
				img = new ImageIcon(x.getPartite().getPartite().get(1).getSquadraCasa().getPathLogo());
				homeGUI.getLblNewLabelLogoCasa2().setIcon(img);
				img = new ImageIcon(x.getPartite().getPartite().get(1).getSquadraTrasferta().getPathLogo());
				homeGUI.getLblNewLabelLogoTrasferta2().setIcon(img);
				homeGUI.getLblNewLabelNomeCasa2().setText(x.getPartite().getPartite().get(1).getSquadraCasa().getNomeSquadra());
				homeGUI.getLblNewLabelNomeTrasferta2().setText(x.getPartite().getPartite().get(1).getSquadraTrasferta().getNomeSquadra());
				homeGUI.getLblNewLabelRis2().setText(" - ");
				
				
				img = new ImageIcon(x.getPartite().getPartite().get(2).getSquadraCasa().getPathLogo());
				homeGUI.getLblNewLabelLogoCasa3().setIcon(img);
				img = new ImageIcon(x.getPartite().getPartite().get(2).getSquadraTrasferta().getPathLogo());
				homeGUI.getLblNewLabelLogoTrasferta3().setIcon(img);
				homeGUI.getLblNewLabelNomeCasa3().setText(x.getPartite().getPartite().get(2).getSquadraCasa().getNomeSquadra());
				homeGUI.getLblNewLabelNomeTrasferta3().setText(x.getPartite().getPartite().get(2).getSquadraTrasferta().getNomeSquadra());
				homeGUI.getLblNewLabelRis3().setText(" - ");
				break;
			}
			else
				i++;
		}
		
		return numeroGiornata;
	}
	
	public static void visualizzaResocontoGiornata(ResocontoGiornataGUI homeGUI,int numeroGiornata) {
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream  ois =null;
		Giornata g = null;
		Torneo t = null;
		try {
			f = new File("src/torneo.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			t=(Torneo) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura dal file !");
		}
		
		g=t.getGiornate().getGiornate().get(numeroGiornata);
				ImageIcon img = null;
				img = new ImageIcon(g.getPartite().getPartite().get(0).getSquadraCasa().getPathLogo());
				homeGUI.getLblNewLabelLogoCasa1().setIcon(img);
				img = new ImageIcon(g.getPartite().getPartite().get(0).getSquadraTrasferta().getPathLogo());
				homeGUI.getLblNewLabelLogoTrasferta1().setIcon(img);
				homeGUI.getLblNewLabelNomeCasa1().setText(g.getPartite().getPartite().get(0).getSquadraCasa().getNomeSquadra());
				homeGUI.getLblNewLabelNomeTrasferta1().setText(g.getPartite().getPartite().get(0).getSquadraTrasferta().getNomeSquadra());
				homeGUI.getLblNewLabelRis1().setText(g.getPartite().getPartite().get(0).getRisultato());
				
				img = new ImageIcon(g.getPartite().getPartite().get(1).getSquadraCasa().getPathLogo());
				homeGUI.getLblNewLabelLogoCasa2().setIcon(img);
				img = new ImageIcon(g.getPartite().getPartite().get(1).getSquadraTrasferta().getPathLogo());
				homeGUI.getLblNewLabelLogoTrasferta2().setIcon(img);
				homeGUI.getLblNewLabelNomeCasa2().setText(g.getPartite().getPartite().get(1).getSquadraCasa().getNomeSquadra());
				homeGUI.getLblNewLabelNomeTrasferta2().setText(g.getPartite().getPartite().get(1).getSquadraTrasferta().getNomeSquadra());
				homeGUI.getLblNewLabelRis2().setText(g.getPartite().getPartite().get(1).getRisultato());
				
				
				img = new ImageIcon(g.getPartite().getPartite().get(2).getSquadraCasa().getPathLogo());
				homeGUI.getLblNewLabelLogoCasa3().setIcon(img);
				img = new ImageIcon(g.getPartite().getPartite().get(2).getSquadraTrasferta().getPathLogo());
				homeGUI.getLblNewLabelLogoTrasferta3().setIcon(img);
				homeGUI.getLblNewLabelNomeCasa3().setText(g.getPartite().getPartite().get(2).getSquadraCasa().getNomeSquadra());
				homeGUI.getLblNewLabelNomeTrasferta3().setText(g.getPartite().getPartite().get(2).getSquadraTrasferta().getNomeSquadra());
				homeGUI.getLblNewLabelRis3().setText(g.getPartite().getPartite().get(2).getRisultato());
	}
	
	
	public static boolean  giocaGiornata(Formazione f , int numeroGiornata, Squadra s) throws IOException, ClassNotFoundException {
		File file = new File("src/torneo.dat");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream oos = new ObjectInputStream(fis);
		Torneo t = (Torneo) oos.readObject();
		Giornata g = t.getGiornate().getGiornate().get(numeroGiornata);
		ArrayList<Partita> p = g.getPartite().getPartite();
		Formazione fv=null;
		Partita partita =null;
		int scelta=0;
		for(Partita x : p) {
			if(x.getSquadraCasa().getNomeSquadra().equalsIgnoreCase(s.getNomeSquadra())) {
				x.setFormazioneSquadraCasa(f);
			}
			else {
				scelta = new Random().nextInt(3);
				switch(scelta) {
				case 0 :
					fv = new Formazione442();
					fv=fv.generaFormazioneVirtuale(x.getSquadraCasa());
					break;
					
				case 1 :
					fv = new Formazione343();
					fv=fv.generaFormazioneVirtuale(x.getSquadraCasa());
					break;
					
				case 2 :
					fv = new Formazione352();
					fv=fv.generaFormazioneVirtuale(x.getSquadraCasa());
					break;
					
				case 3 :
					fv = new Formazione433();
					fv=fv.generaFormazioneVirtuale(x.getSquadraCasa());
					break;
				}
				x.setFormazioneSquadraCasa(fv);
			}
			
			if(x.getSquadraTrasferta().getNomeSquadra().equalsIgnoreCase(s.getNomeSquadra())) {
				x.setFormazioneSquadraTrasferta(f);
			}
			
			else {
				scelta = new Random().nextInt(3);
				switch(scelta) {
				case 0 :
					fv = new Formazione442();
					fv=fv.generaFormazioneVirtuale(x.getSquadraTrasferta());
					break;
					
				case 1 :
					fv = new Formazione343();
					fv=fv.generaFormazioneVirtuale(x.getSquadraTrasferta());
					break;
					
				case 2 :
					fv = new Formazione352();
					fv=fv.generaFormazioneVirtuale(x.getSquadraTrasferta());
					break;
					
				case 3 :
					fv = new Formazione433();
					fv=fv.generaFormazioneVirtuale(x.getSquadraTrasferta());
					break;
				}
				x.setFormazioneSquadraTrasferta(fv);
				
			}
			
			Partita.giocaPartita(x, numeroGiornata);
		}
		g.partite.setPartite(p);
		Giornata.salvaGiornata(g,numeroGiornata);
		g.giocata=true;
		return true;
	}
	
	public static void salvaGiornata(Giornata g,int giornata) throws ClassNotFoundException, IOException {
		File f = new File("src/torneo.dat");
		FileInputStream fis;
		Torneo t=null;;
		try {
			fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			t=(Torneo) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Errore nella scrittura su file !");
		}
		
		g.giocata=true;
		t.getGiornate().getGiornate().set(giornata, g);
		File f1 = new File("src/torneo1.dat");
		FileOutputStream fos = new FileOutputStream(f1);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.close();
		fos.close();
		f1.renameTo(f);
	}
	
}
