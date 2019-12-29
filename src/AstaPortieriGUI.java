import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class AstaPortieriGUI extends JFrame {

	private JPanel contentPane;
	private JTextField searchable;
	private JButton searchButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AstaPortieriGUI frame = new AstaPortieriGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AstaPortieriGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asta Portieri in corso.....");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 6, 502, 36);
		contentPane.add(lblNewLabel);
		
		searchable=new JTextField(30);
		searchable.setLocation(31, 65);
		searchable.setSize(719, 36);
		searchButton=new JButton("Cerca");
		searchButton.setSize(79, 47);
		searchButton.setLocation(752, 61);
		
		contentPane.add(searchable);
		contentPane.add(searchButton);
		
		JButton btnNewButtonShowAll = new JButton("Mostra Tutti");
		btnNewButtonShowAll.setBounds(31, 112, 108, 47);
		contentPane.add(btnNewButtonShowAll);
		
		JLabel lblNewLabelRis = new JLabel("New label");
		lblNewLabelRis.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelRis.setBounds(61, 205, 249, 47);
		contentPane.add(lblNewLabelRis);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(27, 205, 47, 47);
		
		contentPane.add(chckbxNewCheckBox_1);
		
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ris = UtilityListaGiocatori.cercaGiocatore(searchable.getText(), 0);
					if(ris.equalsIgnoreCase("")==false) {
						contentPane.add(lblNewLabelRis);
						contentPane.add(chckbxNewCheckBox_1);
						lblNewLabelRis.setText(ris);
						
					}
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}
			}
		});
		
	}
}
