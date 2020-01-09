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
	private JPanel panel;
	private JLabel lblNewLabelGiornata;
	private JLabel lblNewLabelLogoCasa1;
	private JLabel lblNewLabelLogoCasa2;
	private JLabel lblNewLabelLogoCasa3;
	private JLabel lblNewLabelLogoTrasferta1;
	private JLabel lblNewLabelLogoTrasferta2;
	private JLabel lblNewLabelLogoTrasferta3;
	private JLabel lblNewLabelNomeCasa1;
	private JLabel lblNewLabelNomeCasa2;
	private JLabel lblNewLabelNomeCasa3;
	private JLabel lblNewLabelNomeTrasferta1;
	private JLabel lblNewLabelNomeTrasferta2;
	private JLabel lblNewLabelNomeTrasferta3;
	private JLabel lblNewLabelRis1;
	private JLabel lblNewLabelRis2;
	private JLabel lblNewLabelRis3;

	
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getLblNewLabelGiornata() {
		return lblNewLabelGiornata;
	}

	public void setLblNewLabelGiornata(JLabel lblNewLabelGiornata) {
		this.lblNewLabelGiornata = lblNewLabelGiornata;
	}

	public JLabel getLblNewLabelLogoCasa1() {
		return lblNewLabelLogoCasa1;
	}

	public void setLblNewLabelLogoCasa1(JLabel lblNewLabelLogoCasa1) {
		this.lblNewLabelLogoCasa1 = lblNewLabelLogoCasa1;
	}

	public JLabel getLblNewLabelLogoCasa2() {
		return lblNewLabelLogoCasa2;
	}

	public void setLblNewLabelLogoCasa2(JLabel lblNewLabelLogoCasa2) {
		this.lblNewLabelLogoCasa2 = lblNewLabelLogoCasa2;
	}

	public JLabel getLblNewLabelLogoCasa3() {
		return lblNewLabelLogoCasa3;
	}

	public void setLblNewLabelLogoCasa3(JLabel lblNewLabelLogoCasa3) {
		this.lblNewLabelLogoCasa3 = lblNewLabelLogoCasa3;
	}

	public JLabel getLblNewLabelLogoTrasferta1() {
		return lblNewLabelLogoTrasferta1;
	}

	public void setLblNewLabelLogoTrasferta1(JLabel lblNewLabelLogoTrasferta1) {
		this.lblNewLabelLogoTrasferta1 = lblNewLabelLogoTrasferta1;
	}

	public JLabel getLblNewLabelLogoTrasferta2() {
		return lblNewLabelLogoTrasferta2;
	}

	public void setLblNewLabelLogoTrasferta2(JLabel lblNewLabelLogoTrasferta2) {
		this.lblNewLabelLogoTrasferta2 = lblNewLabelLogoTrasferta2;
	}

	public JLabel getLblNewLabelLogoTrasferta3() {
		return lblNewLabelLogoTrasferta3;
	}

	public void setLblNewLabelLogoTrasferta3(JLabel lblNewLabelLogoTrasferta3) {
		this.lblNewLabelLogoTrasferta3 = lblNewLabelLogoTrasferta3;
	}

	public JLabel getLblNewLabelNomeCasa1() {
		return lblNewLabelNomeCasa1;
	}

	public void setLblNewLabelNomeCasa1(JLabel lblNewLabelNomeCasa1) {
		this.lblNewLabelNomeCasa1 = lblNewLabelNomeCasa1;
	}

	public JLabel getLblNewLabelNomeCasa2() {
		return lblNewLabelNomeCasa2;
	}

	public void setLblNewLabelNomeCasa2(JLabel lblNewLabelNomeCasa2) {
		this.lblNewLabelNomeCasa2 = lblNewLabelNomeCasa2;
	}

	public JLabel getLblNewLabelNomeCasa3() {
		return lblNewLabelNomeCasa3;
	}

	public void setLblNewLabelNomeCasa3(JLabel lblNewLabelNomeCasa3) {
		this.lblNewLabelNomeCasa3 = lblNewLabelNomeCasa3;
	}

	public JLabel getLblNewLabelNomeTrasferta1() {
		return lblNewLabelNomeTrasferta1;
	}

	public void setLblNewLabelNomeTrasferta1(JLabel lblNewLabelNomeTrasferta1) {
		this.lblNewLabelNomeTrasferta1 = lblNewLabelNomeTrasferta1;
	}

	public JLabel getLblNewLabelNomeTrasferta2() {
		return lblNewLabelNomeTrasferta2;
	}

	public void setLblNewLabelNomeTrasferta2(JLabel lblNewLabelNomeTrasferta2) {
		this.lblNewLabelNomeTrasferta2 = lblNewLabelNomeTrasferta2;
	}

	public JLabel getLblNewLabelNomeTrasferta3() {
		return lblNewLabelNomeTrasferta3;
	}

	public void setLblNewLabelNomeTrasferta3(JLabel lblNewLabelNomeTrasferta3) {
		this.lblNewLabelNomeTrasferta3 = lblNewLabelNomeTrasferta3;
	}

	public JLabel getLblNewLabelRis1() {
		return lblNewLabelRis1;
	}

	public void setLblNewLabelRis1(JLabel lblNewLabelRis1) {
		this.lblNewLabelRis1 = lblNewLabelRis1;
	}

	public JLabel getLblNewLabelRis2() {
		return lblNewLabelRis2;
	}

	public void setLblNewLabelRis2(JLabel lblNewLabelRis2) {
		this.lblNewLabelRis2 = lblNewLabelRis2;
	}

	public JLabel getLblNewLabelRis3() {
		return lblNewLabelRis3;
	}

	public void setLblNewLabelRis3(JLabel lblNewLabelRis3) {
		this.lblNewLabelRis3 = lblNewLabelRis3;
	}

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
		setBounds(100, 100, 919, 488);
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
		lblNewLabelLogo.setBounds(22, 27, 69, 67);
		contentPane.add(lblNewLabelLogo);
		
		JLabel lblNewLabelNomeSquadra = new JLabel();
		lblNewLabelNomeSquadra.setText(squadra.getNomeSquadra());
		lblNewLabelNomeSquadra.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabelNomeSquadra.setBounds(97, 40, 203, 33);
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
		
		JButton buttonClassifica = new JButton("Classifica");
		buttonClassifica.setBounds(23, 325, 128, 47);
		contentPane.add(buttonClassifica);
		
		JButton btnNewButtonSchieraFormazione = new JButton("Schiera Formazione");
		btnNewButtonSchieraFormazione.setBounds(715, 402, 178, 47);
		contentPane.add(btnNewButtonSchieraFormazione);
		
		panel = new JPanel();
		panel.setBounds(180, 85, 713, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabelGiornata = new JLabel("");
		lblNewLabelGiornata.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelGiornata.setBounds(280, 6, 152, 25);
		panel.add(lblNewLabelGiornata);
		
		lblNewLabelLogoCasa1 = new JLabel();
		lblNewLabelLogoCasa1.setBounds(6, 55, 69, 67);
		panel.add(lblNewLabelLogoCasa1);
		
		lblNewLabelLogoCasa2 = new JLabel();
		lblNewLabelLogoCasa2.setBounds(6, 131, 69, 67);
		panel.add(lblNewLabelLogoCasa2);
		
		lblNewLabelLogoCasa3 = new JLabel();
		lblNewLabelLogoCasa3.setBounds(6, 209, 69, 67);
		panel.add(lblNewLabelLogoCasa3);
		
		lblNewLabelLogoTrasferta1 = new JLabel();
		lblNewLabelLogoTrasferta1.setBounds(530, 55, 69, 67);
		panel.add(lblNewLabelLogoTrasferta1);
		
		lblNewLabelLogoTrasferta2 = new JLabel();
		lblNewLabelLogoTrasferta2.setBounds(530, 131, 69, 67);
		panel.add(lblNewLabelLogoTrasferta2);
		
		lblNewLabelLogoTrasferta3 = new JLabel();
		lblNewLabelLogoTrasferta3.setBounds(530, 209, 69, 67);
		panel.add(lblNewLabelLogoTrasferta3);
		
		lblNewLabelNomeCasa1 = new JLabel();
		lblNewLabelNomeCasa1.setBounds(103, 84, 120, 16);
		panel.add(lblNewLabelNomeCasa1);
		
		lblNewLabelNomeTrasferta1 = new JLabel();
		lblNewLabelNomeTrasferta1.setBounds(392, 84, 120, 16);
		panel.add(lblNewLabelNomeTrasferta1);
		
		lblNewLabelRis1 = new JLabel();
		lblNewLabelRis1.setBounds(287, 84, 61, 16);
		panel.add(lblNewLabelRis1);
		
		lblNewLabelNomeCasa2 = new JLabel();
		lblNewLabelNomeCasa2.setBounds(103, 163, 120, 16);
		panel.add(lblNewLabelNomeCasa2);
		
		lblNewLabelRis2 = new JLabel();
		lblNewLabelRis2.setBounds(287, 163, 61, 16);
		panel.add(lblNewLabelRis2);
		
		lblNewLabelNomeTrasferta2 = new JLabel();
		lblNewLabelNomeTrasferta2.setBounds(392, 163, 120, 16);
		panel.add(lblNewLabelNomeTrasferta2);
		
		lblNewLabelNomeCasa3 = new JLabel();
		lblNewLabelNomeCasa3.setBounds(103, 235, 120, 16);
		panel.add(lblNewLabelNomeCasa3);
		
		lblNewLabelRis3 = new JLabel();
		lblNewLabelRis3.setBounds(287, 235, 61, 16);
		panel.add(lblNewLabelRis3);
		
		lblNewLabelNomeTrasferta3 = new JLabel();
		lblNewLabelNomeTrasferta3.setBounds(392, 235, 120, 16);
		panel.add(lblNewLabelNomeTrasferta3);
		
		Giornata.visualizzaGiornataDaGiocare(this);

		
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
		
		buttonCalendario.addActionListener(
				e->{
					CalendarioGUI nextFrame = new CalendarioGUI();
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
		
		btnNewButtonSchieraFormazione.addActionListener(
				l->{
					ScegliFormazioneGUI nextFrame = new ScegliFormazioneGUI(username);
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
	}
}
