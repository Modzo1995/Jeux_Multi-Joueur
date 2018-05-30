import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Interface {

	private JFrame Interface;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.Interface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Interface = new JFrame();
		Interface.getContentPane().setBackground(new Color(191, 205, 219));
		Interface.setForeground(Color.BLACK);
		Interface.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Interface.setTitle("Cr\u00E9ation Personnage");
		Interface.setBackground(Color.GRAY);
		Interface.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Salha Abdourhamane\\Documents\\ucadd-696x696.jpg"));
		Interface.getContentPane().setForeground(Color.ORANGE);
		Interface.setBounds(100, 100, 590, 325);
		Interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interface.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pseudo");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(123, 98, 71, 13);
		Interface.getContentPane().add(lblNewLabel_1);
		
		JLabel lblProfil = new JLabel("Profil");
		lblProfil.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblProfil.setBounds(126, 180, 45, 13);
		Interface.getContentPane().add(lblProfil);
		
		textField = new JTextField();
		textField.setBounds(204, 89, 160, 35);
		Interface.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 158, 160, 35);
		Interface.getContentPane().add(textField_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnValider.setBounds(220, 217, 119, 35);
		Interface.getContentPane().add(btnValider);
	}
}
