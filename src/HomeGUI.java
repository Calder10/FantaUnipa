import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;

public class HomeGUI extends JFrame {

	private JPanel contentPane;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public HomeGUI(String username) throws IOException {
		super("Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.username=username;
		
		JLabel lblNewLabel = new JLabel("TORNEO FANTAUNIPA");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(274, 6, 367, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabelLogo = new JLabel();
		
		ClassLoader cl = this.getClass().getClassLoader();
		Squadra squadra = Squadra.getSquadraFromFile(username);
		Path path = Paths.get(squadra.getPathLogo());
		ImageIcon img = new ImageIcon(squadra.getPathLogo());
		lblNewLabelLogo.setIcon(img);
		lblNewLabelLogo.setBounds(23, 44, 69, 67);
		contentPane.add(lblNewLabelLogo);
		
		JLabel lblNewLabelNomeSquadra = new JLabel();
		lblNewLabelNomeSquadra.setText(squadra.getNomeSquadra());
		lblNewLabelNomeSquadra.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabelNomeSquadra.setBounds(90, 63, 203, 33);
		contentPane.add(lblNewLabelNomeSquadra);
		
		JLabel lblNewLabelUsername = new JLabel();
		lblNewLabelUsername.setText("Ciao, "+squadra.getFantallenatore().getUsername());
		lblNewLabelUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelUsername.setBounds(721, 2, 216, 47);
		contentPane.add(lblNewLabelUsername);
		
		JButton btnNewButtonLaMiaRosa = new JButton("La mia rosa");
		btnNewButtonLaMiaRosa.setBounds(23, 148, 128, 47);
		contentPane.add(btnNewButtonLaMiaRosa);
		
		JButton buttonSquadre = new JButton("Squadre");
		buttonSquadre.setBounds(23, 207, 128, 47);
		contentPane.add(buttonSquadre);
		
		JButton buttonCalendario = new JButton("Caldendario");
		buttonCalendario.setBounds(23, 266, 128, 47);
		contentPane.add(buttonCalendario);
		
		JButton buttonClassifics = new JButton("Classifica");
		buttonClassifics.setBounds(23, 325, 128, 47);
		contentPane.add(buttonClassifics);
		
		btnNewButtonLaMiaRosa.addActionListener(
			e-> {
				RosaGUI nextFrame=new RosaGUI(squadra);
				nextFrame.toFront();
				nextFrame.setVisible(true);
			});
		
		buttonSquadre.addActionListener(
				e-> {
					SquadreGUI nextFrame;
					try {
						nextFrame = new SquadreGUI(squadra.getNomeSquadra());
						nextFrame.toFront();
						nextFrame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						System.out.println("Errore !");
					}
				});
	}
}
