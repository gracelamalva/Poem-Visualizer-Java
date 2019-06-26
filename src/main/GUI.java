package main;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import main.App.InputHandler;


public class GUI {
	
	//Poem object
	Poem poem;
	
	//PoemBank object
	PoemBank poemBank = new PoemBank();
	
	//HighLighter Object
	HighLighter hLighter = new HighLighter();
	
	//Poem that gets submitted
	String userInput = "";
	
	//Profile Object
	Profiles profiles = new Profiles();
	
	//Main Frame
	JFrame window;
	
	//Main Screen panels
	JPanel mainPanel;
	JPanel poemPanel;
	
	//Main Screen Components
	JButton submitBtn, profileBtn;
	JLabel intro;
	JTextArea poemArea;
	JScrollPane scroll;
	
	//profile screen panel
	JPanel profilePanel;
	
	//Profile Screen Components
	JPanel infoPanel;
	JLabel name, genre, location;
	
	//poem list panel
	JPanel poemListPanel;
	JLabel poemListLabel;
	JList poemList;
	JButton openPoemBtn;
	DefaultListModel<String> poemListModel;
	
	//social panel
	JPanel socialPanel;
	JLabel socialLabel;
	JList profileList;
	JButton searchProfileBtn;
	JScrollPane profileListScroll;
	DefaultListModel<String> profileListModel;
	
	//profile poem area panel
	JPanel profilePoemPanel;
	JTextArea profilePoemArea;
	JScrollPane profilePoemScroll;
	JButton homeBtn;
	
	//Fonts
	Font XLargeFont = new Font("serif", Font.PLAIN, 62);
	Font largeFont = new Font("serif", Font.PLAIN, 42);
	Font normalFont = new Font("serif" , Font.PLAIN, 24);

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createGUI(InputHandler iHandler) {
		
		//create window frame
		window = new JFrame();
		
		//HOME SCREEN MAIN PANEL
		mainPanel = new JPanel();
		
		poemPanel = new JPanel();
		poemPanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Poem Area" ) );
		mainPanel.setLayout(new BorderLayout());
		poemPanel.setLayout(new BorderLayout());
		
		submitBtn = new JButton("Submit");
		//submit btn interaction
		submitBtn.addActionListener(iHandler);
		submitBtn.setActionCommand("submit");
		
		intro = new JLabel("Type, or copy and paste a song or poem into the text area:");
		intro.setFont(normalFont);
		submitBtn.setFont(normalFont);
		
		//submitBtn highlighting
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//make sure the userInput is set to the submitted poem
				userInput = poemArea.getText();
				
				//First set the text of profilePoemArea to the submitted poem
				profilePoemArea.setText(userInput);
				
				//create lines array list
				ArrayList<String> lines = new ArrayList<String>();
				
				//initialize poem object with userInput as parameter
				try {
					poem = new Poem(userInput);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int count = 0;
				//create a nested for loop that highlights each string value in the rhyme arrayList
				ArrayList<ArrayList<String>> rhymeList = poem.getRhymeList();
				
				for (int i = 0; i < rhymeList.size(); i++) {
					for (int k = 0; k < rhymeList.get(i).size(); k++) {
						
						//Highlight the text in the profilePoemArea
						hLighter.highlight(profilePoemArea, rhymeList.get(i).get(k));
						count++;
						
					}
				}
				
				//Create popup window based on rhyme number
				String message = "You had " + count + " rhymes!";
				if (count < 2) {
					message = "You had " + count + " rhymes. You had the least rhymes!";
				} else if (count > 2 && count < 4) {
					message = "You had " + count + " rhymes. You had more rhymes than Betty, Rena, and Emma!";
				} else if (count > 4 && count < 6) {
					message = "You had " + count + " rhymes. You had more rhymes than Betty, Rena, Emma, John, Jason, and Alex!";
				} else if (count > 5 &&  count < 7) {
					message = "You had " + count + " rhymes. You had more rhymes than Betty, Rena, Emma, John, Jason, Alex, and Linda!";
				} else if (count > 6){
					message = "You had " + count + " rhymes. You had the most rhymes out of everyone!";
				}
				
				createWindow(message);
				
			}
			
		});
		
		poemArea = new JTextArea();
		poemArea.setFont(normalFont);
		poemArea.setWrapStyleWord(true);
		poemArea.setLineWrap(true);
		
		//Profile Button
		profileBtn = new JButton("Profile");
		profileBtn.setFont(normalFont);
		//input handling
		profileBtn.addActionListener(iHandler);
		profileBtn.setActionCommand("profile");
		
		//scroll bar
		scroll = new JScrollPane(poemArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
	    //add components
		poemPanel.add(intro, BorderLayout.NORTH);
		poemPanel.add(scroll, BorderLayout.CENTER);
		
		mainPanel.add(profileBtn, BorderLayout.NORTH);
		mainPanel.add(poemPanel, BorderLayout.CENTER);
		mainPanel.add(submitBtn, BorderLayout.SOUTH);
		
		
		//PROFILE SCREEN PANEL
		//Profile Panel
		profilePanel = new JPanel(new BorderLayout());
		
		//Info Panel
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setBorder(new TitledBorder ( new EtchedBorder (), "Info" ));
		//name label
		name = new JLabel("Name");
		name.setFont(largeFont);
		name.setVerticalAlignment(JLabel.CENTER);
		name.setHorizontalAlignment(JLabel.CENTER);
		
		//location label
		location = new JLabel("Location");
		location.setFont(normalFont);
		location.setVerticalAlignment(JLabel.CENTER);
		location.setHorizontalAlignment(JLabel.CENTER);
		
		//genre label
		genre = new JLabel("Genre");
		genre.setFont(normalFont);
		genre.setVerticalAlignment(JLabel.CENTER);
		genre.setHorizontalAlignment(JLabel.CENTER);
		
		//PoemList Panel
		poemListPanel = new JPanel(new BorderLayout());
		poemListPanel.setBorder(new TitledBorder ( new EtchedBorder (), "Poems" ));
		//Poem list label
		poemListLabel = new JLabel("Poems");
		poemListLabel.setFont(largeFont);
		poemListLabel.setVerticalAlignment(JLabel.CENTER);
		
		//Poem list Model
		poemListModel = new DefaultListModel<String>();
		
		//make sure to initialize the list after inizitializing the model
		poemList = new JList(poemListModel);
		poemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		poemList.setLayoutOrientation(JList.VERTICAL);
		
		//add the profile's poems to the side poem list
		for (int i = 0; i < 8; i++) {
		poemListModel.addElement(poemBank.getPoemName(i));
		}
		
		
		//openPoemBtn
		openPoemBtn = new JButton("Open");
		openPoemBtn.setFont(normalFont);
		
		//openPoemBtn action listener
		openPoemBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//set the poemname to whatever index the user selected
				//the index is the same number as the profile's id number
				int pos = poemList.getSelectedIndex();
				
				profilePoemArea.setText(poemBank.getPoem(pos));
				
				//Highlighting
				//create lines array list
				ArrayList<String> lines = new ArrayList<String>();
				
				//initialize poem object with userInput as parameter
				try {
					poem = new Poem(profilePoemArea.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//create a nested for loop that highlights each string value in the rhyme arrayList
				ArrayList<ArrayList<String>> rList = poem.getRhymeList();
				
				for (int i = 0; i < rList.size(); i++) {
					for (int k = 0; k < rList.get(i).size(); k++) {
						
						//Highlight the text in the profilePoemArea
						hLighter.highlight(profilePoemArea, rList.get(i).get(k));
						
					}
				}
				
			}
			
		});
		
		//Social Panel
		socialPanel = new JPanel(new BorderLayout());
		socialPanel.setBorder(new TitledBorder ( new EtchedBorder (), "Social" ));
		//social label
		socialLabel = new JLabel("Social");
		socialLabel.setFont(largeFont);
		socialLabel.setVerticalAlignment(JLabel.CENTER);
				
		//Profile List model
		profileListModel = new DefaultListModel<String>();
		profileListModel.addElement(profiles.getFName(0) + " " + profiles.getLName(0));
		profileListModel.addElement(profiles.getFName(1) + " " + profiles.getLName(1));
		profileListModel.addElement(profiles.getFName(2) + " " + profiles.getLName(2));
		profileListModel.addElement(profiles.getFName(3) + " " + profiles.getLName(3));
		profileListModel.addElement(profiles.getFName(4) + " " + profiles.getLName(4));
		profileListModel.addElement(profiles.getFName(5) + " " + profiles.getLName(5));
		profileListModel.addElement(profiles.getFName(6) + " " + profiles.getLName(6));
		profileListModel.addElement(profiles.getFName(7) + " " + profiles.getLName(7));
		
		//profile list
		profileList = new JList(profileListModel);
		profileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		profileList.setLayoutOrientation(JList.VERTICAL);
		
		//Profile List ScrollBar
		profileListScroll = new JScrollPane(profileList);
		profileListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
		//search profile button
		searchProfileBtn = new JButton("Search");
		searchProfileBtn.setFont(normalFont);
		
		//add action listener to search button
		searchProfileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//set the info to whatever index the user selected
				//the index is the same number as the profile's id number
				int index = profileList.getSelectedIndex();
				
				//set info
				name.setText(profiles.getFName(index) + " " + profiles.getLName(index));
				location.setText(profiles.getLocation(index));
				genre.setText(profiles.getGenre(index));
				
				
			}
		});
		
		
		//Profile Poem Panel
		profilePoemPanel = new JPanel();
		profilePoemPanel.setLayout(new BorderLayout());
		//Poem Display 
		profilePoemArea = new JTextArea();
		profilePoemArea.setFont(normalFont);
		profilePoemArea.setWrapStyleWord(true);
		profilePoemArea.setLineWrap(true);
		//Make sure user cant edit the text area
		profilePoemArea.setEditable(false);
		
		//scroll bar
		profilePoemScroll = new JScrollPane(profilePoemArea);
		profilePoemScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Home Button
		homeBtn = new JButton("Home");
		homeBtn.setFont(normalFont);
		//input handling
		homeBtn.addActionListener(iHandler);
		homeBtn.setActionCommand("home");
		
		//Add components to profile poem panel
		//only have to add the scroll bar
		profilePoemPanel.add(profilePoemScroll, BorderLayout.CENTER);
		
		//Add components to social panel
		socialPanel.add(socialLabel, BorderLayout.NORTH);
		socialPanel.add(profileListScroll, BorderLayout.CENTER);
		socialPanel.add(searchProfileBtn, BorderLayout.SOUTH);
		
		//Add components to info panel
		infoPanel.add(name, BorderLayout.NORTH);
		infoPanel.add(location, BorderLayout.CENTER);
		infoPanel.add(genre, BorderLayout.SOUTH);
		
		//Add components to poem list panel
		poemListPanel.add(poemListLabel, BorderLayout.NORTH);
		poemListPanel.add(poemList, BorderLayout.CENTER);
		poemListPanel.add(openPoemBtn, BorderLayout.SOUTH);
		
		//Add subpanels to profile panel
		profilePanel.add(infoPanel, BorderLayout.NORTH);
		profilePanel.add(poemListPanel, BorderLayout.WEST);
		profilePanel.add(socialPanel, BorderLayout.EAST);
		profilePanel.add(profilePoemPanel, BorderLayout.CENTER);
		profilePanel.add(homeBtn, BorderLayout.SOUTH);
		
		
		window.add(mainPanel);
		window.setSize(800, 800);
		window.setTitle("Poem Visualizer");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	//create window
	public void createWindow(String message) {
		JFrame frame = new JFrame();
		JTextArea note = new JTextArea(message);
		note.setEditable(false);
		note.setFont(normalFont);
		note.setWrapStyleWord(true);
		
		frame.add(note);
		frame.setSize(600, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//returns the user poem input
	public String getInput() {
		userInput = poemArea.getText();
		return userInput;
	}

}
