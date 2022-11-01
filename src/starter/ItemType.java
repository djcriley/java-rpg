package starter;
/**
 * Borrowed from O. Jimenez's TrafficJam VehicleType Enumerator
 * 
 * @author CodeAvalanche
 * 
 *   !!!DEPRECATED!!!
 *
 */
public enum ItemType {
	STRENGTH, CHARISMA, AGILITY, DEFENSE;
	
	public String toString() {
		switch(this) {
			case STRENGTH: return "Strength";
			case CHARISMA: return "Charisma";
			case AGILITY: return "Agility";
			case DEFENSE: return "Defense";
		}
		return "n/a";
	}
}