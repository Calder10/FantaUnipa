import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class PodioGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodioGUI frame = new PodioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public PodioGUI() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 546);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setFont(new Font("Dialog", Font.BOLD, 20));
		background.setIcon(new ImageIcon(PodioGUI.class.getResource("/Immagini/medaglie.jpg")));
		background.setBounds(30, 5, 600, 454);
		contentPane.add(background);
		
		JLabel label2 = new JLabel("");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Dialog", Font.BOLD, 20));
		label2.setBounds(50, 450, 134, 24);
		contentPane.add(label2);
		
		JLabel label1 = new JLabel("");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Dialog", Font.BOLD, 20));
		label1.setBounds(263, 450, 134, 24);
		contentPane.add(label1);
		
		JLabel label3 = new JLabel("");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Dialog", Font.BOLD, 20));
		label3.setBounds(460, 450, 174, 24);
		contentPane.add(label3);
		
		ArrayList<String> podio=Classifica.returnPodio();
		label1.setText(podio.get(0));
		label2.setText(podio.get(1));
		label3.setText(podio.get(2));
	}
}
