import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Giornata implements Serializable{

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
		Torneo t = null;
		try {
			f = new File("src/torneo.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			t=(Torneo) ois.readObject();
			g=t.getGiornate().getGiornate().get(numeroGiornata-1);
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura dal file !");
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
	
	public static void visualizzaGiornataDaGiocare(HomeGUI homeGUI) {
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream  ois =null;
		Giornate g = null;
		Torneo t = null;
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
	}
	
}
