package starter;

public class LevelUp {
	
	private int points;
	private Player player;
	private int beginStrength, beginAgility, beginDefense, beginCharisma, beginHealth;
	
	public static final int POINTS_PER_WIN = 3;
	public LevelUp(Player p, int pts)
	{
		player = p;
		points = pts;
		// Store the initial stats so that we dont allow allocations to go below these stats.
		beginStrength = p.getStrength();
		beginAgility = p.getAgility();
		beginDefense = p.getDefense();
		beginCharisma = p.getCharisma();
		beginHealth = p.getHealth();
	}

	public int getPoints() {
		return points;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean strengthUp()
	{
		boolean retVal = false;
		// Increment player strength and decrement overall points
		if (points > 0)
		{
			player.setStrength(player.getStrength() + 1);
			points--;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean strengthDown()
	{
		boolean retVal = false;
		// Decrement player strength and increment overall points (only if strength is  beginStrength)
		if (player.getStrength() > beginStrength)
		{
			player.setStrength(player.getStrength() - 1);
			points++;
			retVal = true;
		}
		return retVal;
	}
	

	public boolean agilityUp()
	{
		boolean retVal = false;
		// Increment player agility and decrement overall points
		if (points > 0)
		{
			player.setAgility(player.getAgility() + 1);
			points--;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean agilityDown()
	{
		boolean retVal = false;
		// Decrement player agility and increment overall points
		if (player.getAgility() > beginAgility)
		{
			player.setAgility(player.getAgility() - 1);
			points++;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean defenseUp()
	{
		boolean retVal = false;
		// Increment player defense and decrement overall points
		if (points > 0)
		{
			player.setDefense(player.getDefense() + 1);
			points--;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean defenseDown()
	{
		boolean retVal = true;
		// Decrement player defense and increment overall points
		if (player.getDefense() > beginDefense)
		{
			player.setDefense(player.getDefense() - 1);
			points++;
			retVal = true;
		}
		return retVal;
	}

	public boolean charismaUp()
	{
		boolean retVal = false;
		// Increment player charisma and decrement overall points
		if (points > 0)
		{
			player.setCharisma(player.getCharisma() + 1);
			points--;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean charismaDown()
	{
		boolean retVal = false;
		// Decrement player charisma and increment overall points
		if (player.getCharisma() > beginCharisma)
		{
			player.setCharisma(player.getCharisma() - 1);
			points++;
			retVal = true;
		}
		return retVal;
	}

	public boolean healthUp()
	{
		boolean retVal = false;
		// Increment player health and decrement overall points
		if (points > 0)
		{
			player.setHealth(player.getHealth() + 1);
			points--;
			retVal = true;
		}
		return retVal;
	}
	
	public boolean healthDown()
	{
		boolean retVal = false;
		// Decrement player health and increment overall points
		if (player.getHealth() > beginHealth)
		{
			player.setHealth(player.getHealth() - 1);
			points++;
			retVal = true;
		}
		return retVal;
	}

	public String toString()
	{
		String retVal = "";
		
		retVal = retVal + "[points = " + points + "], player stats = { " + 
		   " strenght = " + player.getStrength() + 
		   " agility = " + player.getAgility() + 
		   " defense = " + player.getDefense() + 
		   " charisma = " + player.getCharisma() + 
		   " health = " + player.getHealth() + 
		   " }";
 		
		return retVal;
	}
	
	public static void main(String[] args)
	{
		Player p = new Player(3, 4, CharacterType.MAGE);
		LevelUp lvlup = new LevelUp(p, POINTS_PER_WIN);
		
		System.out.println("Initial " + lvlup);
		lvlup.strengthUp();
		System.out.println("After strength up :   " + lvlup);
		lvlup.strengthDown();
		System.out.println("After strenght down :  " + lvlup);
		
		lvlup.agilityUp();
		System.out.println("After Agilty up :   " + lvlup);
		lvlup.agilityDown();
		System.out.println("After agility down :  " + lvlup);

		lvlup.defenseUp();
		System.out.println("After Defense up :   " + lvlup);
		lvlup.defenseDown();
		System.out.println("After defense down :  " + lvlup);

		lvlup.charismaUp();
		System.out.println("After Charisma up :   " + lvlup);
		lvlup.charismaDown();
		System.out.println("After charisma down :  " + lvlup);

		lvlup.healthUp();
		System.out.println("After Health up :   " + lvlup);
		lvlup.healthDown();
		System.out.println("After health down :  " + lvlup);
	}
}
			
