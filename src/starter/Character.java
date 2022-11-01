package starter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;


public class Character{

	public static final Space startSpace = new Space(1,1);

	//Instance Variables
	//Private Usable only in this class
	private int cRow, cCol, cHealth;

	//Protected usable in this class and child class(es)
	protected int strength, charisma, agility, defense, balance, experience;
	protected boolean isPlayer, isHostile, isKing;
	protected CharacterType cType;
	protected String dialouge;

	//Public frowned upon, please do NOT implement any :)


	/**
	 * The constructor takes: 
	 * @param CharacterType
	 * @param row
	 * @param col
	 * 
	 * The row/column are used to set the location they occupy.
	 * 
	 * There is a lot of information here, so that it can be adjusted if needed, rather than
	 * being spread over multiple classes
	 * 
	 * The CharacterType is assigned here in the parameters, but it should actually be
	 * selected via a click or keyboard selection from the user!
	 */

	// Character Constructor
	public Character(int row, int col) {
		this.cRow = row;
		this.cCol = col;
		this.cHealth = 50;
		this.setLocation(row, col);
	}

	//Basic Setters(Mutators)
	public void setStrength(int c) {
		this.strength = c;
	}
	public void setCharisma(int c) {
		this.charisma = c;
	}
	public void setAgility(int c) {
		this.agility = c;
	}
	public void setDefense(int c) {
		this.defense = c;
	}
	public void setHealth(int c) {
		this.cHealth = c;
	}
	public void setBalance(int c) {
		int update = c + this.balance;
		this.balance = update;
	}
	public void setHostile() {
		this.isHostile = true;
	}
	public void setKing() {
		this.isKing = true;
	}


	public void setLocation(int r, int c) {
		this.cRow = r;
		this.cCol = c;
	}
	public void setDialouge(String s) {

		this.dialouge = s;
	}

	//Set User class
	@SuppressWarnings("resource")
	public void setCharacterType() {
		int choice = 0;

		System.out.println("Please select the NUMBER of your class:\n");
		printWarrior();
		printRogue();
		printMage();
		choice = new Scanner(System.in).nextInt();

		if(choice == 1) {
			System.out.println("Warrior Selected");
			this.cType = CharacterType.WARRIOR;
		}
		else if(choice == 2) {
			System.out.println("Rogue Selected");
			this.cType = CharacterType.ROGUE;
		}
		else if(choice == 3) {
			System.out.println("Mage Selected");
			this.cType = CharacterType.MAGE;
		}
		else {
			System.out.println("The number entered is incorrect, please re-enter a number\n");
			choice = 0;
			this.setCharacterType();
		}
	}

	//Basic Getters(Accessors)
	public int getStrength() {
		return this.strength;
	}
	public int getCharisma() {
		return this.charisma;
	}
	public int getAgility() {
		return this.agility;
	}
	public int getDefense() {
		return this.defense;
	}
	public int getHealth() {
		return this.cHealth;
	}
	public Space getLocation()
	{
		return new Space(cRow, cCol);
	}

	public int getRow()
	{
		return cRow;
	}
	public int getCol()
	{
		return cCol;
	}
	public boolean isKing() {
		return this.isKing;
	}
	public boolean isHostile() {
		return this.isHostile;
	}

	//Player Getters(Accessors)
	public int getBalance() {
		return this.balance;
	}
	public int getExperience() {
		return this.experience;
	}

	//Returns Character type (Warrior, Rogue, ....)
	public CharacterType getCharacterType() {
		return cType;
	}

	public String getDialouge() {

		return this.dialouge;
	}
	//Gives enemies a small balance of gold for the player to steal!
	public int randBalance() {
		// create instance of Random class 
		Random rand = new Random(); 

		// Generate random integers in range 0 to 500 
		int balance = rand.nextInt(501); 

		return balance;
	}

	public static void printSpaces(Space space) {
		System.out.println("Current location is Row: " + space.getRow() + " Colomn: " + space.getCol() + "\n");
	}

	public static void printWarrior() {
		System.out.println("(1) Warrior:\nStrength: 4\nCharisma: 1\nAgility: 3\nDefense: 2\n");
	}
	public static void printRogue() {
		System.out.println("(2) Rogue:\nStrength: 3\nCharisma: 4\nAgility: 2\nDefense: 1\n");
	}
	public static void printMage() {
		System.out.println("(3) Mage:\nStrength: 1\nCharisma: 2\nAgility: 3\nDefense: 4\n");
	}

	public void printCharacter() {
		System.out.println("Strength: " + this.getStrength() + "\n");
		System.out.println("Charisma: " + this.getCharisma() + "\n");
		System.out.println("Agility: " + this.getAgility() + "\n");
		System.out.println("Defense: " + this.getDefense() + "\n");

		if(this.cType == CharacterType.ENEMY || this.isPlayer) {
			System.out.println("Current Health: " + this.getHealth() + "\n");
			System.out.println("Gold Balance: " + this.getBalance() + "\n");
			if(this.isPlayer)
				System.out.println("Current Experience: " + this.getExperience() + "\n");
		}

		System.out.println("---------------------------------------\n");
	}

	public boolean isPlayer() {
		return this.isPlayer;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Space startSpace = new Space(1,1);
		Player Muzzy = new Player(startSpace.getRow(), startSpace.getCol(), CharacterType.WARRIOR);
		Muzzy.isHostile = false;
		printSpaces(Muzzy.getLocation());
		Muzzy.printPlayer();
	}
}