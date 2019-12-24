import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegistrazioneGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrazioneGUI frame = new RegistrazioneGUI();
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
	 * @throws HeadlessException 
	 */
	public RegistrazioneGUI() {
		Registrazione r = new Registrazione();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 603);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFantaunipa = new JLabel("FANTAUNIPA");
		lblFantaunipa.setBounds(-58, 7, 617, 48);
		lblFantaunipa.setHorizontalAlignment(SwingConstants.CENTER);
		lblFantaunipa.setFont(new Font("Dialog", Font.BOLD, 40));
		contentPane.add(lblFantaunipa);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/gaspare/Documenti/GitHub/FantaUnipa/Immagini/pallone.png"));
		lblNewLabel.setBounds(45, -2, 69, 67);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("/home/gaspare/Documenti/GitHub/FantaUnipa/Immagini/pallone.png"));
		label.setBounds(400, -2, 69, 67);
		contentPane.add(label);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNome.setBounds(146, 52, 218, 67);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNome.setBounds(115, 117, 280, 35);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCognome.setBounds(146, 152, 218, 67);
		contentPane.add(lblCognome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(115, 214, 280, 35);
		contentPane.add(textFieldCognome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 25));
		lblUsername.setBounds(146, 241, 218, 67);
		contentPane.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(115, 301, 280, 35);
		contentPane.add(textFieldUsername);
		
		
				
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPassword.setBounds(146, 331, 218, 67);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 390, 280, 35);
		contentPane.add(passwordField);
		
		JButton buttonRegistrati = new JButton("REGISTRATI");
		buttonRegistrati.setFont(new Font("Dialog", Font.BOLD, 20));
		buttonRegistrati.setBounds(115, 473, 280, 61);
		contentPane.add(buttonRegistrati);
		buttonRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome=textFieldNome.getText();
					String cognome=textFieldCognome.getText();
					String username=textFieldUsername.getText();
					String pwd=passwordField.getText();
					boolean campiNonNulli=r.controlloCampiNonNulli(nome, cognome, username, pwd);
					boolean checkUsr= r.checkUsername(username);
					boolean checkPwd = r.checkPassword(pwd);
					if(campiNonNulli==false)
						JOptionPane.showMessageDialog(passwordField, "Inserire tutti i campi");
						
					if(checkUsr==false && checkPwd==false && campiNonNulli==true) {
						JOptionPane.showMessageDialog(passwordField, "Username e password non validi");
						passwordField.setText("");
						passwordField.setText("");
					}
					
					if(checkUsr==false) {
						JOptionPane.showMessageDialog(textFieldUsername, "Username già usato!");
						textFieldUsername.setText("");
					}
					
					if(checkPwd==false && campiNonNulli==true) {
						JOptionPane.showMessageDialog(passwordField, "La password deve contenere almeno 6 caratteri, contenere almeno una lettera maiuscola e almeno una cifra");
						passwordField.setText("");
					}
					if(checkUsr == true && checkPwd==true) {
						ConcreteFantallenatoreBuilder a = new ConcreteFantallenatoreBuilder ();
						Director d = new Director(a);
						d.createFantallenatore(nome, cognome, username, pwd);
						Fantallenatore f = d.getFantallenatore();
						r.salvaUtente(f);
						r.creaFantallenatoriVirtuali();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}		
		});
	}

}
