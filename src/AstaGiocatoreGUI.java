import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AstaGiocatoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String username;
	private JTextField textField_1;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public AstaGiocatoreGUI(String username,String ris) throws ClassNotFoundException, IOException {
		super("Asta in corso");
		this.setUsername(username);
		setResizable(false);
		setBounds(100, 100, 615, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asta in corso per "+ ris);
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(354, 272, 98, 44);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButtonRilancia = new JButton("Rilancia");
		btnNewButtonRilancia.setBounds(480, 273, 98, 44);
		contentPane.add(btnNewButtonRilancia);
		
		textArea.setVisible(false);
		textField_1.setVisible(false);
		btnNewButtonRilancia.setVisible(false);
		
		Giocatore g = (Portiere) new Portiere(ris);
		Asta a = new Asta(g);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int puntata=Integer.parseInt(textField.getText());
				try {
					ConcreteObserverAsta o = a.getObs().get(0);
					boolean ris=o.punta(getUsername(), puntata);
					if(ris==true) {
						HashMap<String,Integer> aus = a.getPuntataCorrente();
						Integer oldValue = aus.get(username);
						aus.replace(username, oldValue, puntata);
						a.setPuntataCorrente(aus);
						a.notifyAllObserver(username,puntata);
						a.puntateVirtuali(username,textArea,textField_1,btnNewButtonRilancia);
					}
					else {
						JOptionPane.showMessageDialog(textField, "Puntata non consentita!");
					}
					// Fantallenatori virtuali 
					System.out.println(a.getObs().toString());
					//textArea.setVisible(true);
					//textArea.append(a.stampaPuntata(username));
					//textField_1.setVisible(true);
					//btnNewButtonRilancia.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
