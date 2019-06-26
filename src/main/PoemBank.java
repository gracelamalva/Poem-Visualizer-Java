package main;

import java.io.IOException;
import java.util.ArrayList;

public class PoemBank {
	
	Poem p;
	int johnRCount;
	int bettyRCount;
	int jasonRCount;
	int renaRCount;
	int noahRCount;
	int emmaRCount;
	int alexRCount;
	int lindaRCount;

	private ArrayList<String> poemBank = new ArrayList<String>();
	
	//Poems
	String johnPoem = "Hi my name is John and Im here to say, I love poetry in a major way";
	String bettyPoem = "My name's Betty and Im here to say, I poetry, have a nice day";
	String jasonPoem = "Hi im Jason and Im a mason, im not lazy and I am not crazy";
	String renaPoem = "My names Rena and im here to say, I dont like poetry in a major way";
	String noahPoem = "Hi im Noah and I love poetry, and I like to fly and I have an eye";
	String emmaPoem = "Hello im Emma I eat a lime and I am bad at poetry, I dont have much time";
	String alexPoem = "My names Alex and I like to play a game I am not lame";
	String lindaPoem = "Hi im Linda and I am super cool I like to swim in a cold pool";
	
	public PoemBank() {
		poemBank.add(johnPoem);
		poemBank.add(bettyPoem);
		poemBank.add(jasonPoem);
		poemBank.add(renaPoem);
		poemBank.add(noahPoem);
		poemBank.add(emmaPoem);
		poemBank.add(alexPoem);
		poemBank.add(lindaPoem);
		
		//run rhyme checker on all of the poems
		/*
		johnRCount = checkPoem(johnPoem);
		bettyRCount = checkPoem(bettyPoem);
		jasonRCount = checkPoem(jasonPoem);
		renaRCount = checkPoem(renaPoem);
		noahRCount = checkPoem(noahPoem);
		emmaRCount = checkPoem(emmaPoem);
		alexRCount = checkPoem(alexPoem);
		lindaRCount = checkPoem(lindaPoem); */
		System.out.println(johnRCount + "" + bettyRCount + "" + jasonRCount + "" + renaRCount + "" + noahRCount + "" + emmaRCount + "" + alexRCount + "" + lindaRCount);
	}
	
	public ArrayList<String> getPoemBank() {
		return poemBank;
	}
	
	//return poem
	public String getPoem(int id) {
		
		switch (id) {
		case 0 : return johnPoem;
	
		case 1 : return bettyPoem;
	
		case 2 : return jasonPoem;

		case 3 : return renaPoem;

		case 4 : return noahPoem;

		case 5 : return emmaPoem;
		case 6 : return alexPoem;
		case 7 : return lindaPoem;
		default : return "";
		}
		
	}
	
	public int checkPoem(String poem) {
			
		//create lines array list
		ArrayList<String> lines = new ArrayList<String>();
		
		//initialize poem object with userInput as parameter
		try {
			p = new Poem(poem);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//create a nested for loop that highlights each string value in the rhyme arrayList
		ArrayList<ArrayList<String>> rhymeList = p.getRhymeList();
		
		int count = 0;
		for (int i = 0; i < rhymeList.size(); i++) {
			for (int k = 0; k < rhymeList.get(i).size(); k++) {
				
				count++;
				
			}
		}
		return count;
		}
	
	//return the poem's name
	public String getPoemName(int id) {
		String poemName = "Poem";
		
		switch (id) {
		case 0 : poemName = "John's Poem";
		break;
		case 1 : poemName = "Betty's Poem";
		break;
		case 2 : poemName = "Jason's Poem";
		break;
		case 3 : poemName = "Rena's Poem";
		break;
		case 4 : poemName = "Noah's Poem";
		break;
		case 5 : poemName = "Emma's Poem";
		break;
		case 6 : poemName = "Alex's Poem";
		break;
		case 7 : poemName = "Linda's Poem";
		break;
		}
		return poemName;
	}
	
	public int getRCount(int id) {
		switch (id) {
		case 0 : return johnRCount;
		
		case 1 : return bettyRCount;
	
		case 2 : return jasonRCount;

		case 3 : return renaRCount;

		case 4 : return noahRCount;

		case 5 : return emmaRCount;
		case 6 : return alexRCount;
		case 7 : return lindaRCount;
		default: return 0;
		}
	}
	 
}
