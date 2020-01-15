import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;


/**
 * GUI per la gestione dell'asta di un determinato giocatore
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 * 
 */
public class AstaGiocatoreGUI extends JFrame {

	protected JPanel contentPane;
	protected JTextField textField;
	protected String username;
	protected JScrollPane scrollpane;
	protected JTextArea textArea;
	protected JButton btnNewButtonRinuncia;
	protected int tipo;
	
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AstaGiocatoreGUI getAstaGiocatoreGUI() {
		return this;
	}

	public AstaGiocatoreGUI(AstaGUI astaGUI, String username, String ris,int tipo)
			throws ClassNotFoundException, IOException {
		super("Asta in corso");
		this.setUsername(username);
		this.setTipo(tipo);
		setResizable(false);
		setBounds(100, 100, 615, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Asta in corso per " + ris);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(167, 32, 350, 39);
		contentPane.add(lblNewLabel);


		textField = new JTextField();
		textField.setBounds(205, 83, 98, 44);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Punta");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(328, 83, 98, 44);
		contentPane.add(btnNewButton);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 135, 552, 123);
		contentPane.add(textArea);
		//getContentPane().add(textArea);

		scrollpane = new JScrollPane(textArea);
		scrollpane.setEnabled(false);
		scrollpane.setLocation(20, 139);
		scrollpane.setSize(581, 121);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(200, 250));

		contentPane.add(scrollpane);
		
		String fantacrediti= Registrazione.getFantaCreditiFromCsv(username);
		JLabel lblFantacreditiRimanenti = new JLabel("Fantacrediti rimanenti: " + fantacrediti);
		lblFantacreditiRimanenti.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblFantacreditiRimanenti.setBounds(30, 272, 432, 34);
		contentPane.add(lblFantacreditiRimanenti);

		JButton btnNewButtonRinuncia = new JButton("Rinuncia");
		btnNewButtonRinuncia.setBounds(480, 273, 98, 44);
		contentPane.add(btnNewButtonRinuncia);

		textArea.setVisible(false);
		btnNewButtonRinuncia.setVisible(false);
		Giocatore g = null;
		switch(this.tipo) {
		case 0:
			g = (Portiere) new Portiere(ris);
			break;
		
		case 1:
			g = (Difensore) new Difensore(ris);
			break;
			
		case 2:
			g = (Centrocampista) new Centrocampista(ris);
			break;
		
		case 3: 
			g = (Attaccante) new Attaccante(ris);
			break;
		}
		Asta a = new Asta(g, tipo);
		ConcreteObserverAsta o = a.getObs().get(0);
		int fantaCrediti = o.getSquadra().getFantallenatore().getFantaCrediti();
		
	
		btnNewButton.addActionListener(
				e->{
					textArea.setText("");
					int p=0;
					try {
						p = Integer.parseInt(textField.getText());
					}
					catch (NumberFormatException c) {
						System.out.println("Errore !");
					}
					if(p==0) {
						JOptionPane.showMessageDialog(textField, "Caratteri non ammessi !");
						textField.setText("");
					}
					if (p > fantaCrediti) {
						JOptionPane.showMessageDialog(textField, "Non hai abbastanza FantaCrediti !");
						textField.setText("");
					}
					if(textField.getText()=="") {
						JOptionPane.showMessageDialog(textField, "Inserisci la puntata !");
						textField.setText("");
					}
					a.eseguiAsta(astaGUI, getAstaGiocatoreGUI(), textField, getUsername(), textArea,
							btnNewButtonRinuncia);
				
			});

		
		btnNewButtonRinuncia.addActionListener(
				e->{
				try {
					a.simulaRinuncia(getUsername(), getAstaGiocatoreGUI());
				} catch (IOException e1) {

					e1.printStackTrace();
				}
		});

	}
}
