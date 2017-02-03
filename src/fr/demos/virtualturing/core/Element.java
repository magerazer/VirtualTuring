package fr.demos.virtualturing.core;

import java.util.ArrayList;
import java.util.List;

public class Element {

	protected List<String> contenu;
	protected int indice;
	
	public Element(List<String> contenu) {
		this.contenu = contenu;
		indice = 0;
	}
	
	public boolean estVide() {
		return indice >= contenu.size();
	}
	
	public void passeALaSuite() {
		indice++;
	}
	
	public String elementCourant() {
		if(this.estVide())
			return null;
		return contenu.get(indice);
	}
	
	public String premier() {
		return contenu.get(0);
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
