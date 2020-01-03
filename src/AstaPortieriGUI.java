import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class AstaPortieriGUI extends JFrame {

	private JPanel contentPane;
	private JTextField searchable;
	private JButton searchButton;
	private JScrollPane scrollpane;
	private JTextArea console;
	private String username;
	
	


	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public AstaPortieriGUI(String username) {
		super("Asta Portieri");
		this.setUsername(username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton btnNewButtonShowAll = new JButton("Mostra Tutti");
		btnNewButtonShowAll.setBounds(31, 112, 108, 47);
		contentPane.add(btnNewButtonShowAll);

		JLabel lblNewLabelRis = new JLabel("");
		lblNewLabelRis.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelRis.setBounds(61, 205, 249, 47);
		contentPane.add(lblNewLabelRis);
		lblNewLabelRis.setVisible(false);
		console = new JTextArea(15, 15);
		console.setBounds(6, 0, 794, 291);
		contentPane.add(console);
		scrollpane = new JScrollPane(console);
		scrollpane.setEnabled(false);
		scrollpane.setLocation(20, 207);
		scrollpane.setSize(811, 250);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(200, 250));
		contentPane.add(scrollpane);

		JLabel lblNewLabel_1 = new JLabel("Seleziona un giocatore");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 471, 249, 23);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		JButton btnNewButtonChoose = new JButton("Scegli");
		btnNewButtonChoose.setBounds(698, 463, 121, 47);
		contentPane.add(btnNewButtonChoose);
		scrollpane.setVisible(false);
		btnNewButtonChoose.setVisible(false);

		JButton btnNewButtonChoose1 = new JButton("Scegli");
		btnNewButtonChoose1.setBounds(250, 205, 121, 47);
		btnNewButtonChoose1.setVisible(true);
		contentPane.add(btnNewButtonChoose1);
		btnNewButtonChoose1.setVisible(false);

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setVisible(false);
				lblNewLabel_1.setVisible(false);
				btnNewButtonChoose.setVisible(false);
				try {
					String ris = UtilityListaGiocatori.cercaGiocatore(searchable.getText(), 0);
					String [] fields = ris.split(",");
					if (fields[0].equalsIgnoreCase("") == false && fields[1].equalsIgnoreCase("0")) {
						contentPane.add(lblNewLabelRis);
						lblNewLabelRis.setText(fields[0]);
						btnNewButtonChoose1.setVisible(true);
						lblNewLabelRis.setVisible(true);

					} else if(fields[0].equalsIgnoreCase("") == true){
						lblNewLabelRis.setText("Nessun risultato trovato !");
						lblNewLabelRis.setVisible(true);
						searchable.setText("");
						
					}
					else if(fields[1].equalsIgnoreCase("1")) {
						JOptionPane.showMessageDialog(btnNewButtonChoose1, fields[0]+ " già acquistato !");
						searchable.setText("");
					}
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}
			}
		});
		console.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (console.getSelectedText() != null) {
					String s = console.getSelectedText();
				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		btnNewButtonShowAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButtonChoose1.setVisible(false);
				try {
					lblNewLabelRis.setVisible(false);
					ArrayList<String> ris = UtilityListaGiocatori.showAllPlayers(0);
					scrollpane.setVisible(true);
					for (int i = 0; i < ris.size(); i++) {
						console.append(ris.get(i));
						console.append("\n");
					}
				} catch (IOException e1) {
					System.out.println("Errore nella lettura da file");
				}
				lblNewLabel_1.setVisible(true);
				btnNewButtonChoose.setVisible(true);

			}
		});

		btnNewButtonChoose1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AstaGiocatoreGUI nextFrame;
				try {
					nextFrame = new AstaGiocatoreGUI(username,lblNewLabelRis.getText());
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

		btnNewButtonChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AstaGiocatoreGUI nextFrame;
				try {
					nextFrame = new AstaGiocatoreGUI(username,console.getSelectedText());
					nextFrame.setVisible(true);
					nextFrame.toFront();
					console.setVisible(false);
					btnNewButtonChoose.setVisible(false);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}
}
