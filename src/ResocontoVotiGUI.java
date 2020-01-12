import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.*;  
 


public class ResocontoVotiGUI extends JFrame{

	private JPanel contentPane;
	private String username;
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public ResocontoVotiGUI(int numeroGiornata,int numeroPartita,String username) throws ClassNotFoundException {
		super("Resoconto Voti");
		this.username=username;
		setResizable(false);
		setBounds(100, 100, 706, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	     this.addWindowListener(new WindowAdapter(){  
	            public void windowClosing(WindowEvent e) {
	            	HomeGUI nextFrame;
					try {
						nextFrame = new HomeGUI(username);
						nextFrame.toFront(); 
		    			nextFrame.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	            }  
	        });   
		
		
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
		
		
		for(String s : ris.get(0)) {
			textArea.append(s);
			textArea.append("\n");
		}
		
		label.setText(ris.get(1).get(0));
		ris.get(1).remove(0);
		for(String s : ris.get(1)) {
			textArea_1.append(s);
			textArea_1.append("\n");
		}
		
		
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
