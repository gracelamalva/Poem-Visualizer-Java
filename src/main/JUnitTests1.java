package main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class JUnitTests1 extends TestCase {
	
	String word = "orange";
	String [] words = new String[4];
	ArrayList<String> rhymes = new ArrayList<String>();
	
	private Poem poem;
	
	
	public JUnitTests1() {
		String text = "When I was down beside the sea \n" + 
				"A wooden spade they gave to me \n" + 
				"To dig the sandy shore. \n" + 
				"My holes were empty like a cup, \n" + 
				"In every hole the sea came up, \n" + 
				"Till it could no more.";
		try {
			poem = new Poem(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void testGetRhymes()
	{
		ArrayList<String> rhymesExpected = new ArrayList<>();
		rhymesExpected.add("orange");
		rhymesExpected.add("red-orange");
		rhymesExpected.add("yellow-orange");
		rhymesExpected.add("yellowish-orange");
		
		ArrayList<String> rhymesActual = poem.getRhymes("orange");
		
		assertEquals(rhymesExpected, rhymesActual);
	}
	
	@Test
	public void testCheckRhymes()
	{
		ArrayList<String> rhymesSet1 = new ArrayList<>();
		rhymesSet1.add("sea");
		rhymesSet1.add("me");
		rhymesSet1.add("up");
		ArrayList<String> rhymesSet2 = new ArrayList<>();
		rhymesSet2.add("shore");
		rhymesSet2.add("more");
		ArrayList<ArrayList<String>> rhymesExpected = new ArrayList<>();
		rhymesExpected.add(rhymesSet1);
		rhymesExpected.add(rhymesSet2);
		
		ArrayList<ArrayList<String>> rhymesActual = poem.checkRhymes(poem.getWords());
		
		assertEquals(rhymesExpected, rhymesActual);
		
	}
}
