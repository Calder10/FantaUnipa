import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class GUI442 extends JFrame {

	private JPanel contentPane;
	
	public String [] updateListaPortieri(ArrayList<String> p,int i) {
		p.remove(i);
		String ris [] = new String [p.size()];
		ris = p.toArray(ris);
		return ris;
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUI442(String username) throws IOException {
		super("Inserimento formazione");
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(GUI442.class.getResource("/Immagini/campo.png")));
		background.setBounds(6, 6, 800, 600);
		contentPane.add(background);
		
		Squadra s = Squadra.getSquadraFromFile(username);
		ArrayList<String> portieri= new ArrayList<>();
		portieri.add("");
		for(Portiere p : s.getPortieri()) {
			portieri.add(p.getNomeGiocatore());
		}
		String [] listaPortieri = new String [4];
		listaPortieri = portieri.toArray(listaPortieri);
		JComboBox portiere = new JComboBox(listaPortieri);
		portiere.setBackground(Color.WHITE);
		portiere.setBounds(305, 26, 199, 27);
		background.add(portiere);
		
		ArrayList<String> difensori= new ArrayList<>();
		difensori.add("");
		for(Difensore d : s.getDifensori()) {
			difensori.add(d.getNomeGiocatore());
		}
		String [] listaDifensori = new String [9];
		listaDifensori = difensori.toArray(listaDifensori);
		JComboBox difensore1 = new JComboBox(listaDifensori);
		difensore1.setBackground(Color.WHITE);
		difensore1.setBounds(32, 199, 199, 27);
		background.add(difensore1);
		
		JComboBox difensore2 = new JComboBox(listaDifensori);
		difensore2.setBackground(Color.WHITE);
		difensore2.setBounds(192, 113, 199, 27);
		background.add(difensore2);
		
		JComboBox difensore4 = new JComboBox(listaDifensori);
		difensore4.setBackground(Color.WHITE);
		difensore4.setBounds(596, 199, 199, 27);
		background.add(difensore4);
		
		JComboBox difensore3 = new JComboBox(listaDifensori);
		difensore3.setBackground(Color.WHITE);
		difensore3.setBounds(415, 113, 199, 27);
		background.add(difensore3);
		
		ArrayList<String> centrocampisti= new ArrayList<>();
		centrocampisti.add("");
		for(Centrocampista c : s.getCentrocampisti()) {
			centrocampisti.add(c.getNomeGiocatore());
		}
		String []listaCentrocampisti = new String [9];
		listaCentrocampisti = centrocampisti.toArray(listaCentrocampisti);
		
		JComboBox centrocampista1 = new JComboBox(listaCentrocampisti);
		centrocampista1.setBackground(Color.WHITE);
		centrocampista1.setBounds(192, 295, 199, 27);
		background.add(centrocampista1);
		
		JComboBox centrocampista2 = new JComboBox(listaCentrocampisti);
		centrocampista2.setBackground(Color.WHITE);
		centrocampista2.setBounds(415, 295, 199, 27);
		background.add(centrocampista2);
		
		JComboBox centrocampista3 = new JComboBox(listaCentrocampisti);
		centrocampista3.setBackground(Color.WHITE);
		centrocampista3.setBounds(32, 358, 199, 27);
		background.add(centrocampista3);
		
		JComboBox centrocampista4 = new JComboBox(listaCentrocampisti);
		centrocampista4.setBackground(Color.WHITE);
		centrocampista4.setBounds(582, 358, 199, 27);
		background.add(centrocampista4);
		
		
		ArrayList<String> attaccanti= new ArrayList<>();
		attaccanti.add("");
		for(Attaccante a  : s.getAttaccanti()) {
			attaccanti.add(a.getNomeGiocatore());
		}
		
		String []listaAttaccanti = new String [4];
		listaAttaccanti = attaccanti.toArray(listaAttaccanti);
		
		
		JComboBox attaccante1 = new JComboBox(listaAttaccanti);
		attaccante1.setBackground(Color.WHITE);
		attaccante1.setBounds(192, 471, 199, 27);
		background.add(attaccante1);
		
		JComboBox attaccante2 = new JComboBox(listaAttaccanti);
		attaccante2.setBackground(Color.WHITE);
		attaccante2.setBounds(427, 471, 199, 27);
		background.add(attaccante2);
		
		JButton btnNewButtonConferma = new JButton("CONFERMA");
		btnNewButtonConferma.setBounds(641, 607, 164, 52);
		contentPane.add(btnNewButtonConferma);

		btnNewButtonConferma.addActionListener(
				e->{
					String p = portiere.getSelectedItem().toString();
					ArrayList<String> d = new ArrayList<>();
					 d.add(difensore1.getSelectedItem().toString());
					 d.add(difensore2.getSelectedItem().toString());
					 d.add(difensore3.getSelectedItem().toString());
					 d.add(difensore4.getSelectedItem().toString());
					 
					 ArrayList<String> c = new ArrayList<>();
					 c.add(centrocampista1.getSelectedItem().toString());
					 c.add(centrocampista2.getSelectedItem().toString());
					 c.add(centrocampista3.getSelectedItem().toString());
					 c.add(centrocampista4.getSelectedItem().toString());
					 
					 ArrayList<String> a = new ArrayList<>();
					 a.add(attaccante1.getSelectedItem().toString());
					 a.add(attaccante2.getSelectedItem().toString());
					 
					 boolean ris = Formazione.checkFormazione(p, d, c ,a);
					 
					 if (ris==false) {
						 JOptionPane.showMessageDialog(btnNewButtonConferma, "Errore ! Hai inserito lo stesso giocatore più di una volta");
					 }
					 else {
						 portieri.remove(portiere.getSelectedIndex()+1);
						 difensori.remove(difensore1.getSelectedIndex()+1);
						 difensori.remove(difensore2.getSelectedIndex()+1);
						 difensori.remove(difensore3.getSelectedIndex()+1);
						 difensori.remove(difensore4.getSelectedIndex()+1);
						 centrocampisti.remove(centrocampista1.getSelectedIndex()+1);
						 centrocampisti.remove(centrocampista2.getSelectedIndex()+1);
						 centrocampisti.remove(centrocampista3.getSelectedIndex()+1);
						 centrocampisti.remove(centrocampista4.getSelectedIndex()+1);
						 attaccanti.remove(attaccante1.getSelectedIndex()+1);
						 attaccanti.remove(attaccante2.getSelectedIndex()+1);
					 }
				});
		
	
		
	}
}
