package main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

	InputHandler iHandler = new InputHandler();
	GUI gui = new GUI();
	VisibilityManager vs = new VisibilityManager(gui);

	//Poem Bank Object
	PoemBank pb = new PoemBank();
	
	public static void main(String[] args) {
		
		new App();
		
	}
	
	public App() {
		gui.createGUI(iHandler);
		vs.showMainScreen();
	}
	
	public class InputHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			
			switch(input) {
			case "profile" : vs.showProfileScreen();
			break;
			
			case "home" : vs.showMainScreen();
			break;
			
			//add the user's input to the poem bank arraylist
			case "submit" : vs.showProfileScreen();
			pb.getPoemBank().add(gui.getInput());
			
			//print to console
			System.out.println(pb.getPoemBank().get(pb.getPoemBank().size() - 1));
			break;
			}
		}
	}
	
}
