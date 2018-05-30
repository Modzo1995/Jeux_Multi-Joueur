import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class Profiler {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profiler window = new Profiler();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Profiler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(542, 345, 131, 49);
		frame.getContentPane().add(btnQuitter);
		
		JLabel lblPseudo = new JLabel("Pseudo:");
		lblPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPseudo.setBounds(140, 53, 82, 27);
		frame.getContentPane().add(lblPseudo);
		
		JLabel lblProfil = new JLabel("Profil:");
		lblProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfil.setBounds(140, 91, 82, 33);
		frame.getContentPane().add(lblProfil);
		
		JLabel lblNewLabel = new JLabel("Capacit\u00E8:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 135, 82, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(55, 243, 180, 172);
		frame.getContentPane().add(tabbedPane);
		
		table = new JTable();
		tabbedPane.addTab("Liste des personnes Connect\u00E9es\r\n", null, table, null);
		tabbedPane.setBackgroundAt(0, new Color(0, 0, 0));
	}
}
