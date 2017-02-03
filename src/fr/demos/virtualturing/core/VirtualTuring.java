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
		
		universDuDiscours.put("* mal", new ArrayList(Arrays.asList("Ca ne va pas bien ?",
				"A ce point ?")));
		
		universDuDiscours.put("*", new ArrayList(Arrays.asList("Revenons à vous",
				"Parlez-moi de vos passions")));
		
		universDuDiscours.put("Bonjour $", new ArrayList(Arrays.asList("Revenons à vous",
				"Parlez-moi de vos passions")));
		
		universDuDiscours.put("* que je", new ArrayList(Arrays.asList("Que revenons à vous",
				"Que parlez-moi de vos passions")));
		
		
		
		
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
		//String filtre1 = "Bonjour";
					
		Filtre monFiltre;
		Donnee maDonnee = new Donnee(Lecteur.String2Liste(ligneLue));
		
		Appariement ap;
		
		String phraseChoisie = "";
		
				
		Iterator it = universDuDiscours.keySet().iterator();
		while(it.hasNext()) {
			String pos = (String) it.next();
			String filtre1 = pos;
			monFiltre = new Filtre(Lecteur.String2Liste(filtre1));
			ap = new Appariement(monFiltre, maDonnee);
			
			if(ap.correspondanceStructurelle()) {
				//System.out.println("ok " + monFiltre.elementCourant());
				int nb = 0;				
				nb = (int) (Math.random() * universDuDiscours.get(pos).size());
				//System.out.println("nb = " + nb + " size = " + universDuDiscours.size());
				phraseChoisie = universDuDiscours.get(pos).get(nb);
				//System.out.println("Virtual Turing : " + phraseChoisie);
				//return phraseChoisie;
				break;
			}
			maDonnee.setIndice(0);
		}
		
		
		
		
//		if(ap.correspondanceStructurelle()) {
//			phraseChoisie = "ap ok";
//		} else {
//			phraseChoisie = "non ok";
//		}
			
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



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
}
