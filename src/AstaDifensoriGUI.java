import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class AstaDifensoriGUI extends AstaGUI{

	private JPanel contentPane1;
	private JTextField searchable1;
	private JButton searchButton1;
	private JScrollPane scrollpane1;
	private JTextArea console1;
	private JButton btnNewButtonShowAll1;
	private JLabel lblNewLabelRis1;
	private JButton btnNewButtonChoose;
	private String username1;
	private JList list1;
	

	public String getusername1() {
		return username1;
	}

	public void setusername1(String username1) {
		this.username1 = username1;
	}

	public AstaDifensoriGUI getAstaDifensoriGUI() {
		return this;
	}

	public AstaDifensoriGUI(String username1) {
		super("Asta Difensori");
		this.setusername1(username1);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 849, 544);
		setResizable(false);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Asta Difensori in corso.....");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 6, 502, 36);
		contentPane1.add(lblNewLabel);

		searchable1 = new JTextField(30);
		searchable1.setLocation(31, 65);
		searchable1.setSize(719, 36);
		searchButton1 = new JButton("Cerca");
		searchButton1.setSize(79, 47);
		searchButton1.setLocation(752, 61);

		contentPane1.add(searchable1);
		contentPane1.add(searchButton1);

		btnNewButtonShowAll1 = new JButton("Mostra Tutti");
		btnNewButtonShowAll1.setBounds(31, 112, 121, 47);
		contentPane1.add(btnNewButtonShowAll1);

		lblNewLabelRis1 = new JLabel("");
		lblNewLabelRis1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelRis1.setBounds(61, 205, 249, 47);
		contentPane1.add(lblNewLabelRis1);
		lblNewLabelRis1.setVisible(false);

		btnNewButtonChoose = new JButton("Scegli");
		btnNewButtonChoose.setBounds(250, 205, 121, 47);
		btnNewButtonChoose.setVisible(true);
		contentPane1.add(btnNewButtonChoose);
		
		
		btnNewButtonChoose.setVisible(false);
		list1 = new JList();
		list1.setLocation(24, 171);
		list1.setSize(800, 288);
		list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scrollpane1 = new JScrollPane(list1);
		scrollpane1.setEnabled(false);
		scrollpane1.setLocation(26, 171);
		scrollpane1.setSize(800, 288);
		scrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane1.setPreferredSize(new Dimension(200, 250));
		contentPane1.add(scrollpane1);
		
		scrollpane1.setVisible(false);
		
		this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {
            	JOptionPane.showMessageDialog(contentPane1, "Asta in corso..!");
				
            }  
        });

		searchButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane1.setVisible(false);
				try {
					String ris = UtilityListaGiocatori.cercaGiocatore(searchable1.getText(), 1);
					String[] fields = ris.split(",");
					if (fields[0].equalsIgnoreCase("") == false && fields[1].equalsIgnoreCase("0")) {
						contentPane1.add(lblNewLabelRis1);
						lblNewLabelRis1.setText(fields[0]);
						btnNewButtonChoose.setVisible(true);
						lblNewLabelRis1.setVisible(true);

					} else if (fields[0].equalsIgnoreCase("") == true) {
						lblNewLabelRis1.setText("Nessun risultato trovato !");
						lblNewLabelRis1.setVisible(true);
						searchable1.setText("");

					} else if (fields[1].equalsIgnoreCase("1")) {
						JOptionPane.showMessageDialog(btnNewButtonChoose, fields[0] + " già acquistato !");
						searchable1.setText("");
					}
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}
			}
		});
		
		
		
		btnNewButtonShowAll1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButtonChoose.setVisible(false);
				try {
					lblNewLabelRis1.setVisible(false);
					ArrayList<String> ris=null;
					ris = UtilityListaGiocatori.showAllPlayers(1);
					Object [] data=ris.toArray();
					scrollpane1.setVisible(true);
					list1.setListData(data);
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}

			}
		});

		btnNewButtonChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AstaGiocatoreGUI nextFrame;
				try {
					nextFrame = new AstaGiocatoreGUI(getAstaDifensoriGUI(), username1, lblNewLabelRis1.getText(),1);
					nextFrame.setVisible(true);
					nextFrame.toFront();
					btnNewButtonChoose.setVisible(false);
					lblNewLabelRis1.setVisible(false);
					searchable1.setText("");
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		list1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o=list1.getSelectedValue();
				String nomeGiocatore= o.toString();
				AstaGiocatoreGUI nextFrame;
				try {
					nextFrame = new AstaGiocatoreGUI(getAstaDifensoriGUI(), username1, nomeGiocatore,1);
					nextFrame.setVisible(true);
					nextFrame.toFront();
					btnNewButtonChoose.setVisible(false);
					lblNewLabelRis1.setVisible(false);
					scrollpane1.setVisible(false);
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
