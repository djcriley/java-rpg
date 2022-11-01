package starter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Narrative {
	
	private static ArrayList<String> lines;
	private static String line;

	public static void print(String arg) throws IOException {
		if (arg == "NPC-1")
			NPC();
	}
	
	public static ArrayList<String> sendString() {
		return lines;
	}

	private static void NPC() throws IOException {
		InputStream stream = Narrative.class.getResourceAsStream("/text/NPC");
		if (stream == null) JOptionPane.showMessageDialog(null, "Resource not located.");
		Scanner input = null;
		lines = new ArrayList<String>();
		try {
			input = new Scanner (stream);
			boolean tokenFound = false;
			while (input.hasNextLine()) {
				line = input.nextLine().trim();

				if (line.equals("NPC-1-START")) {
					tokenFound = true;
				} 
				else if (line.equals("NPC-1-END")) {
					tokenFound = false;
				}

				//Prints female-male section
				if ((tokenFound) && (!line.equals("NPC-1-START"))) {
					lines.add(line);
					MainApplication.speech = sendString();
				}
			}
		} 

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Scanner error");
		}

		while (input.hasNextLine()) 
			JOptionPane.showMessageDialog(null, input.nextLine());
	}
}