import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ResocontoVotiGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public ResocontoVotiGUI(int numeroGiornata,int numeroPartita) throws ClassNotFoundException {
		super("Resoconto Voti");
		setResizable(false);
		setBounds(100, 100, 706, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		JTextArea textArea = new JTextArea();
		
		JScrollPane scrollpane = new JScrollPane(textArea);
		scrollpane.setSize(680, 300);
		scrollpane.setEnabled(false);
		scrollpane.setLocation(20, 29);
		contentPane.add(scrollpane);
		*/
		
		Box verticalBoxCasa = Box.createVerticalBox();
		verticalBoxCasa.setBounds(47, 6, 255, 341);
		contentPane.add(verticalBoxCasa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		verticalBoxCasa.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		verticalBoxCasa.add(textArea);
		
		Box verticalBoxTrasferta = Box.createVerticalBox();
		verticalBoxTrasferta.setBounds(407, 6, 255, 341);
		contentPane.add(verticalBoxTrasferta);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		verticalBoxTrasferta.add(label);
		
		JTextArea textArea_1 = new JTextArea();
		verticalBoxTrasferta.add(textArea_1);
	
		
		ArrayList<ArrayList<String>> ris = Partita.returnVotiPartita(numeroGiornata, numeroPartita);
		lblNewLabel.setText(ris.get(0).get(0));
		ris.get(0).remove(0);
		ris.get(1).remove(0);
		
		for(String s : ris.get(0)) {
			textArea.append(s);
			textArea.append("\n");
		}
		
		label.setText(ris.get(1).get(0));
		for(String s : ris.get(1)) {
			textArea_1.append(s);
			textArea_1.append("\n");
		}
		
	}
}
