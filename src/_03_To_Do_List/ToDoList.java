package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	public static JButton addTask = new JButton();
	public static JButton viewTasks = new JButton();
	public static JButton removeTask = new JButton();
	public static JButton saveList = new JButton();
	public static JButton loadList = new JButton();
	public static ArrayList<String> tasks = new ArrayList<String>();
	public static int counter = 0;
	
	public void createUI() {
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		addTask.setText("Add Task"); viewTasks.setText("View Tasks"); removeTask.setText("Remove Task"); saveList.setText("Save List"); loadList.setText("Load List");
		panel.add(addTask); panel.add(viewTasks); panel.add(removeTask); panel.add(saveList); panel.add(loadList);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		new ToDoList().createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addTask) {
			tasks.add(JOptionPane.showInputDialog("Add A New Task"));
		}
		else if(e.getSource() == viewTasks) {
			JOptionPane.showMessageDialog(null, tasks);
		}
		else if(e.getSource() == removeTask) {
			String remove = JOptionPane.showInputDialog("Which task do you wish to remove");
			for(int i = 0; i < tasks.size(); i++) {
				System.out.println("yeet");
				if(tasks.get(i).toLowerCase() == remove.toLowerCase()) {
					System.out.println("pog");
					tasks.remove(i);
				}
			}
		}
		else if(e.getSource() == saveList) {
			try {
				String fileName = ("src/_03_To_Do_List/test" + counter + ".txt");
				System.out.println(fileName);
				FileWriter writer = new FileWriter(fileName);
				for(int i = 0; i < tasks.size(); i++) {
				writer.write(tasks.get(i));
				}
				counter++;
				writer.close();
				}
				catch (IOException g) {
					g.printStackTrace();
				}
			tasks.removeAll(tasks);
		}
		else {
			String file = JOptionPane.showInputDialog("Insert File Name");
			loadFile(file);
		}
	}
	
	public void loadFile(String file) {
		try {
			@SuppressWarnings("resource")
			FileReader reader = new FileReader(file);
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
