package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String [] args) {
		try {
		FileWriter writer = new FileWriter("src/_01_File_Recorder/test.txt");
		String s = JOptionPane.showInputDialog("What shift?");
		int shift = Integer.parseInt(s);
		
		String message = JOptionPane.showInputDialog("What would you like to write?");
		String shiftedMessage = "";
		for(int i = 0; i < message.length(); i++) {
			for(int j = 0; j < alphabet.length(); j++) {
			 if(message.charAt(i) == alphabet.charAt(j)) {
				 shiftedMessage += alphabet.charAt(j+shift);
			 }
			}
		}
		
		writer.write(shiftedMessage);
		writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			@SuppressWarnings("resource")
			FileReader reader = new FileReader("src/_01_File_Recorder/test.txt");
			int c = reader.read();
			while(c != -1){
				System.out.print((char)c);
				c = reader.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
