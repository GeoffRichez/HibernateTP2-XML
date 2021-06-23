package entities;

public class Entreprise implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int codeID;
	private String libelle;

	public Entreprise() {
	}

	@Override
	public String toString() {
		return "je suis l'entreprise avec codeID=" + codeID + ", libelle=" + libelle;
	}

	public Entreprise(int codeID, String libelle) {
		this.codeID = codeID;
		this.libelle = libelle;
	}

	public int getCodeID() {
		return codeID;
	}

	public void setCodeID(int codeID) {
		this.codeID = codeID;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
