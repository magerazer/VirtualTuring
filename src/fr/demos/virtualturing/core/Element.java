package fr.demos.virtualturing.core;

import java.util.ArrayList;
import java.util.List;

public class Element {

	private List<String> contenu;
	private int indice;
	
	public Element(ArrayList<String> contenu) {
		this.contenu = contenu;
		indice = 0;
	}
	
	public boolean estVide() {
		return indice == contenu.size();
	}
	
	public void passeALaSuite() {
		indice++;
	}
	
	public String elementCourant() {
		if(this.estVide()) return null;
		return contenu.get(indice);
	}
	
	
	

	public List getContenu() {
		return contenu;
	}

	public void setContenu(List contenu) {
		this.contenu = contenu;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	
	
	
}
