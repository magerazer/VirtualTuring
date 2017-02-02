package fr.demos.virtualturing.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fr.demos.virtualturing.util.Lecteur;

public class Appariement {
	
	private Filtre filtre;
	private Donnee donnee;
	
	

	public Appariement(Filtre unFiltre, Donnee uneDonnee) {

		filtre = unFiltre;
		donnee = uneDonnee;
			
		
	} 
	
	public boolean correspondanceStructurelle() {
		if(filtre.estVide())
			return donnee.estVide();
		if(donnee.estVide())
			return false;
		if(filtre.elementCourant().equals("$")) {
			filtre.passeALaSuite();
			donnee.passeALaSuite();
			return true;
		}
		if(filtre.elementCourant().equalsIgnoreCase(donnee.elementCourant())) {
			filtre.passeALaSuite();
			donnee.passeALaSuite();
			return this.correspondanceStructurelle();
		}
		else return false;			
	}
	
	
	
		
	
}
