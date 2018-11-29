package logic;

public class Stats {
	public Integer hp, mp, intelligence, charisma;
	
	public Stats(int hp, int mp, int intelligence, int charisma) {
		this.hp = hp;
		this.mp = mp;
		this.intelligence = intelligence;
		this.charisma = charisma;
	}
	
	@Override
    public String toString() { 
        return String.format("HP: " + hp + " MP: " + mp + " Intelligence: " + intelligence + " Charisma: " + charisma); 
    } 
}
