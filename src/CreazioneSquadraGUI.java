import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.*;
import java.awt.Color;
public class CreazioneSquadraGUI extends JFrame {

	private JPanel contentPane;
	private final JLabel lblCreaLaTua = new JLabel("Crea la tua squadra ");
	private JTextField textFieldNomeSquadra;
	private String username;
	private File f;
	private JFileChooser fc;

	
	
	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public CreazioneSquadraGUI(String username) {
		super("Creazione della FantaSquadra");
		this.setUsername(username);
		Squadra s= new Squadra();
		fc =  new JFileChooser();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCreaLaTua.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCreaLaTua.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreaLaTua.setBounds(164, 12, 350, 55);
		contentPane.add(lblCreaLaTua);
		
		JLabel lblNewLabel = new JLabel("Inserire il nome della FantaSquadra");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 59, 409, 67);
		contentPane.add(lblNewLabel);
		
		textFieldNomeSquadra = new JTextField();
		textFieldNomeSquadra.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNomeSquadra.setBounds(200, 118, 278, 55);
		contentPane.add(textFieldNomeSquadra);
		textFieldNomeSquadra.setColumns(10);
		
		JLabel lblScegliIlLogo = new JLabel("Scegli il logo della tua FantaSquadra");
		lblScegliIlLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliIlLogo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblScegliIlLogo.setBounds(95, 178, 489, 67);
		contentPane.add(lblScegliIlLogo);
		
		
		ClassLoader cl = this.getClass().getClassLoader();
		ImageIcon imgUp = new ImageIcon(cl.getResource("Immagini/icons8-caricare-64.png"));
		JButton btnNewButtonScegli = new JButton(imgUp);
		btnNewButtonScegli.setBackground(Color.WHITE);
		btnNewButtonScegli.setBorder(null);
		btnNewButtonScegli.setContentAreaFilled(false);
		btnNewButtonScegli.setBounds(125, 226, 130, 67);
		contentPane.add(btnNewButtonScegli);
		JLabel image = new JLabel("");
		image.setSize(108, 100);
		image.setLocation(289, 211);
		contentPane.add(image);
		
		ImageIcon imgAvanti = new ImageIcon(cl.getResource("Immagini/freccia.png"));
		JButton btnNewButtonContinua = new JButton(imgAvanti);
		btnNewButtonContinua.setBackground(Color.WHITE);
		btnNewButtonContinua.setBorder(null);
		btnNewButtonContinua.setContentAreaFilled(false);
		btnNewButtonContinua.setBounds(494, 311, 173, 92);
		contentPane.add(btnNewButtonContinua);
		btnNewButtonScegli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int ris = fc.showOpenDialog(null);
				if (ris==fc.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					try {
						
						image.setIcon(new ImageIcon(ImageIO.read(f)));
					
					}catch(IOException ex){
						ex.printStackTrace();
					}
				}
			}
		});
		
	
		
		btnNewButtonContinua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textFieldNomeSquadra.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(textFieldNomeSquadra,"Nome Squadra non può essere vuoto");
				}
				else {
				
					s.setNomeSquadra(textFieldNomeSquadra.getText());
					f= fc.getSelectedFile();
					s.salvaLogo(f);
					try {
						s.addNomeSquadraToCsv(username, textFieldNomeSquadra.getText());
						s.salvaSquadraSuFile();
						SquadraVirtuale.creaSquadreVirtuali();
						AstaPortieriGUI nextFrame = new AstaPortieriGUI(username);
						nextFrame.setVisible(true);
						nextFrame.toFront();
						setVisible(false);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
	}
}
