package main;

public class Profiles {
	private String fName, lName, location, genre;
	private int numberOfPoems, id;
	
	//Profiles
	Profiles John;
	Profiles Betty;
	Profiles Jason;
	Profiles Rena;
	Profiles Noah;
	Profiles Emma;
	Profiles Alex;
	Profiles Linda;
	
	public Profiles () {
		this.fName = "";
		this.lName = "";
		this.location = "";
		this.genre = "";
		this.numberOfPoems = 0;
		John = new Profiles ("John", "Adams", "New York City", "Romance", 10, 0);
		 Betty = new Profiles ("Betty", "Michaels", "Boston", "Satire", 5, 1);
		 Jason = new Profiles ("Jason", "Reed", "New York City", "Ballad", 10, 2);
		 Rena = new Profiles ("Rena", "Halberg", "Las Vegas", "Allegory", 2, 3);
		 Noah = new Profiles ("Noah", "Lopez", "San Francisco", "Dramatic Monologue", 3, 4);
		 Emma = new Profiles ("Emma", "King", "Chicago", "Ode", 24, 5);
		 Alex = new Profiles ("Alex", "Johnson", "Miami", "Lyric", 12, 6);
		 Linda = new Profiles ("Linda", "Ming", "Los Angeles", "Ballad", 3, 7);
	}
	
	public Profiles (String fName, String lName, String location, String genre, int numberOfPoems, int id) {
		
		this.fName = fName;
		this.lName = lName; 
		this.location = location;
		this.genre = genre;
		this.numberOfPoems = numberOfPoems;
		this.id = id;
	}
	
	public String toString() {
		return "First Name = "+fName+ " \nLast Name = "+lName+ " \nLocation = "+location+ " \nGenre = "+genre+ " \nNumber of Poems = "+numberOfPoems+ "\nID = "+id+ "";
	}
	
	public String getFName(int id) {
		
		switch(id) {
		case 0 : return John.fName;
		case 1 : return Betty.fName;
		case 2 : return Jason.fName;
		case 3 : return Rena.fName;
		case 4 : return Noah.fName;
		case 5 : return Emma.fName;
		case 6 : return Alex.fName;
		case 7 : return Linda.fName;
		}
		return null;
		
	}
	
	public String getLName(int id) {
		
		switch(id) {
		case 0 : return John.lName;
		case 1 : return Betty.lName;
		case 2 : return Jason.lName;
		case 3 : return Rena.lName;
		case 4 : return Noah.lName;
		case 5 : return Emma.lName;
		case 6 : return Alex.lName;
		case 7 : return Linda.lName;
		}
		return null;
		
	}
	
	public String getLocation(int id) {
		
		switch(id) {
		case 0 : return John.location;
		case 1 : return Betty.location;
		case 2 : return Jason.location;
		case 3 : return Rena.location;
		case 4 : return Noah.location;
		case 5 : return Emma.location;
		case 6 : return Alex.location;
		case 7 : return Linda.location;
		}
		return null;
		
	}
	
	public String getGenre(int id) {
		
		switch(id) {
		case 0 : return John.genre;
		case 1 : return Betty.genre;
		case 2 : return Jason.genre;
		case 3 : return Rena.genre;
		case 4 : return Noah.genre;
		case 5 : return Emma.genre;
		case 6 : return Alex.genre;
		case 7 : return Linda.genre;
		}
		return null;
		
	}

}
