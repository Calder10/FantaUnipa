import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class AstaGUI extends JFrame{
	
	
	private String username;

	

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
		super(s);
	}
}
