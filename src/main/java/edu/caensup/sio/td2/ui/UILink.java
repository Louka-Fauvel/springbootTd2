package edu.caensup.sio.td2.ui;

public class UILink {

	private String libelle;
	private String href;
	
	public UILink(String href) {
		this("", href);
	}
	
	public UILink(String libelle, String href) {
		
		this.libelle = libelle;
		this.href = href;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}
