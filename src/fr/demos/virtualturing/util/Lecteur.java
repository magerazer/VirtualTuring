package fr.demos.virtualturing.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lecteur {

	public static String lireLigne() {
		String ligneLue = null;
		try {
			DataInputStream consoleEnLecture;
			consoleEnLecture = new DataInputStream(System.in);
			ligneLue = consoleEnLecture.readLine();
		} catch (IOException e) {
		}
		return ligneLue;
	}

	public static ArrayList<String> String2Liste(String str) {
		StringTokenizer st = new StringTokenizer(str);
		ArrayList<String> l = new ArrayList();
		while (st.hasMoreTokens()) {
			l.add(st.nextToken());
		}
		return l;
	}

}
