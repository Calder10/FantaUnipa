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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AstaGiocatoreGUI(String username, String ris) throws ClassNotFoundException, IOException {
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
		int o1 = 3, o2 = 3, o3 = 3, o4 = 3, o5 = 3, o6 = 3;
		Giocatore g = (Portiere) new Portiere(ris);
		Asta a = new Asta(g);
		ConcreteObserverAsta o = a.getObs().get(0);
		while (true) {
			if (o.getSquadra().getPortieri().size()>0) {
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int puntata = Integer.parseInt(textField.getText());
						try {
							boolean ris = o.punta(getUsername(), puntata);
							if (ris == true) {
								HashMap<String, Integer> aus = a.getPuntataCorrente();
								Integer oldValue = aus.get(username);
								aus.replace(username, oldValue, puntata);
								a.setPuntataCorrente(aus);
								a.notifyAllObserver(username, puntata);
								a.puntateVirtuali(username, textArea, btnNewButtonRinuncia);
								int dim = a.getPuntataCorrente().size();
								if (dim == 1) {
									String key = "";
									int value = 0;
									System.out.println(ris + " aggiudicato");
									Set<String> keys = a.getPuntataCorrente().keySet();
									for (String s : keys) {
										key = s;
										value = a.getPuntataCorrente().get(s);
									}

									ArrayList<ConcreteObserverAsta> oss = a.getObs();
									for (ConcreteObserverAsta o : oss) {
										if (key.equalsIgnoreCase(o.getSquadra().getFantallenatore().getUsername())) {
											o.getSquadra().getFantallenatore().setFantaCrediti(value);
											o.getSquadra().getPortieri().add((Portiere) g);
											// implementare un metodo per salvare il giocatore su file .dat
										}
									}
								}
							} else {
								JOptionPane.showMessageDialog(textField, "Puntata non consentita!");
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					}
				});

				btnNewButtonRinuncia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						o.passa(username);
						a.notifyAllObserver(username, 0);
					}
				});
			} else {
				a.getObs().remove(o);
			}
			
			if(a.getObs().size()==0)
				break;
		}
	}
}
