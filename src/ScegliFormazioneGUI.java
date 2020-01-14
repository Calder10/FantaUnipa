import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;

public class ScegliFormazioneGUI extends JFrame {

	private JPanel contentPane;


	/**
	 * 
	 */
	public ScegliFormazioneGUI(String username,Squadra squadra,int numeroGiornata) {
		super("Schiera Formazione");
		setResizable(false);
		setBounds(100, 100, 483, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = new ImageIcon("src/Immagini/campo.jpg");
		JLabel labelBackgroung = new JLabel(img);
		labelBackgroung.setLocation(6, 0);
		labelBackgroung.setSize(610, 609);
		
		String [] moduli = {"4-4-2","3-4-3","4-3-3","3-5-2"};
		
		JLabel lblNewLabel = new JLabel("Scegli il modulo");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(71, 22, 222, 35);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxModuli = new JComboBox(moduli);
		comboBoxModuli.setSelectedIndex(3);
		comboBoxModuli.setBounds(311, 20, 141, 47);
		contentPane.add(comboBoxModuli);
		
		
        JButton btnNewButtonIndietro= new JButton(new ImageIcon(ScegliFormazioneGUI.class.getResource("/Immagini/ic_arrow_back_128_28226.png")));
        btnNewButtonIndietro.setBackground(Color.WHITE);
        btnNewButtonIndietro.setBorder(null);
        btnNewButtonIndietro.setContentAreaFilled(false);
        btnNewButtonIndietro.setBounds(12, 0, 57, 47);
        contentPane.add(btnNewButtonIndietro);
		
		comboBoxModuli.addActionListener(
				l->{
					switch(comboBoxModuli.getSelectedItem().toString()) {
					case "4-4-2":
						GUI442 nextFrame;
						try {
							nextFrame = new GUI442(username,squadra,numeroGiornata);
							nextFrame.toFront();
							nextFrame.setVisible(true);
							this.dispose();
							break;
						} catch (IOException e) {
							e.printStackTrace();
						}
					case "3-4-3":
						GUI343 nextFrame1 = new GUI343(username,squadra,numeroGiornata);
						nextFrame1.toFront();
						nextFrame1.setVisible(true);
						this.dispose();
						break;
					case "4-3-3":
						GUI433 nextFrame2 = new GUI433(username,squadra,numeroGiornata);
						nextFrame2.toFront();
						nextFrame2.setVisible(true);
						this.dispose();
						break;
					case "3-5-2":
						GUI352 nextFrame3 = new GUI352(username,squadra,numeroGiornata);
						nextFrame3.toFront();
						nextFrame3.setVisible(true);
						this.dispose();
						break;
					default: System.out.println("Scelta non consentita\n");
					}
				});
		
		btnNewButtonIndietro.addActionListener(
				e->{
					try {
						HomeGUI backFrame = new HomeGUI(username);
						backFrame.toFront();
						backFrame.setVisible(true);
						this.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
	}
}

