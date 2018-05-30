package entites;

import java.io.Serializable;

public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Pseudo;
	private String Profil;
	
	public String getPseudo() {
		return Pseudo;
	}
	public void setPseudo(String pseudo) {
		this.Pseudo = pseudo;
	}
	public String getProfil() {
		return Profil;
	}
	public void setProfil(String profil) {
		this.Profil = profil;
	}
	
}
