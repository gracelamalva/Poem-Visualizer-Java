package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Poem 
{
	
    String text;
    
    int lineNum;
    int wordNum;

    public String [] lines = new String [lineNum]; //4
    public String [] words = new String [wordNum];
    
    ArrayList <String> lines1 = new ArrayList<String>();
    
    //WIP
    ArrayList<ArrayList<String>> RL;
   
    public Poem (String text) throws IOException {
    	initialize(text);
    }
    
    private void initialize(String s) {
    	
    	String[] tempWords = s.split("\\s+");
    	String[] words = new String[tempWords.length];
    	for (int i = 0; i < tempWords.length; i++) {
    		words[i] = tempWords[i].toLowerCase();
    	}
    	
    	int wordsCount = getWordCount2(words);
    	this.words = words;
    	
    	this.wordNum = words.length;
    	
    	String text = getText(s);
    	setText(text);
    	
    	ArrayList<String> lines = getLines(s);
    	setLines(lines);
    	int linesCount = getLineCount();
    	this.lineNum = linesCount;
    	
    	setLineCount(linesCount);
    	/*
    	System.out.println(getLineCount(lines));
    	for(int i = 0; i <words.length; i++)
    		System.out.println(words[i]);
    	System.out.println(getWordCount());
    	System.out.println(text);
    	System.out.println(lines);
    	
    	*/
    	RL = checkRhymes(this.words);
    }
    
    //return the nested arrayList "RL" of rhyme pairs
    public ArrayList<ArrayList<String>> getRhymeList() {
    	return RL;
    }
    
    public ArrayList<ArrayList<String>> checkRhymes (String [] w)
    {
    	String[] words = Arrays.copyOf(this.words, this.words.length);
    	
    	
    	ArrayList<ArrayList<String>> rhymeList = new ArrayList<>();
    	
    	// [
    	// {there, beware, care},
    	// {can, man, fan},
    	// {potato, tomato}
    	// ]
    	
    	for (int i = 0; i < words.length; i++)
    	{
    		if (!words[i].equalsIgnoreCase("a")) {
    		System.out.println("Before: " + words[i]);
			String temp = words[i].replaceAll("[^a-zA-Z]", "");
			words[i] = temp.replaceAll(",", "");
			System.out.println("After: " + words[i]);
			
        	ArrayList<String> wordRhymes = new ArrayList<String>(); 
        	wordRhymes.add(words[i]);
    		ArrayList<String> rhymes = getRhymes(words[i]); // In -> there, Out -> {there, beware, hair}
    		
    		for (int j = i + 1; j < words.length; j++) {
    			if (!words[j].equalsIgnoreCase("a")) {
    			temp = words[j].replaceAll("[^a-zA-Z]", "");
    			words[j] = temp.replaceAll(",", "").toLowerCase();
    			if (rhymes.contains(words[j].toLowerCase()) && !words[i].equalsIgnoreCase(words[j])) {
    				wordRhymes.add(words[j]);
    				System.out.println("We found a rhyming word with " + words[i] + ", it is " + words[j]);
    				words[j] = " ";
    			}
    			}
    		}
    		
    		if (wordRhymes.size() > 1) {
    			rhymeList.add(wordRhymes);
    		}
    		
    		System.out.println(wordRhymes);
    		}
    	}
    	
    	System.out.println(rhymeList);
    	return rhymeList;
    }
    
    public ArrayList<ArrayList<String>> checkAlliteration (String [] s)
    {
    	String[] words = Arrays.copyOf(this.words, this.words.length);
    	ArrayList<ArrayList<String>> alitList = new ArrayList<>();
    	
    	for (int i = 0; i < words.length; i++)
    	{
    		ArrayList<String> wordsAlit = new ArrayList<String>(); 
    		wordsAlit.add(words[i]);
    		for (int j= i +1; j<words.length; j++ )
    		{
				if ((words[i].charAt(0) == (words[j].charAt(0)) && j == i+1)) 
				{
					
					for (int k = j +1 ; k < words.length; k++)
					{
						
						if ((words[j].charAt(0) == (words[k].charAt(0)) && k == j+1))
						{
							System.out.println("Theres alit its " + words[i].charAt(0) + " in " + words[i] + " and "
									+ words[j].charAt(0) + " in " + words[j] + " and " + words[k].charAt(0) + " in "  + words[k]);
							wordsAlit.add(words[k]);
							words[k]= " ";
						}
					}
				
			//		System.out.println("Theres alit its" + words[0].charAt(0) + " in " + words[i] + " and "
			//				+ words[j].charAt(0) + " in " + words[j]);
					
			wordsAlit.add(words[j]);
				words[j] = " ";
					
				} else if ((words[i].substring(0,1) == "ce") && (words[j].charAt(0) == 's')) {
					
					System.out.println("Theres alit its" + words[i].charAt(0) + " in " + words[i] + " and "
							+ words[j].charAt(0) + " in " + words[j]);
					wordsAlit.add(words[i]);
					wordsAlit.add(words[j]);
				}
			
			}
    		
			if (wordsAlit.size() > 2) {
				alitList.add(wordsAlit);
			}
    		System.out.println(wordsAlit);

    		
    	}	
    		
    	System.out.println(alitList);
    	return alitList;
    }
    
    public static String createString(ArrayList<String> words) {
    	String string = "";
    	
    	for (String s : words) {
    		string += s + " ";
    	}
    	
    	return string.trim();
    }
    
    public int getWordCount2(String[] words) {
    	return getWords().length;
    }
    
    public ArrayList<String> getLines (String text)
    {
    	String[] lines = text.split("\n");
    	
    	ArrayList<String> resultLines = new ArrayList<>();
    	for (String line : lines) {
    		resultLines.add(line);
    	}
    	setLineCount(resultLines.size());
    	return resultLines;
    }

    public int getLineCount()
    {
    	return lineNum;
    	
    }
    
    public String getText(String s)
    {
        return s;
    }

    public String[] getWords ()
    {
        return words;
    }
    
    public int getWordCount() {
    	return wordNum;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }

    
    public void setLines (ArrayList<String> lines)
    {
        this.lines1 = lines;
    }
   
    public void setWords(String [] words)
    {
        this.words = words;
    }

    
    public void setLineCount(int c)
    {
    	this.lineNum = c;
    }

    
    public ArrayList<String> getRhymes(String word) {
    	//String output = "";
    	String APIKey = "";
    	 ArrayList<String> rhymes = new ArrayList<>();
    	 try {
    		 
    		 HttpResponse<JsonNode> request = Unirest.get("https://wordsapiv1.p.mashape.com/words/" +
    				 word+ "/rhymes").header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
    				 .header("Content-Type", "application/x-www-form-urlencoded")
    				 .header("X-Mashape-Key", APIKey)
    				 .asJson();
    		     		 
    		 JsonNode node = request.getBody();
    		 JSONArray array = node.getArray();
    		 JSONObject obj = node.getObject();
    		 // System.out.println(array.toString());
    		 // System.out.println("");
    		 // System.out.println(obj.toString());
    		 
    		 // System.out.println(word);
    		 
    		 if (obj.has("rhymes")) {
	    		 JSONObject testAr = obj.getJSONObject("rhymes");
	    		 // System.out.println(testAr.toString());
	    		 
	    		 if (testAr.has("all")) {
		    		 JSONArray testArr = testAr.getJSONArray("all");
		    		 // System.out.println(testArr.toString());
		    		 
		    		 for (int i = 0; i < testArr.length(); i++) 
		    		 {
		    			 if(!testArr.getString(i).contains(" "))
		    			 {
		    				 rhymes.add(testArr.getString(i));
		    				 // System.out.println(testArr.getString(i));
		    			 }
		    		 }
		    		 // System.out.println(testArr.length());
	    		 }
    	     }
    		 
		 } catch (UnirestException e) {
			// TODO Auto-generated catch block
			 System.out.println("This is an error, but Im going to pretend like its not!");
		 }
    	 
    	 return rhymes;
    }

}