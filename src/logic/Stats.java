package logic;

public class Stats {
	Integer hp;
	Integer mp;
	Integer intelligence;
	Integer charisma;
	
	public Stats(int hp, int mp, int intelligence, int charisma) {
		this.hp = hp;
		this.mp = mp;
		this.intelligence = intelligence;
		this.charisma = charisma;
	}
	
	@Override
    public String toString() { 
        return String.format("HP: %d MP: %d Intelligence: %d Charisma: %d",hp,mp,intelligence,charisma); 
    } 
}
