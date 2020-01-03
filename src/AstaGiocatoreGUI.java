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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AstaGiocatoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String username;
	private JScrollPane scrollpane;
	private JTextArea textArea;
	private JButton btnNewButtonRinuncia;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public AstaGiocatoreGUI getAstaGiocatoreGUI() {
		return this;
	}
	
	
	
	public AstaGiocatoreGUI(AstaPortieriGUI astaPortieriGUI,String username, String ris) throws ClassNotFoundException, IOException {
		super("Asta in corso");
		this.setUsername(username);
		setResizable(false);
		setBounds(100, 100, 615, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Asta in corso per " + ris);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(167, 32, 281, 39);
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
		getContentPane().add(textArea);

		scrollpane = new JScrollPane(textArea);
		scrollpane.setEnabled(false);
		scrollpane.setLocation(28, 139);
		scrollpane.setSize(558, 121);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(200, 250));

		contentPane.add(scrollpane);

		JButton btnNewButtonRinuncia = new JButton("Rinuncia");
		btnNewButtonRinuncia.setBounds(480, 273, 98, 44);
		contentPane.add(btnNewButtonRinuncia);

		textArea.setVisible(false);
		btnNewButtonRinuncia.setVisible(false);
		Giocatore g = (Portiere) new Portiere(ris);
		Asta a = new Asta(g,0);
		ConcreteObserverAsta o = a.getObs().get(0);
		int fantaCrediti = o.getSquadra().getFantallenatore().getFantaCrediti();
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int p = Integer.parseInt(textField.getText());
				if(p>fantaCrediti) {
					JOptionPane.showMessageDialog(textField, "Non hai abbastanza FantaCrediti !");
					textField.setText("");
				}
				a.simulaAsta(astaPortieriGUI,getAstaGiocatoreGUI(),textField,getUsername(), textArea, btnNewButtonRinuncia);
			}
		});
		
		btnNewButtonRinuncia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				a.simulaRinuncia(getUsername(),getAstaGiocatoreGUI());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}); 
			
	} 
}
