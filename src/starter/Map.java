package starter;
import java.util.*;

/**
 * COMP 55: Application Development final Project
 *  @author Nitin Pinnamaneni & Greg Jewell
 */


public class Map {

	// Levels of the game
	public static final int LEVEL_BEGINNER     = 1;  // basic level to get a feel of the game
	public static final int LEVEL_INTERMEDIATE = 2;  // intermediate with simple enemy
	public static final int LEVEL_ADVANCED     = 3;  // advanced with complex enemies
	public static final int LEVEL_FINAL        = 4;  // Final level with King as the enemy
	public static final int MAX_LEVELS         = 4;

	// State variables
	// Reference to the board
	private Board board;     
	// Tracks if enemies are defeated
	private boolean isEnemyDefeated = false;
	// Tracks the enemy
	private Enemy e;
	// Tracks the player
	private Player p;

	// Static state
	// Stores all the levels of the game
	private static Map[] levels;
	// Stores the current level being played.
	private static int currentLevel = LEVEL_BEGINNER;
	
	//private static ArrayList<String> temp = MainApplication.speech;


	// Private Constructor that takes in a level and initializes the map for that level
	// By making the constructor private we make sure that only the maps that are setup here are provided.
	private Map(int level) {
		switch(level) {
		case LEVEL_BEGINNER:
			setupBeginnerMap();
			break;
		case LEVEL_INTERMEDIATE:
			setupIntermediateMap();
			break;
		case LEVEL_ADVANCED:
			setupAdvancedMap();
			break;
		case LEVEL_FINAL:
			setupFinalMap();
			break;
		default:
			System.out.println("Invalid level " + level + ". Levels supported are from 0 to " + MAX_LEVELS);
			break;
		}
	}

	/**
	 * @return number of columns the board has
	 */
	public int getNumCols()
	{
		return board.getNumCols();
	}

	/**
	 * @return number of rows the board has
	 */
	public int getNumRows()
	{
		return board.getNumRows();
	}

	/**
	 * @return Space that represents exit
	 */
	public Space getExit() {
		return board.getExit();
	}

	
	public Character spaceCheck(Player p) {
		return board.spaceCheck(p);
	}

	/**
	 * Moves the given character to the specified location, only if the move can be performed
	 * 
	 * @param c Character that needs to be moved.
	 * @param newSpace the space where the character needs to move to
	 * 
	 */
	public void moveCharacter(Character c, Space newSpace) {
		board.moveCharacter(c,  newSpace);
	}


	/**
	 * adds player to the board. It checks for a legal placement here.
	 * 
	 * @param player Player that needs to play the game
	 */
	public void addPlayer(Player player) {
		p = player;
		board.addCharacter(player);
	}

	/**
	 * removes the character at the given location
	 * 
	 */
	public void removeCharacter(Space s) {
		board.removeCharacter(s);
	}

	/**
	 * Sets up the beginner board
	 * initialize the board, NPCs, enemies, exit position
	 */
	private void setupBeginnerMap() {
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(6, 6);
		
		// Add NPCs
		NPC npc = new NPC(4, 2);
		board.addCharacter(npc);
		NPC npc2 = new NPC(1, 3);
		board.addCharacter(npc2);
		
		
		npc.setDialouge(MainApplication.speech.get(0));
		npc2.setDialouge(MainApplication.speech.get(1));
		
		// No enemies in this level
		
		// Exit space for this level is for Player  to reach r3c54
		board.setExit(new Space(3,5));
	}

	/**
	 * Sets up the intermediate board
	 * initialize the board, NPCs, enemies, exit position
	 */
	private void setupIntermediateMap()
	{
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(6, 6);

		// Winning space for this level is for Player  to reach r5c5
		board.setExit(new Space(5, 5));

		// Add NPCs
		NPC npc = new NPC(1, 4);
		npc.setDialouge(MainApplication.speech.get(2));
		board.addCharacter(npc);
		
		NPC npc1 = new NPC(2, 3);
		npc1.setDialouge(MainApplication.speech.get(3));
		board.addCharacter(npc1);
	
		// Add enemies
		e = new Enemy(3, 3);
		board.addCharacter(e);
	}

	/**
	 * Sets up the advanced board
	 * initialize the board, NPCs, enemies, exit position
	 */
	private void setupAdvancedMap()
	{
		// Add characters and set up exit space.
		// Initialize board with the maxRows and maxCols
		board = new Board(6, 6);	

		// Winning space for this level is for Player  to reach r5c2
		board.setExit(new Space(5, 2));

		// Add NPCs
		NPC npc = new NPC(1, 4);
		npc.setDialouge(MainApplication.speech.get(4));
		board.addCharacter(npc);
		
		// Add enemies
		e = new Enemy(4, 2);
		board.addCharacter(e);
		e = new Enemy(4, 3);
		board.addCharacter(e);
		e = new Enemy(4, 4);
		board.addCharacter(e);

	}
	
	/**
	 * Sets up the final board
	 * initialize the board, NPCs, enemies, exit position
	 */
	public void setupFinalMap()
	{
		// Add characters
		// Initialize board with the maxRows and maxCols
		board = new Board(6, 6);

		// Add the final enemy -King
		e = new Enemy(2, 2);
		e.makeKing();
		board.addCharacter(e);
		
		// Winning space for this level is for Player  to reach r5c5
		board.setExit(new Space(5,5));
	}

	public Enemy getEnemy()
	{
		return e;
	}

	/**
	 * Gets the nearby character
	 * 
	 * @param p Player whose proximity is being checked.
	 * 
	 * @return character that is close to the given player
	 */
	public Character getNearbyCharacter(Player p)
	{
		return board.spaceCheck(p);
	}
	
	/**
	 * Returns the character at the given space
	 * 
	 * @param space the space at which the vehicle needs to be fetched 
	 * @return the character at the given location
	 */
	public Character getCharacter(Space space)
	{
		return board.getCharacter(space);
	}
	
	
	/**
	 * Returns the list of characters on the board
	 * 
	 * @return arraylist of characters on the board.
	 */
	public ArrayList<Character> getCharactersOnMap()
	{
		return board.getCharactersOnBoard();
	}
	
	/**
	 * Returns map for the given level
	 * 
	 * @return Map for the given level
	 */
	public static Map getMap(int level)
	{
		Map retMap = null;

		if(level > 0 && level <= MAX_LEVELS)
		{
			retMap = new Map(level);
		}
		else {
			System.out.println("Invalid level " + level + ". Levels supported are from 0 to " + MAX_LEVELS);
		}

		return retMap;
	}

	/**
	 * Returns map for the 'current' active level
	 * Initializes the map if requred.
	 * 
	 * @return Map for the given level
	 */
	public static Map getCurrentMap()
	{
		if(levels == null)
		{
			// Initialize the maps
			levels = new Map[MAX_LEVELS];
			levels[0] = getMap(LEVEL_BEGINNER);
			levels[1] = getMap(LEVEL_INTERMEDIATE);
			levels[2] = getMap(LEVEL_ADVANCED);
			levels[3] = getMap(LEVEL_FINAL);
		}
		return levels[getCurrentLevel() - 1];
	}
	
	
	/**
	 * Returns teh current active level
	 * 
	 * @return current level
	 */
	public static int getCurrentLevel()
	{
		return currentLevel;
	}
	
	/**
	 * Increments the given active level
	 * 
	 */
	public static void incrementLevel()
	{
		if(getCurrentLevel() < MAX_LEVELS)
		{
			currentLevel++;
		}
	}

	/**
	 * Checks if the player is facing enemy
	 * 
	 * @return true if enemy is near the player.
	 * 
	 */
	public boolean isFacingEnemy()
	{
		boolean retVal = false;
		
		if (p != null & e != null) {
			if(e.getRow() == p.getRow() - 1 && p.getCol() == e.getCol())
			{
				retVal = true;
			}
			// Right
			else if(e.getRow() == p.getRow() + 1 && e.getCol() == p.getCol())
			{
				retVal = true;
			}
			// Enemy above of player
			else if(e.getRow() == p.getRow() && e.getCol() == p.getCol() - 1)
			{
				retVal = true;
			}
			// Below
			else if(p.getRow() == e.getRow()  && e.getCol() == p.getCol() + 1)
			{
				retVal = true;
			}
		}

		return retVal;
	}
	
	
	/**
	 * Stores whether the enemy is defeated or not
	 * 
	 * @param status whether the enemy is defeated or not
	 * 
	 */
	public void setEnemyDefeated(boolean isDefeated)
	{
		isEnemyDefeated = isDefeated;
	}

	/**
	 * Checks whether the given level is complete or not.
	 * Level is complete if the enemy is defeated and the player reached the exit level.
	 * 
	 * @return true if the level is complete
	 * 
	 */
	public boolean isLevelComplete()
	{
		boolean retVal = false;
		if(isEnemyDefeated && p.getRow() == getExit().getRow() && p.getCol() == getExit().getCol())
		{
			retVal = true;
		}
		return retVal;
	}
	
	
	/**
	 * generates the string representation of the level, including the row and column headers to make it look like
	 * a table
	 * 
	 * @return the string representation
	 */
	public String toString() {
		String result = generateColHeader(board.getNumCols());
		result+=addRowHeader(board.toString());
		return result;
	}

	/**
	 * This method will add the row information
	 * needed to the board and is used by the toString method
	 * 
	 * @param origBoard the original board without the header information
	 * @return the board with the header information
	 */
	private String addRowHeader(String origBoard) {
		String result = "";
		String[] elems = origBoard.split("\n");
		for(int i = 0; i < elems.length; i++) {
			result += String.format("%2d", (i)) + "|" + elems[i] + "\n"; 
		}
		return result;
	}

	/**
	 * This one is responsible for making the row of column numbers at the top and is used by the toString method
	 * 
	 * @param cols the number of columns in the board
	 * @return if the # of columns is five then it would return "  1  2  3  4  5\n-----\n"
	 */
	private String generateColHeader(int cols) {
		String result = "  ";
		for(int i = 1; i <= cols; i++) {
			result+=String.format("%3d", (i - 1));
		}
		result+="\n  ";
		for(int i = 0; i < cols; i++) {
			result+="---";
		}
		result+="\n";
		return result;
	}

}
