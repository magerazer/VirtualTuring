package fr.demos.virtualturing.core;

import java.util.ArrayList;
import java.util.List;

public class Filtre extends Element {

	public Filtre(List<String> contenu) {
		super(contenu);
		
	}
	

	public Filtre reste() {
		Filtre f = new Filtre(contenu);
		f.getContenu().remove(0);
		
		return f;
	}

}
