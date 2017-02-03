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
		if (filtre.estVide())
			return donnee.estVide();

		if(filtre.elementCourant().equals("*")) {
		//if (filtre.premier().equals("*")) {
			int indiceFiltre = filtre.getIndice();
			int indiceDonnee = donnee.getIndice();
			System.out.println("indiceFiltre : " + indiceFiltre + " - indiceDonnee : " + indiceDonnee );
			filtre.passeALaSuite();
			// Filtre fReste = filtre.reste();
			// System.out.println("reste = " + fReste.elementCourant());
			// Appariement ap = new Appariement(fReste, donnee);
			if (this.correspondanceStructurelle()) {
				return true;
			}
			System.out.println("indiceFiltre : " + indiceFiltre + " - indiceDonnee : " + indiceDonnee );

			filtre.setIndice(indiceFiltre);
			donnee.setIndice(indiceDonnee);
			if (donnee.estVide())
				return false;
			donnee.passeALaSuite();
			return this.correspondanceStructurelle();
		}
		
		if (donnee.estVide())
			return false;
		
		if (filtre.elementCourant().equals("$")) {
			filtre.passeALaSuite();
			donnee.passeALaSuite();
			return this.correspondanceStructurelle();
		}

		System.out.println("elt courant : " + filtre.elementCourant() + " " + donnee.elementCourant());
		if (filtre.elementCourant().equalsIgnoreCase(donnee.elementCourant())) {
			filtre.passeALaSuite();
			donnee.passeALaSuite();
			return this.correspondanceStructurelle();
		} else
			return false;
	}

}

// début maVersion
// filtre.passeALaSuite();
//
// while(!donnee.elementCourant().equalsIgnoreCase(filtre.elementCourant())) {
// //System.out.println("ici " + filtre.elementCourant());
// donnee.passeALaSuite();
// if(donnee.estVide()) return false;
// return true;
// }
// fin ma version