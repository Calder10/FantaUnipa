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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.Label;

public class ClassificaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ClassificaGUI() throws IOException, ClassNotFoundException {
		super("Classifica");
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
		
		File f = new File ("src/torneo.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Torneo t = (Torneo) ois.readObject();
		ois.close();
		fis.close();
		 ArrayList<ArrayList<Object>> c= t.getClassifica().getClassifica();
		 int i=0;
		
		
		
		String [] colonne = new String[]{"POSIZIONE","LOGO","SQUADRA","DR","GS","GF","PUNTI"};
		Object [][] data= new Object[6][7];
		for (ArrayList<Object> o : c) {
			data[i][0]=o.get(0);
			data[i][1]= new ImageIcon((String)o.get(1));
			data[i][2]=o.get(2);
			data[i][3]=o.get(3);
			data[i][4]=o.get(4);
			data[i][5]=o.get(5);
			data[i][6]=o.get(6);
			i++;
		}
		
		

		 DefaultTableModel model = new DefaultTableModel(data, colonne);
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
