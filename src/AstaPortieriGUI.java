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

public class AstaPortieriGUI extends AstaGUI{

	private JPanel contentPane;
	private JTextField searchable;
	private JButton searchButton;
	private JScrollPane scrollpane;
	private JTextArea console;
	private JButton btnNewButtonShowAll;
	private JLabel lblNewLabelRis;
	private JButton btnNewButtonChoose1;
	private String username;
	private JList list;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AstaPortieriGUI getAstaPortieriGUI() {
		return this;
	}

	public AstaPortieriGUI(String username) {
		super("Asta Portieri");
		this.setUsername(username);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 849, 544);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Asta Portieri in corso.....");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 6, 502, 36);
		contentPane.add(lblNewLabel);

		searchable = new JTextField(30);
		searchable.setLocation(31, 65);
		searchable.setSize(719, 36);
		searchButton = new JButton("Cerca");
		searchButton.setSize(79, 47);
		searchButton.setLocation(752, 61);

		contentPane.add(searchable);
		contentPane.add(searchButton);

		btnNewButtonShowAll = new JButton("Mostra Tutti");
		btnNewButtonShowAll.setBounds(31, 112, 121, 47);
		contentPane.add(btnNewButtonShowAll);

		lblNewLabelRis = new JLabel("");
		lblNewLabelRis.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelRis.setBounds(61, 205, 249, 47);
		contentPane.add(lblNewLabelRis);
		lblNewLabelRis.setVisible(false);

		btnNewButtonChoose1 = new JButton("Scegli");
		btnNewButtonChoose1.setBounds(250, 205, 121, 47);
		btnNewButtonChoose1.setVisible(true);
		contentPane.add(btnNewButtonChoose1);
		
		
		btnNewButtonChoose1.setVisible(false);
		list = new JList();
		list.setLocation(24, 171);
		list.setSize(800, 288);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scrollpane = new JScrollPane(list);
		scrollpane.setEnabled(false);
		scrollpane.setLocation(26, 171);
		scrollpane.setSize(800, 288);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(200, 250));
		contentPane.add(scrollpane);
		
		scrollpane.setVisible(false);
		
		this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {
            	JOptionPane.showMessageDialog(contentPane, "Asta in corso..!");
				
            }  
        });

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setVisible(false);
				try {
					String ris = UtilityListaGiocatori.cercaGiocatore(searchable.getText(), 0);
					String[] fields = ris.split(",");
					if (fields[0].equalsIgnoreCase("") == false && fields[1].equalsIgnoreCase("0")) {
						contentPane.add(lblNewLabelRis);
						lblNewLabelRis.setText(fields[0]);
						btnNewButtonChoose1.setVisible(true);
						lblNewLabelRis.setVisible(true);

					} else if (fields[0].equalsIgnoreCase("") == true) {
						lblNewLabelRis.setText("Nessun risultato trovato !");
						lblNewLabelRis.setVisible(true);
						searchable.setText("");

					} else if (fields[1].equalsIgnoreCase("1")) {
						JOptionPane.showMessageDialog(btnNewButtonChoose1, fields[0] + " già acquistato !");
						searchable.setText("");
					}
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}
			}
		});
		
		
		
		btnNewButtonShowAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButtonChoose1.setVisible(false);
				try {
					lblNewLabelRis.setVisible(false);
					ArrayList<String> ris=null;
					ris = UtilityListaGiocatori.showAllPlayers(0);
					Object [] data=ris.toArray();
					scrollpane.setVisible(true);
					list.setListData(data);
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}

			}
		});

		btnNewButtonChoose1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AstaGiocatoreGUI nextFrame;
				try {
					nextFrame = new AstaGiocatoreGUI(getAstaPortieriGUI(), username, lblNewLabelRis.getText(),0);
					nextFrame.setVisible(true);
					nextFrame.toFront();
					btnNewButtonChoose1.setVisible(false);
					lblNewLabelRis.setVisible(false);
					searchable.setText("");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		list.addMouseListener(new MouseListener() {
			
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
				Object o=list.getSelectedValue();
				String nomeGiocatore= o.toString();
				AstaGiocatoreGUI nextFrame;
				try {
					nextFrame = new AstaGiocatoreGUI(getAstaPortieriGUI(), username, nomeGiocatore,0);
					nextFrame.setVisible(true);
					nextFrame.toFront();
					btnNewButtonChoose1.setVisible(false);
					lblNewLabelRis.setVisible(false);
					scrollpane.setVisible(false);
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
