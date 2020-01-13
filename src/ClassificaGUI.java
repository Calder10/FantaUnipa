import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.Label;

public class ClassificaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassificaGUI frame = new ClassificaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClassificaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 707, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassifica = new JLabel("CLASSIFICA");
		lblClassifica.setFont(new Font("Dialog", Font.BOLD, 30));
		lblClassifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassifica.setBounds(232, 12, 243, 36);
		contentPane.add(lblClassifica);
		
		
		ImageIcon img = new ImageIcon("src/Immagini/pallone.png");
		
		
		
		String [] colonne = new String[]{"POSIZIONE","LOGO","SQUADRA","DR","GS","GF","PUNTI"};
		Object [][] righe = new Object[] []{{1,img,"Inter",20,30,40,46},{2,img,"Roma",30,20,30,20},};
		
		

		 DefaultTableModel model = new DefaultTableModel(righe, colonne);
		    JTable table = new JTable(model) {
		      public Class getColumnClass(int column) {
		    	  
		        return (column == 1) ? Icon.class : Object.class;
		      }
		    };
		
		    
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setRowHeight(60);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 60, 683, 262);
		contentPane.add(scrollPane);
		
		
	}
}
