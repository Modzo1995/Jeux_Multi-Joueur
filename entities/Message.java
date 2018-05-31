import java.io.Serializable;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int type;
	private Object donne;
	
	public Message(int type, Object donne) {	
		this.type = type;
		this.donne = donne;
	}
}
