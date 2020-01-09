import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import java.awt.Font;
import javax.swing.JComboBox;

public class FormazioneGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormazioneGUI frame = new FormazioneGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 */
	public FormazioneGUI() {
		super("Schera Formazione");
		setResizable(false);
		setBounds(100, 100, 622, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = new ImageIcon("src/Immagini/campo.jpg");
		JLabel labelBackgroung = new JLabel(img);
		labelBackgroung.setLocation(6, 6);
		labelBackgroung.setSize(610, 609);
		contentPane.add(labelBackgroung);
		
		String [] moduli = {"4-4-2","3-4-3","4-3-3","3-5-2"};
		
		JLabel lblNewLabel = new JLabel("Scegli il modulo");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(268, 633, 222, 35);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxPortiere = new JComboBox();
		comboBoxPortiere.setBounds(200, 17, 222, 27);
		contentPane.add(comboBoxPortiere);
		
		JComboBox comboBoxModuli = new JComboBox(moduli);
		comboBoxModuli.setSelectedIndex(3);
		comboBoxModuli.setBounds(475, 627, 141, 47);
		contentPane.add(comboBoxModuli);
		
		
	}
}
