package presentation;

import java.net.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import entities.*;
public class Client extends JFrame implements ActionListener 
{
	private JLabel lpseudo,lprofil,lcapacite;
	private JButton aj,qt,aff;
	private JPanel pan1,pan2;
	private Socket socket;
	DataOutputStream out;
	DataInputStream in;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    
    
	public Client() 
	{
		qt = new JButton("Quitter");
		aff= new JButton("Afficher");
		aff.addActionListener(this);
		qt.addActionListener(this);
		pan1=new JPanel();
		pan2=new JPanel();
		pan1.setLayout(new GridLayout(4,2));
		pan2.add(aff);
		pan2.add(qt);
		add(pan1,BorderLayout.CENTER);
		add(pan2,BorderLayout.SOUTH);
		setSize(500,200);
		setLocationRelativeTo(null);
		setVisible(true);
		try
		{
		socket= new Socket("10.7.222.252",40000);
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
		/////utiser cette condition pour acceder � la page d'acceuil
			
			if (e.getSource()==aff)
			{
				try
				{
					oos.writeObject("2");	
			         oos.flush();
			         //System.out.println(ois.readObject());
			         List<Personnage> liste=(List<Personnage>)ois.readObject();
			         new ListePersonnage(liste);
			         //for (Personnage personnage : liste) {
					//	System.out.println(personnage.getPseudo() + " " + personnage.getCapacite().getNombreVie() + " "+ personnage.getProfil().getDescription()  + " "+ personnage.getProfil().getTypeAttaque().getDescription());
					//}
			        
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		/////utiser cette condition a la page d'acceuil
			
			
			
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
		new Client();
	 
     }
}