import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class AstaGUI extends JFrame{
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

	public AstaGUI getAstaGUI() {
		return this;
	}

	public AstaGUI(String s) {
		super();
	}
}
