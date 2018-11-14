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
	private int intelligence;
	private int charisma;
	private int HP; //hit points
	private int MP; //mind points (mental hit points)
	private int score;
	
	public Player()
	{
		this("Brogrammer");
	}
	
	public Player(String classChoice)
	{
		playerSetup(this, classChoice);
	}
	
	private void playerSetup(Player me,String classChoice)
	{
		me.myClass = classChoice;
		if (classChoice.equals("Coding Wizard"))
		{
			me.intelligence = 5;
			me.charisma = 1;
		}
		else if (classChoice.equals("Coding Monkey"))
		{
			me.intelligence = 4;
			me.charisma = 2;
		}
		else if (classChoice.equals("Brogrammer"))
		{
			me.intelligence = 3;
			me.charisma = 3;
		}
		else if (classChoice.equals("Athlete"))
		{
			me.intelligence = 2;
			me.charisma = 4;
		}
		else if (classChoice.equals("Network King"))
		{
			me.intelligence = 1;
			me.charisma = 5;
		}
		else if (classChoice.equals("Degenerate"))
		{
			me.intelligence = 1;
			me.charisma = 1;
		}
		else
		{
			//throw error
			System.err.println("Class name given doesn't exist...");
		}
		
		me.HP = 100;
		me.MP = 100;
		me.score = 0;
	}
	
	public String getCurClass()
	{
		return myClass;
	}
	public int getInt()
	{
		return intelligence;
	}
	public int getCha()
	{
		return charisma;
	}
	public int getHP()
	{
		return HP;
	}
	public int getMP()
	{
		return MP;
	}
	public int getScore()
	{
		return score;
	}
	public void adjHP(int offset)
	{
		this.HP += offset;
	}
	public void adjMP(int offset)
	{
		this.MP += offset;
	}
	public void adjInt(int offset)
	{
		this.intelligence += offset;
	}
	public void adjCha(int offset)
	{
		this.charisma += offset;
	}
	public void adjScore(int offset)
	{
		this.score += offset;
	}
	
	public String getPlayerInfo()
	{
		return "Class: " + getCurClass() + "\n\t\tIntelligence: " + getInt() + "\n\t\tCharisma: "
				+ getCha() + "\n\t\tHP: " + getHP() + "\n\t\tMP: " + getMP() + "\n\t\tScore: "
				+ getScore();
	}

}



