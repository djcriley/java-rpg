package starter;

public class NPC extends Character {
	
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
	
	public NPC(int row, int col) {
		super(row, col);
		this.cType = CharacterType.NPC;
		
		if(cType == CharacterType.NPC) {
			this.strength = 1;
			this.charisma = 1;
			this.agility = 1;
			this.defense = 1;
			this.isPlayer = false;
			this.isHostile = false;
			this.isKing = false;
			this.balance = 0;
		}
	}
}
