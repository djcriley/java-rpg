package starter;
/**
 * Borrowed from O. Jimenez's TrafficJam VehicleType Enumerator
 * 
 * @author CodeAvalanche
 *
 */
public enum CharacterType {
	WARRIOR, MAGE, ROGUE, NPC, ENEMY, KING;
	
	public String toString() {
		switch(this) {
			case WARRIOR: return "Warrior";
			case MAGE: return "Mage";
			case ROGUE: return "Rogue";
			case NPC: return "NPC";
			case ENEMY: return "Enemy";
			case KING: return "King";
		}
		return "n/a";
	}
}