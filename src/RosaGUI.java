import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;

/** GUI che permette di visualizzare la rosa di una determinata squadra
 * @author Salvatore Calderaro
 * @author Gaspare Casano
 */
public class RosaGUI extends JFrame {
	

	private JPanel contentPane;

	/**
	 * @param Squadra di cui si vuole visualizzare la rosa 
	 */
	public RosaGUI(Squadra s) {
		super(s.getNomeSquadra());
		setResizable(false);
		setBounds(100, 200, 778, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabelNomeSquadra = new JLabel(s.getNomeSquadra());
		lblNewLabelNomeSquadra.setBounds(219, 6, 340, 36);
		lblNewLabelNomeSquadra.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabelNomeSquadra.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabelNomeSquadra.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabelNomeSquadra.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setLayout(null);
		
		contentPane.add(lblNewLabelNomeSquadra);
		
		JLabel lblNewLabelLogo = new JLabel();
		ClassLoader cl = this.getClass().getClassLoader();
		ImageIcon img = new ImageIcon(s.pathLogo);
		lblNewLabelLogo.setIcon(img);
		lblNewLabelLogo.setBounds(6, 6, 69, 67);
		contentPane.add(lblNewLabelLogo);
		
		Box verticalBoxPortieri = Box.createVerticalBox();
		verticalBoxPortieri.setBounds(6, 85, 180, 289);
		contentPane.add(verticalBoxPortieri);
		
		
		JLabel lblNewLabel = new JLabel("PORTIERI");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		verticalBoxPortieri.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textArea.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		textArea.setForeground(Color.BLACK);
		verticalBoxPortieri.add(textArea);
		
		Box verticalBoxDifensori = Box.createVerticalBox();
		verticalBoxDifensori.setBounds(202, 85, 180, 289);
		contentPane.add(verticalBoxDifensori);
		
		JLabel lblDifesnori = new JLabel("DIFENSORI");
		lblDifesnori.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDifesnori.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifesnori.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		verticalBoxDifensori.add(lblDifesnori);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textArea_1.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		verticalBoxDifensori.add(textArea_1);
		
		Box verticalBoxCenrrocampisti = Box.createVerticalBox();
		verticalBoxCenrrocampisti.setBounds(398, 85, 180, 289);
		contentPane.add(verticalBoxCenrrocampisti);
		
		JLabel lblCentrocampisti = new JLabel("CENTROCAMPISTI");
		lblCentrocampisti.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCentrocampisti.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentrocampisti.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		verticalBoxCenrrocampisti.add(lblCentrocampisti);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textArea_2.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		verticalBoxCenrrocampisti.add(textArea_2);
		
		Box verticalBoxAttaccanti = Box.createVerticalBox();
		verticalBoxAttaccanti.setBounds(594, 85, 180, 289);
		contentPane.add(verticalBoxAttaccanti);
		
		JLabel lblAttaccanti = new JLabel("ATTACCANTI");
		lblAttaccanti.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAttaccanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttaccanti.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		verticalBoxAttaccanti.add(lblAttaccanti);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textArea_3.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		verticalBoxAttaccanti.add(textArea_3);
		
		for(Portiere p : s.portieri) {
			textArea.append(p.getNomeGiocatore()+"\n");
		}
		
		for(Difensore d : s.difensori) {
			textArea_1.append(d.getNomeGiocatore()+"\n");
		}
		
		for(Centrocampista c : s.centrocampisti) {
			textArea_2.append(c.getNomeGiocatore()+"\n");
		}
		
		for(Attaccante a : s.attaccanti) {
			textArea_3.append(a.getNomeGiocatore()+"\n");
		}

	}
}
