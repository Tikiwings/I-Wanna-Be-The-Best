package application;

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
	
	public Player()
	{
		this("Brogrammer");
	}
	
//	public Player(String classChoice)
//	{
//		playerSetup(this, classChoice);
//	}
//	
//	private void playerSetup(Player me, String classChoice)
//	{
//		me.myClass = classChoice;
//		System.out.println(classChoice);
//		switch (classChoice) {
//			case "Coding Wizard":
//				me.playerStats = new Stats(100, 100, 5, 1);
//			case "Coding Monkey":
//				me.playerStats = new Stats(100, 100, 4, 2);
//			case "Brogrammer":
//				me.playerStats = new Stats(100, 100, 3, 3);
//			case "Athlete":
//				me.playerStats = new Stats(100, 100, 2, 4);
//			case "Network King":
//				me.playerStats = new Stats(100, 100, 1, 5);
//			case "Degenerate":
//				me.playerStats = new Stats(100, 100, 1, 1);
//			default:
//				System.err.println("Class name given is not a valid class"); 
//		}
//		me.score = 0;
//	}

	public Player(String classChoice)
	{
		myClass = classChoice;
		switch (classChoice) {
			case "Coding Wizard":
				playerStats = new Stats(100, 100, 5, 1);
				break;
			case "Coding Monkey":
				playerStats = new Stats(100, 100, 4, 2);
				break;
			case "Brogrammer":
				playerStats = new Stats(100, 100, 3, 3);
				break;
			case "Athlete":
				playerStats = new Stats(100, 100, 2, 4);
				break;
			case "Network King":
				playerStats = new Stats(100, 100, 1, 5);
				break;
			case "Degenerate":
				playerStats = new Stats(100, 100, 1, 1);
				break;
			default:
				System.err.println("Class name given is not a valid class"); 
		}
		score = 0;
	}
	
	
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
	
	public String getPlayerInfo()
	{
		return "Class: " + getCurClass() + "\n\t\tIntelligence: " + getInt() + "\n\t\tCharisma: "
				+ getChar() + "\n\t\tHP: " + getHP() + "\n\t\tMP: " + getMP() + "\n\t\tScore: "
				+ getScore();
	}
	
	public String getStatStr()
	{
		return playerStats.toString();
	}
}



