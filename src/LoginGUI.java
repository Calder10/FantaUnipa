import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public LoginGUI() {
		super("FantaUnipa");
		Registrazione r = new Registrazione();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFantaunipa = new JLabel("FANTAUNIPA");
		lblFantaunipa.setBounds(12, 7, 617, 48);
		lblFantaunipa.setHorizontalAlignment(SwingConstants.CENTER);
		lblFantaunipa.setFont(new Font("Dialog", Font.BOLD, 40));
		contentPane.add(lblFantaunipa);
		
		JLabel lblNewLabel = new JLabel();
		ClassLoader cl = this.getClass().getClassLoader();
		ImageIcon img = new ImageIcon(cl.getResource("Immagini/pallone.png"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(120, -2, 69, 67);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel();
		label.setIcon(img);
		label.setBounds(475, -2, 69, 67);
		contentPane.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 25));
		lblUsername.setBounds(237, 67, 166, 30);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(164, 101, 312, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 25));
		label_1.setBounds(237, 147, 166, 30);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(164, 189, 312, 34);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(260, 235, 120, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean ris = false;
				boolean existSquadra = r.existSquadra(textField.getText() );
				try {
					ris=r.login(textField.getText(),passwordField.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(ris==true && existSquadra== false) {
					CreazioneSquadraGUI nextFrame = new CreazioneSquadraGUI(textField.getText());
					nextFrame.setUsername(textField.getText());
					nextFrame.setVisible(true);
					nextFrame.toFront();
					setVisible(false);
				}
				else if(ris==true && existSquadra== true) {
					System.out.println("PAGINA HOME");
				}
				else if(ris==false){
					JOptionPane.showMessageDialog(btnNewButton, "Errore ! Username o password errati !");
					textField.setText("");
					passwordField.setText("");
				}
					
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("Non sei ancora registrato ?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-38, 280, 717, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("REGISTRATI");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrazioneGUI nextFrame = null;
				try {
					nextFrame = new RegistrazioneGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				nextFrame.setVisible(true);
				nextFrame.toFront();
				setVisible(false);
			}		
		});
		button.setBounds(257, 323, 127, 40);
		contentPane.add(button);
	}
}

