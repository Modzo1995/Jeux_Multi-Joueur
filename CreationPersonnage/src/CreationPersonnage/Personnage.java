package CreationPersonnage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entites.Personne;
public class Personnage extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel pseudo, profil;
	private JTextField lprofil, lpseudo;
	private JButton aj,qt,aff;
	private JPanel pan1,pan2;
	private Socket socket;
	DataOutputStream out;
	DataInputStream in;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    
    
	public Personnage() 
	{
		pseudo=new JLabel("Pseudo :");
		profil= new JLabel("Profil :");
		lprofil= new JTextField();
		lpseudo=new JTextField();
		aj = new JButton("Enregistrer");
		qt = new JButton("Quitter");
		aj.addActionListener(this);
		qt.addActionListener(this);
		pan1=new JPanel();
		pan2=new JPanel();
		pan1.setLayout(new GridLayout(4,2));
		pan1.add(pseudo);
		pan1.add(lprofil);
		pan1.add(profil);
		pan1.add(lpseudo);
		pan2.add(aj);
		pan2.add(qt);
		add(pan1,BorderLayout.CENTER);
		add(pan2,BorderLayout.SOUTH);
		setTitle("Création Personnage");
		setSize(500,200);
		setLocationRelativeTo(null);
		setVisible(true);
		try
		{
		socket= new Socket("localhost",8000);
		out = new DataOutputStream(socket.getOutputStream());
	    in = new DataInputStream(socket.getInputStream());
	    oos=new ObjectOutputStream(socket.getOutputStream());;
	    ois=new ObjectInputStream(socket.getInputStream());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==aj)
		{
			
			Personne p;
			 try
			 {
			 

		    	    oos.writeObject("ajout");
		        	oos.flush();
		        	String smatr=lprofil.getText();
		    		String nom=lpseudo.getText();
		    		p = new Personne ();
		    		p.setProfil(smatr);
		    		p.setPseudo(nom);
		    		oos.writeObject(p);
		    		oos.flush();
		    		lprofil.setText("");
		    		lpseudo.setText("");
		    		
			 }
			 
			 catch(Exception ex)
			 {
				 System.out.println(ex.getMessage());
			 }
		}
		
		
		
			else
				if (e.getSource()==qt)
				{
					try
					{
					 oos.writeObject("fin");
			    	 oos.flush();
			    	 socket.close();
					dispose();
					System.exit(0);
				    }
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}
				}	
	}
	public static void main(String args[])
	{
		new Personnage();
	 
     }
}