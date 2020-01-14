	import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class GUI352 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI352(String username,Squadra s,int numeroGiornata) {
		super("Inserimento formazione");
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
	
		setBounds(100, 100, 811, 814);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(GUI442.class.getResource("/Immagini/campo.png")));
		background.setBounds(6, 6, 800, 600);
		contentPane.add(background);
		
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
		difensore1.setBounds(32, 120, 199, 27);
		background.add(difensore1);
		
		JComboBox difensore2 = new JComboBox(listaDifensori);
		difensore2.setBackground(Color.WHITE);
		difensore2.setBounds(319, 120, 199, 27);
		background.add(difensore2);
		
		JComboBox difensore3 = new JComboBox(listaDifensori);
		difensore3.setBackground(Color.WHITE);
		difensore3.setBounds(584, 120, 199, 27);
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
		centrocampista1.setBounds(38, 370, 199, 27);
		background.add(centrocampista1);
		
		JComboBox centrocampista5 = new JComboBox(listaCentrocampisti);
		centrocampista5.setBackground(Color.WHITE);
		centrocampista5.setBounds(585, 370, 199, 27);
		background.add(centrocampista5);
		
		JComboBox centrocampista2 = new JComboBox(listaCentrocampisti);
		centrocampista2.setBackground(Color.WHITE);
		centrocampista2.setBounds(176, 279, 199, 27);
		background.add(centrocampista2);
		
		JComboBox centrocampista4 = new JComboBox(listaCentrocampisti);
		centrocampista4.setBackground(Color.WHITE);
		centrocampista4.setBounds(442, 279, 199, 27);
		background.add(centrocampista4);
		
		JComboBox centrocampista3 = new JComboBox(listaCentrocampisti);
		centrocampista3.setBackground(Color.WHITE);
		centrocampista3.setBounds(306, 339, 199, 27);
		background.add(centrocampista3);
		
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
		btnNewButtonConferma.setBounds(647, 688, 164, 52);
		contentPane.add(btnNewButtonConferma);
		
		JLabel lblNewLabel = new JLabel("Seleziona le riserve");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(16, 618, 212, 37);
		contentPane.add(lblNewLabel);
		
		JComboBox portiereRiserva = new JComboBox(listaPortieri);
		portiereRiserva.setBackground(Color.WHITE);
		portiereRiserva.setBounds(6, 681, 144, 27);
		contentPane.add(portiereRiserva);
		
		JComboBox difensoreRiserva1 = new JComboBox(listaDifensori);
		difensoreRiserva1.setBackground(Color.WHITE);
		difensoreRiserva1.setBounds(162, 681, 144, 27);
		contentPane.add(difensoreRiserva1);
		
		JComboBox difensoreRiserva2 = new JComboBox(listaDifensori);
		difensoreRiserva2.setBackground(Color.WHITE);
		difensoreRiserva2.setBounds(162, 740, 144, 27);
		contentPane.add(difensoreRiserva2);
		
		JComboBox centrocampistaRiserva1 = new JComboBox(listaCentrocampisti);
		centrocampistaRiserva1.setBackground(Color.WHITE);
		centrocampistaRiserva1.setBounds(331, 681, 144, 27);
		contentPane.add(centrocampistaRiserva1);
		
		JLabel lblNewLabel_1 = new JLabel("Portiere");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(49, 656, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDi = new JLabel("Difensori");
		lblDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDi.setBounds(199, 656, 71, 16);
		contentPane.add(lblDi);
		
		JLabel lblCentrocampisti = new JLabel("Centrocampisti");
		lblCentrocampisti.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentrocampisti.setBounds(349, 656, 115, 16);
		contentPane.add(lblCentrocampisti);
		
		JComboBox centrocampistaRiserva2 = new JComboBox(listaCentrocampisti);
		centrocampistaRiserva2.setBackground(Color.WHITE);
		centrocampistaRiserva2.setBounds(331, 740, 144, 27);
		contentPane.add(centrocampistaRiserva2);
		
		JComboBox attaccanteRiserva1 = new JComboBox(listaAttaccanti);
		attaccanteRiserva1.setBackground(Color.WHITE);
		attaccanteRiserva1.setBounds(487, 681, 144, 27);
		contentPane.add(attaccanteRiserva1);
		
		JComboBox attaccanteRiserva2 = new JComboBox(listaAttaccanti);
		attaccanteRiserva2.setBackground(Color.WHITE);
		attaccanteRiserva2.setBounds(487, 740, 144, 27);
		contentPane.add(attaccanteRiserva2);
		
		JLabel lblAttaccanti = new JLabel("Attaccanti");
		lblAttaccanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttaccanti.setBounds(501, 656, 115, 16);
		contentPane.add(lblAttaccanti);

		btnNewButtonConferma.addActionListener(
				e->{
					
					ArrayList<String> p = new ArrayList<>();
					p.add(portiere.getSelectedItem().toString());
					p.add(portiereRiserva.getSelectedItem().toString());
					ArrayList<String> d = new ArrayList<>();
					 d.add(difensore1.getSelectedItem().toString());
					 d.add(difensore2.getSelectedItem().toString());
					 d.add(difensore3.getSelectedItem().toString());
					 d.add(difensoreRiserva1.getSelectedItem().toString());
					 d.add(difensoreRiserva2.getSelectedItem().toString());
					 
					 ArrayList<String> c = new ArrayList<>();
					 c.add(centrocampista1.getSelectedItem().toString());
					 c.add(centrocampista2.getSelectedItem().toString());
					 c.add(centrocampista3.getSelectedItem().toString());
					 c.add(centrocampista4.getSelectedItem().toString());
					 c.add(centrocampista5.getSelectedItem().toString());
					 c.add(centrocampistaRiserva1.getSelectedItem().toString());
					 c.add(centrocampistaRiserva2.getSelectedItem().toString());
					 
					 
					 ArrayList<String> a = new ArrayList<>();
					 a.add(attaccante1.getSelectedItem().toString());
					 a.add(attaccante2.getSelectedItem().toString());
					 a.add(attaccanteRiserva1.getSelectedItem().toString());
					 a.add(attaccanteRiserva2.getSelectedItem().toString());
					 
					 
					 
					 
					 boolean ris = Formazione352.checkFormazione(p, d, c ,a);
					 
					 if (ris==false) {
						 JOptionPane.showMessageDialog(btnNewButtonConferma, "Errore ! Hai inserito lo stesso giocatore più di una volta");
					 }
					 else {
						 FormazioneFactory factory = new FormazioneFactory();
						 Formazione f = factory.getFormazione(TipoFormazione.F352,p,d,c,a,s);
						 try {
							boolean ris1 = Giornata.giocaGiornata(f, numeroGiornata, s);
							if(ris1==true) {
								ResocontoGiornataGUI nextFrame = new ResocontoGiornataGUI(numeroGiornata,username);
								nextFrame.toFront();
								nextFrame.setVisible(true);
								this.dispose();
							}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 }
				});
		
	}
}
