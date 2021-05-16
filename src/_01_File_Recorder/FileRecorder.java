package _01_File_Recorder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main(String [] args) {
		try {
		FileWriter writer = new FileWriter("src/_01_File_Recorder/test.txt");
		writer.write(JOptionPane.showInputDialog("What would you like to write?"));
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
