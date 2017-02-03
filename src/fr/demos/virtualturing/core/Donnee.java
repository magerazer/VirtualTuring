package fr.demos.virtualturing.core;

import java.util.ArrayList;
import java.util.List;

public class Donnee extends Element {

	public Donnee(List<String> contenu) {
		super(contenu);
		
	}
	
	public Donnee reste() {
		Donnee f = new Donnee(contenu);
		f.getContenu().remove(0);
		return f;
	}

}
