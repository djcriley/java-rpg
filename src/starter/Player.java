package starter;

public class Player extends Character {
	
	/**
	 * This is for the PLAYER class, only add things specific to the Player
	 * since this uses the Character class as a SuperClass.
	 * 
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
	
	public Player(int row, int col, CharacterType type) {
		super(row, col);
		this.cType = type;
		
		if(cType == CharacterType.WARRIOR) {
			this.strength = 4;
			this.charisma = 1;
			this.agility = 3;
			this.defense = 2;
			this.isPlayer = true;
			this.isHostile = false;
			this.isKing = false;
			this.balance = 5000;
		}
		else if(cType == CharacterType.ROGUE) {
			this.strength = 3;
			this.charisma = 4;
			this.agility = 2;
			this.defense = 1;
			this.isPlayer = true;
			this.isHostile = false;
			this.isKing = false;
			this.balance = 5000;
		}
		else if(cType == CharacterType.MAGE) {
			this.strength = 1;
			this.charisma = 2;
			this.agility = 3;
			this.defense = 4;
			this.isPlayer = true;
			this.isHostile = false;
			this.isKing = false;
			this.balance = 5000;
		}
		System.out.println("I am in the player constructor" + this.isPlayer);
		System.out.println(this);
	}

//Player Setters(Mutators)
	public Character setStrength() {
		int change = this.getStrength();
		this.strength = change + 1;
		
		return this;
	}
	public Character setCharisma() {
		this.charisma = charisma + 1;
		
		return this;
	}
	public Character setAgility() {
		this.agility = agility + 1;
		
		return this;
	}
	public Character setDefense() {
		this.defense = defense + 1;
		
		return this;
	}
	
//Player Printout
	public String printPlayer() {
		this.printCharacter();
		return "---------------------------------------------";
	}
}
