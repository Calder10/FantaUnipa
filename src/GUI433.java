	import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

/**
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class GUI433 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI433() {
		super("Inserimento formazione");
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(GUI433.class.getResource("/Immagini/campo.jpg")));
		background.setBounds(6, 6, 800, 600);
		contentPane.add(background);
		String [] moduli = {"4-4-2","3-4-3","4-3-3","3-5-2"};
		JComboBox portiere = new JComboBox(moduli);
		portiere.setBackground(Color.WHITE);
		portiere.setBounds(305, 26, 199, 27);
		background.add(portiere);
		
		JComboBox difensore1 = new JComboBox();
		difensore1.setBackground(Color.WHITE);
		difensore1.setBounds(32, 199, 199, 27);
		background.add(difensore1);
		
		JComboBox difensore2 = new JComboBox();
		difensore2.setBackground(Color.WHITE);
		difensore2.setBounds(192, 113, 199, 27);
		background.add(difensore2);
		
		JComboBox difensore4 = new JComboBox();
		difensore4.setBackground(Color.WHITE);
		difensore4.setBounds(596, 199, 199, 27);
		background.add(difensore4);
		
		JComboBox difensore3 = new JComboBox();
		difensore3.setBackground(Color.WHITE);
		difensore3.setBounds(415, 113, 199, 27);
		background.add(difensore3);
		
		JComboBox centrocampista1 = new JComboBox();
		centrocampista1.setBounds(64, 282, 199, 27);
		background.add(centrocampista1);
		
		JComboBox centrocampista2 = new JComboBox();
		centrocampista2.setBounds(309, 283, 199, 27);
		background.add(centrocampista2);
		
		JComboBox centrocampista3 = new JComboBox();
		centrocampista3.setBounds(535, 283, 199, 27);
		background.add(centrocampista3);
		
		JComboBox attaccante1 = new JComboBox();
		attaccante1.setBounds(64, 470, 199, 27);
		background.add(attaccante1);
		
		JComboBox attaccante2 = new JComboBox();
		attaccante2.setBounds(309, 470, 199, 27);
		background.add(attaccante2);
		
		JComboBox attaccante3 = new JComboBox();
		attaccante3.setBounds(535, 471, 199, 27);
		background.add(attaccante3);
		
	}
}
