package logic;

/*
	Coding Wizard (5,1)
	Coding (Keyboard) Monkey (4,2)
	Brogrammer (3,3)
	Jock / Athlete (2,4)
	Network King (1,5)
	Degenerate (1,1) 
*/


public class Player {
	
	private String myClass;
	private Integer score;
	private Stats playerStats;
	
	// default
	public Player()
	{
		this("Brogrammer");
	}
	
	// for creating a new player
	public Player(String classChoice)
	{
		myClass = classChoice;
		playerStats = new Stats(100, 100, 5, 1);

		score = 0;
	}
	
	// for loading an existing player from a file
	public Player(String classChoice, Stats loadedStats, Integer score) {
		myClass = classChoice;
		playerStats = loadedStats;
		this.score = score;
	}
	
	// Getters
	public String getCurClass()
	{
		return myClass;
	}
	public Integer getInt()
	{
		return playerStats.intelligence;
	}
	public Integer getChar()
	{
		return playerStats.charisma;
	}
	public Integer getHP()
	{
		return playerStats.hp;
	}
	public Integer getMP()
	{
		return playerStats.mp;
	}
	public Integer getScore()
	{
		return score;
	}
	
	// Setters
	public void setInt(int val)
	{
		playerStats.intelligence = val;
	}
	public void setChar(int val)
	{
		playerStats.charisma = val;
	}
	public void setHP(int val)
	{
		playerStats.hp = val;
	}
	public void setMP(int val)
	{
		playerStats.mp = val;
	}
	
	// Modifiers
	public void adjustHP(int offset)
	{
		playerStats.hp += offset;
	}
	public void adjustMP(int offset)
	{
		playerStats.mp += offset;
	}
	public void adjustInt(int offset)
	{
		playerStats.intelligence += offset;
	}
	public void adjustChar(int offset)
	{
		playerStats.charisma += offset;
	}
	public void adjustScore(int offset)
	{
		this.score += offset;
	}
	
	// prints out and formats the player's information
	public String getPlayerInfo()
	{
		return "Class: " + getCurClass() + "\n\t\tIntelligence: " + getInt() + "\n\t\tCharisma: "
				+ getChar() + "\n\t\tHP: " + getHP() + "\n\t\tMP: " + getMP() + "\n\t\tScore: "
				+ getScore();
	}
	
	// formats and prints out the stats
	public String getStatStr()
	{
		return playerStats.toString();
	}
}



