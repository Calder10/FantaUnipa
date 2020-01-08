import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Component;

public class SquadreGUI extends JFrame {

	private JPanel contentPane;

	public SquadreGUI(String nomeSquadra) throws ClassNotFoundException {
		super("Squadre partecipanti");
		setResizable(false);
		setBounds(100, 100, 740, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SQUADRE PARTECIPANTI");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(183, 6, 373, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabelLogo2 = new JLabel();
		lblNewLabelLogo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelLogo2.setBounds(473, 77, 69, 67);
		contentPane.add(lblNewLabelLogo2);
		
		JLabel labelSquadra1 = new JLabel("New label");
		labelSquadra1.setHorizontalAlignment(SwingConstants.CENTER);
		labelSquadra1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelSquadra1.setBounds(152, 139, 172, 31);
		contentPane.add(labelSquadra1);
		
		JLabel lblNewLabelLogo3 = new JLabel();
		lblNewLabelLogo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelLogo3.setBounds(116, 213, 69, 67);
		contentPane.add(lblNewLabelLogo3);
		
		JLabel lblNewLabelLogo4 = new JLabel();
		lblNewLabelLogo4.setBounds(339, 213, 69, 67);
		contentPane.add(lblNewLabelLogo4);
		
		JLabel lblNewLabelLogo5 = new JLabel();
		lblNewLabelLogo5.setBounds(574, 213, 69, 67);
		contentPane.add(lblNewLabelLogo5);
		
		JLabel labelSquadra2 = new JLabel();
		labelSquadra2.setHorizontalAlignment(SwingConstants.CENTER);
		labelSquadra2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelSquadra2.setBounds(421, 139, 172, 31);
		contentPane.add(labelSquadra2);
		
		JLabel lblNewLabelLogo1 = new JLabel();
		lblNewLabelLogo1.setBounds(204, 77, 69, 67);
		contentPane.add(lblNewLabelLogo1);
		lblNewLabelLogo1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabelLogo1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel labelSquadra3 = new JLabel();
		labelSquadra3.setHorizontalAlignment(SwingConstants.CENTER);
		labelSquadra3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelSquadra3.setBounds(70, 279, 161, 31);
		contentPane.add(labelSquadra3);
		
		JLabel labelSquadra4 = new JLabel();
		labelSquadra4.setHorizontalAlignment(SwingConstants.CENTER);
		labelSquadra4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelSquadra4.setBounds(291, 279, 161, 31);
		contentPane.add(labelSquadra4);
		
		JLabel labelSquadra5 = new JLabel();
		labelSquadra5.setHorizontalAlignment(SwingConstants.CENTER);
		labelSquadra5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelSquadra5.setBounds(532, 279, 153, 31);
		contentPane.add(labelSquadra5);
		
		ArrayList<Squadra> squadre= Squadra.getSquadreVirtualiFromFile(nomeSquadra);
		
		ImageIcon img1 = new ImageIcon(squadre.get(0).getPathLogo());
		lblNewLabelLogo1.setIcon(img1);
		labelSquadra1.setText(squadre.get(0).nomeSquadra);
		
		ImageIcon img2 = new ImageIcon(squadre.get(1).pathLogo);
		lblNewLabelLogo2.setIcon(img2);
		labelSquadra2.setText(squadre.get(1).nomeSquadra);
		
		ImageIcon img3 = new ImageIcon(squadre.get(2).pathLogo);
		lblNewLabelLogo3.setIcon(img3);
		labelSquadra3.setText(squadre.get(2).nomeSquadra);
		
		ImageIcon img4 = new ImageIcon(squadre.get(3).pathLogo);
		lblNewLabelLogo4.setIcon(img4);
		labelSquadra4.setText(squadre.get(3).nomeSquadra);
		
		ImageIcon img5 = new ImageIcon(squadre.get(4).pathLogo);
		lblNewLabelLogo5.setIcon(img5);
		labelSquadra5.setText(squadre.get(4).nomeSquadra);
		
		labelSquadra1.addMouseListener((MousePressListner)
				(e)->{
					RosaGUI nextFrame;
					nextFrame = new RosaGUI(squadre.get(0));
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
		
		labelSquadra2.addMouseListener((MousePressListner)
				(e)->{
					RosaGUI nextFrame;
					nextFrame = new RosaGUI(squadre.get(1));
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
		
		labelSquadra3.addMouseListener((MousePressListner)
				(e)->{
					RosaGUI nextFrame;
					nextFrame = new RosaGUI(squadre.get(2));
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
		
		
		labelSquadra4.addMouseListener((MousePressListner)
				(e)->{
					RosaGUI nextFrame;
					nextFrame = new RosaGUI(squadre.get(3));
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
		
		labelSquadra5.addMouseListener((MousePressListner)
				(e)->{
					RosaGUI nextFrame;
					nextFrame = new RosaGUI(squadre.get(4));
					nextFrame.toFront();
					nextFrame.setVisible(true);
				});
		
	}
}
