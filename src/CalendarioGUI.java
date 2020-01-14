import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class CalendarioGUI extends JFrame {

	private JPanel contentPane;
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
	private JButton i3;
	private JButton i2;
	private JButton i1;
	private int giornataCorrente;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
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
	
	public JButton getI1() {
		return i3;
	}

	public void setI1(JButton i1) {
		this.i3 = i1;
	}
	
	public JButton getI2() {
		return i2;
	}

	public void setI2(JButton i2) {
		this.i2 = i2;
	}

	public JButton getI3() {
		return i1;
	}

	public void setI3(JButton i3) {
		this.i1 = i3;
	}


	
	public CalendarioGUI(String username, int giornata) {
		super("Calendario");
		setResizable(false);
		setBounds(100, 100, 792, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButtonGiornata1 = new JButton("Giornata 1");
		btnNewButtonGiornata1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButtonGiornata1.setBounds(6, 6, 154, 46);
		contentPane.add(btnNewButtonGiornata1);
		
		JButton btnNewButtonGiornata2 = new JButton("Giornata 2");
		btnNewButtonGiornata2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButtonGiornata2.setBounds(6, 64, 154, 46);
		contentPane.add(btnNewButtonGiornata2);
		
		JButton btnNewButtonGiornata3 = new JButton("Giornata 3");
		btnNewButtonGiornata3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButtonGiornata3.setBounds(6, 122, 154, 46);
		contentPane.add(btnNewButtonGiornata3);
		
		JButton btnNewButtonGiornata4 = new JButton("Giornata 4");
		btnNewButtonGiornata4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButtonGiornata4.setBounds(6, 185, 154, 46);
		contentPane.add(btnNewButtonGiornata4);
		
		JButton btnNewButtonGiornata5 = new JButton("Giornata 5");
		btnNewButtonGiornata5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButtonGiornata5.setBounds(6, 243, 154, 46);
		contentPane.add(btnNewButtonGiornata5);
		
		
		
		panel = new JPanel();
		panel.setBounds(172, 0, 620, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabelGiornata = new JLabel();
		lblNewLabelGiornata.setBounds(200, 5, 152, 25);
		lblNewLabelGiornata.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblNewLabelGiornata);
		
		lblNewLabelLogoCasa1 = new JLabel();
		lblNewLabelLogoCasa1.setBounds(22, 59, 69, 67);
		panel.add(lblNewLabelLogoCasa1);
		
		lblNewLabelLogoCasa2 = new JLabel();
		lblNewLabelLogoCasa2.setBounds(22, 138, 69, 67);
		panel.add(lblNewLabelLogoCasa2);
		
		lblNewLabelLogoCasa3 = new JLabel();
		lblNewLabelLogoCasa3.setBounds(22, 210, 69, 67);
		panel.add(lblNewLabelLogoCasa3);
		
		lblNewLabelLogoTrasferta1 = new JLabel();
		lblNewLabelLogoTrasferta1.setBounds(434, 59, 69, 67);
		panel.add(lblNewLabelLogoTrasferta1);
		
		lblNewLabelLogoTrasferta2 = new JLabel();
		lblNewLabelLogoTrasferta2.setBounds(434, 138, 69, 67);
		panel.add(lblNewLabelLogoTrasferta2);
		
		lblNewLabelLogoTrasferta3 = new JLabel();
		lblNewLabelLogoTrasferta3.setBounds(434, 210, 69, 67);
		panel.add(lblNewLabelLogoTrasferta3);
		
		lblNewLabelNomeCasa1 = new JLabel();
		lblNewLabelNomeCasa1.setBounds(103, 84, 120, 16);
		panel.add(lblNewLabelNomeCasa1);
		
		lblNewLabelNomeTrasferta1 = new JLabel();
		lblNewLabelNomeTrasferta1.setBounds(302, 84, 120, 16);
		panel.add(lblNewLabelNomeTrasferta1);
		
		lblNewLabelRis1 = new JLabel();
		lblNewLabelRis1.setBounds(230, 84, 61, 16);
		panel.add(lblNewLabelRis1);
		
		lblNewLabelNomeCasa2 = new JLabel();
		lblNewLabelNomeCasa2.setBounds(103, 163, 120, 16);
		panel.add(lblNewLabelNomeCasa2);
		
		lblNewLabelRis2 = new JLabel();
		lblNewLabelRis2.setBounds(230, 163, 61, 16);
		panel.add(lblNewLabelRis2);
		
		lblNewLabelNomeTrasferta2 = new JLabel();
		lblNewLabelNomeTrasferta2.setBounds(302, 163, 120, 16);
		panel.add(lblNewLabelNomeTrasferta2);
		
		lblNewLabelNomeCasa3 = new JLabel();
		lblNewLabelNomeCasa3.setBounds(103, 235, 120, 16);
		panel.add(lblNewLabelNomeCasa3);
		
		lblNewLabelRis3 = new JLabel();
		lblNewLabelRis3.setBounds(230, 235, 61, 16);
		panel.add(lblNewLabelRis3);
		
		lblNewLabelNomeTrasferta3 = new JLabel();
		lblNewLabelNomeTrasferta3.setBounds(302, 235, 120, 16);
		panel.add(lblNewLabelNomeTrasferta3);
		
		
		i3= new JButton(new ImageIcon(CalendarioGUI.class.getResource("/Immagini/get_info_13806.png")));
		i3.setBounds(515, 218, 89, 59);
		panel.add(i3);
		i3.setBackground(Color.WHITE);
		i3.setBorder(null);
		i3.setContentAreaFilled(false);
		i3.setVisible(false);
		
		i2= new JButton(new ImageIcon(CalendarioGUI.class.getResource("/Immagini/get_info_13806.png")));
		i2.setBounds(515, 133, 89, 59);
		panel.add(i2);
		i2.setBackground(Color.WHITE);
		i2.setBorder(null);
		i2.setContentAreaFilled(false);
		i2.setVisible(false);
		
		i1= new JButton(new ImageIcon(CalendarioGUI.class.getResource("/Immagini/get_info_13806.png")));
		i1.setBounds(515, 59, 89, 59);
		panel.add(i1);
		i1.setBackground(Color.WHITE);
		i1.setBorder(null);
		i1.setContentAreaFilled(false);
		i1.setVisible(false);
		
		
		
		btnNewButtonGiornata1.addActionListener(
				e->{
					Giornata.visualizzaGiornata(this, 1);
					giornataCorrente=1;
					this.getPanel().setVisible(true);
				});
		
		btnNewButtonGiornata1.addActionListener(
				e->{
					Giornata.visualizzaGiornata(this, 1);
					this.getPanel().setVisible(true);
					this.giornataCorrente=1;
				});
		
		btnNewButtonGiornata2.addActionListener(
				e->{
					Giornata.visualizzaGiornata(this, 2);
					this.getPanel().setVisible(true);
					this.giornataCorrente=2;
					
				});
		
		btnNewButtonGiornata3.addActionListener(
				e->{
					Giornata.visualizzaGiornata(this, 3);
					this.getPanel().setVisible(true);
					this.giornataCorrente=3;
				});
		
		btnNewButtonGiornata4.addActionListener(
				e->{
					Giornata.visualizzaGiornata(this, 4);
					this.getPanel().setVisible(true);
					this.giornataCorrente=4;
				});
		
		btnNewButtonGiornata5.addActionListener(
				e->{
					Giornata.visualizzaGiornata(this, 5);
					this.getPanel().setVisible(true);
					this.giornataCorrente=5;
				});
		
		i3.addActionListener(
				e->{
					try {
						ResocontoVotiGUI info1 = new ResocontoVotiGUI(giornataCorrente-1, 2, username);
						info1.toFront();
						info1.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
		
		i2.addActionListener(
				e->{
					try {
						ResocontoVotiGUI info1 = new ResocontoVotiGUI(giornataCorrente-1, 1, username);
						info1.toFront();
						info1.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
		
		i1.addActionListener(
				e->{
					try {
						ResocontoVotiGUI info1 = new ResocontoVotiGUI(giornataCorrente-1, 0, username);
						info1.toFront();
						info1.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
	}
}
