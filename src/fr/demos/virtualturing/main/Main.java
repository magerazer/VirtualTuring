package fr.demos.virtualturing.main;

import fr.demos.virtualturing.core.VirtualTuring;
import fr.demos.virtualturing.util.Lecteur;

public class Main {

	public static void main(String[] args) {
		
		VirtualTuring robot = new VirtualTuring("Mag");
		
		//robot.dialogue();
		
		String ligneLue;
		
		
		
		while (true) {
			System.out.print(robot.getNom() + " : ");
			ligneLue = Lecteur.lireLigne();
			if (ligneLue.equalsIgnoreCase("fin"))
				break;

			System.out.println("Machine : " + robot.reponseConstante(ligneLue));
		}
		
	}

}
