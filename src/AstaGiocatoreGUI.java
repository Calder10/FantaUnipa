import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AstaGiocatoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	public AstaGiocatoreGUI(String ris) {
		super("Asta in corso");
		setResizable(false);
		setBounds(100, 100, 567, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asta in corso per "+ ris);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(143, 32, 281, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(153, 86, 98, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Punta");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(295, 86, 98, 44);
		contentPane.add(btnNewButton);
	}
}
