package fr.demos.virtualturing.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import fr.demos.virtualturing.util.Lecteur;

public class VirtualTuring {

	private List<String> universDuDiscoursBase = new ArrayList<String>();
	private HashMap<String, List<String>> universDuDiscours;
	private String nom;

	public VirtualTuring(String nom) {
		this.nom = nom;
//		universDuDiscours.add("Parlez-moi de vous");
//		universDuDiscours.add("Parlez-moi de lui");
//		universDuDiscours.add("Parlez-moi d'elle");

		universDuDiscours = new HashMap();
		
		universDuDiscours.put("* mère *", new ArrayList(Arrays.asList("Parlez-moi de vos parents",
				"Et votre père ?")));
		
		universDuDiscours.put("* mal *", new ArrayList(Arrays.asList("Ca ne va pas bien ?",
				"A ce point ?")));
		
		universDuDiscours.put("*", new ArrayList(Arrays.asList("Revenons à vous",
				"Parlez-moi de vos passions")));
		
		
	}

	
	
	public void dialogue() {
		String ligneLue;
		
		
		while (true) {
			System.out.print(nom + " : ");
			ligneLue = Lecteur.lireLigne();
			if (ligneLue.equalsIgnoreCase("fin"))
				break;

		System.out.println("Machine : " + this.reponseConstante(ligneLue));
				

		}
	}

	public String reponseConstante(String ligneLue) {
		String filtre1 = "Bonjour $";
					
		Filtre monFiltre = new Filtre(Lecteur.String2Liste(filtre1));
		Donnee maDonnee = new Donnee(Lecteur.String2Liste(ligneLue));
		
		Appariement ap = new Appariement(monFiltre, maDonnee);
		
		String phraseChoisie = "";
		
		Iterator it = universDuDiscours.keySet().iterator();
		while(it.hasNext()) {
			filtre1 = (String) it.next();
			monFiltre = new Filtre(Lecteur.String2Liste(filtre1));
			ap = new Appariement(monFiltre, maDonnee);
			
			if(ap.correspondanceStructurelle()) {
				int nb;
				
				nb = (int) (Math.random() * universDuDiscours.size());
				phraseChoisie = universDuDiscoursBase.get(nb);
				System.out.println("Virtual Turing : " + phraseChoisie);
				//return phraseChoisie;
				break;
			}
			
		}
		
		return phraseChoisie;
		
	}
	

	private String reponseMachine() {
		int nb;
		String phraseChoisie = "";
		nb = (int) (Math.random() * universDuDiscours.size());
		phraseChoisie = universDuDiscoursBase.get(nb);
		System.out.println("Virtual Turing : " + phraseChoisie);
		return phraseChoisie;
	}

}
