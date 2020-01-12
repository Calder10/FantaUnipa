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

public class ResocontoGiornataGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
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
	private JButton b1;
	private JButton b2;
	private JButton b3;

	
	
	public JPanel getContentPane() {
		return contentPane;
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

	


	public ResocontoGiornataGUI(int numeroGiornata,String username) throws IOException {
		super("Giornata " +" "+(numeroGiornata+1));
		setResizable(false);
		setBounds(100, 100, 924, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelGiornata = new JLabel("Giornata"+" "+(numeroGiornata+1));
		labelGiornata.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		labelGiornata.setHorizontalAlignment(SwingConstants.CENTER);
		labelGiornata.setBounds(278, 6, 367, 33);
		contentPane.add(labelGiornata);
		
		panel = new JPanel();
		panel.setBounds(36, 58, 860, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		
		b1 = new JButton("Visualizza Voti");
		b1.setBounds(676, 71, 159, 29);
		panel.add(b1);
		
		b2 = new JButton("Visualizza Voti");
		b2.setBounds(676, 150, 159, 29);
		panel.add(b2);
		
		b3 = new JButton("Visualizza Voti");
		b3.setBounds(676, 235, 159, 29);
		panel.add(b3);
		
		Giornata.visualizzaResocontoGiornata(this, numeroGiornata);
		
		b1.addActionListener(
				e->{
					ResocontoVotiGUI nextFrame;
					try {
						nextFrame = new ResocontoVotiGUI(numeroGiornata,0,username);
						nextFrame.toFront();
						nextFrame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						System.out.println("errore nelal lettura da file !");
					}
					
				});
		
		
		
		
		b2.addActionListener(
				e->{
					ResocontoVotiGUI nextFrame;
					try {
						nextFrame = new ResocontoVotiGUI(numeroGiornata,1,username);
						nextFrame.toFront();
						nextFrame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						System.out.println("errore nelal lettura da file !");
					}
					
				});
		
		b3.addActionListener(
				e->{
					ResocontoVotiGUI nextFrame;
					try {
						nextFrame = new ResocontoVotiGUI(numeroGiornata,2,username);
						nextFrame.toFront();
						nextFrame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						System.out.println("errore nelal lettura da file !");
					}
				});
		
	}
}
