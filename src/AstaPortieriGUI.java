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
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
	
	
}
