package entities;

public class Client implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int clientId;
	private String nom;
	private String prénom;

	public Client() {
	} // Constructeur par défaut

	public Client(int clientId, String nom, String prénom) {
		this.clientId = clientId;
		this.nom = nom;
		this.prénom = prénom;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prenom) {
		this.prénom = prenom;
	}

	public String toString() {
		return "Je suis le client : " + clientId + " nommé : " + nom + " " + prénom;
	}
}
