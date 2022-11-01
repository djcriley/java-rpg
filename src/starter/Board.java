package starter;
import java.util.ArrayList;


public class Board {
	// A 2-D array of characters representing the board
	// Character reference is stored where a character is expected to be present.
	private Character[][] board; 
	
	// Stores the exit location for the board.
	private Space exit;


	/**
	 * Constructor for the board which sets up an empty grid of size rows by columns
	 * Use the first array index as the rows and the second index as the columns
	 * 
	 * @param rows number of rows on the board
	 * @param cols number of columns on the board
	 */
	public Board(int r, int c) {

		System.out.println("Generating board!");

		// Create a 2D array of characters
		board = new Character[r][c];

	}

	/**
	 * @return number of columns the board has
	 */
	public int getNumCols()
	{
		return board[0].length;
	}

	/**
	 * @return number of rows the board has
	 */
	public int getNumRows()
	{
		return board.length;
	}
	
	/**
	 * @param s Space that identifies the exit
	 * 
	 */
	public void setExit(Space s) {
		exit = s;
	}
	
	/**
	 * return Space that identifies the exit
	 * 
	 */	
	public Space getExit() {
		return this.exit;
	}

	/**
	 * Grabs the character present on a particular space if any is there
	 * 
	 * @param s the desired space where you want to look to see if a character is there
	 * @return a pointer to the Character object present on that space, if no Character is present, null is returned
	 */
	public Character getCharacter(Space s) {
		Character retCharacter = null; 
		// Look for the character at the given space
		if(board[s.getRow()][s.getCol()] != null){
			retCharacter =  board[s.getRow()][s.getCol()]; //Sets the retCharacter to character at that space if it is not null
		}

		return retCharacter;
	}

	public Character spaceCheck(Player p) {
		
		Character tempRight = board[p.getRow()][p.getCol() + 1];
		if(tempRight != null) {

			
			return tempRight;
		}
		else {
			
			return null;
		}
	}

	/**
	 * Checks if any character is present on a particular space if any is there
	 * 
	 * @param s the desired space where you want to look to see if a character is there
	 * @return true if Character object present on that space, if no Character is present, false is returned
	 */
	public boolean isCharacterOnSpace(Space s) {
		if(board[s.getRow()][s.getCol()] != null)
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * Returns the list of characters on the board
	 * 
	 * @return arraylist of characters on the board.
	 */
	public ArrayList<Character> getCharactersOnBoard() {
		ArrayList<Character> characters = new ArrayList<Character>(); 
		for(int i = 0; i < getNumRows(); i++)
			for(int j = 0; j < getNumCols(); j++) {
				if(board[i][j] != null)
					characters.add(board[i][j]);
			}

		return characters;
	}

	/**
	 * adds a character to the board. It checks for a legal placement here.
	 * 
	 * @param character Character that needs to be added to the board
	 */
	public void addCharacter(Character character) {
		System.out.println("Checking if Character can be added!");

		int cRow = character.getRow();
		int cCol = character.getCol();

		System.out.println("Row: " + cRow + "\nColumn: " + cCol + "\n");

		//Checking bounds
		if(cRow >= 0 && cRow < getNumRows() && cCol >= 0 && cCol < getNumCols()) {
			System.out.println("In Limits");
			if(board[cRow][cCol] == null) {
				System.out.println("Character added to Row: " + cRow + "\nCol: " + cCol + "\n");
				board[cRow][cCol] = character;
			}
		}
		else
			System.out.println("Location occuppied! Skipping Character Addition!!!!");
	}
	
	/**
	 * remove character at the given space,
	 * 
	 * @param s Space where the character needs to be removed.
	 */
	public void removeCharacter(Space s) {
		int row, col;
		row = s.getRow();
		col = s.getCol();
		
		if (row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols())
			board[row][col] = null;
	}
	
	/**
	 * Checks whether the character can move to the specified location
	 * 
	 * @param c Character that needs to be moved.
	 * @param newSpace the space where the character needs to move to
	 * 
	 * @return true if the character can be moved
	 */
	public boolean canMove(Character c, Space newSpace) {
		//Java short circuits, so it's okay to have everything here.
		if(newSpace.getRow() < getNumRows() && newSpace.getCol() < getNumCols())
			if(newSpace.getRow() >= 0 && newSpace.getRow() < getNumRows() && newSpace.getCol() >= 0 && newSpace.getCol() < getNumCols())
				if(board[newSpace.getRow()][newSpace.getCol()] == null || board[newSpace.getRow()][newSpace.getCol()] == c )
					return true;

		return false;
	}
	
	/**
	 * Moves the given character to the specified location, only if the move can be performed
	 * 
	 * @param c Character that needs to be moved.
	 * @param newSpace the space where the character needs to move to
	 * 
	 */
	public void moveCharacter(Character c, Space newSpace) {
		if(canMove(c, newSpace)) {
			board[c.getRow()][c.getCol()] = null;

			for(int i = 0; i < getNumRows(); i++)
				for(int j = 0; j < getNumCols(); j++) {
					if(board[i][j] == c)
						board[i][j] = null;
				}

			addCharacter(c);
		}
		else
			System.out.println("Can't move!");
	}
	
	//Do not touch this class, I already converted it.
	public String toString() {
		return BoardConverter.createString(this);
	}

	public static void main(String[] args) {
		//Test board
		Board testBoard = new Board(5, 5);

				//Add test Character's Below
				Player p = new Player(1, 1, CharacterType.MAGE);
				Enemy e = new Enemy(3, 4);
				
				testBoard.addCharacter(e);
				testBoard.addCharacter(p);
				testBoard.getCharactersOnBoard();
				System.out.println(testBoard);
				
				Space playerSpot = new Space(p.getRow(), p.getCol() + 1);
				Space enemySpot = new Space(e.getRow(), e.getCol() - 1);
				Space offBoard = new Space(e.getRow(), e.getCol() + 1);
				
				//Testing canMove()
				//Passing
				System.out.println(testBoard.canMove(p, playerSpot));
				System.out.println(testBoard.canMove(e, enemySpot));
				
				//Failing
				System.out.println(testBoard.canMove(e, offBoard));
				
				//Testing moveCharacter()
				//Passing
				testBoard.moveCharacter(p, playerSpot);
				testBoard.moveCharacter(e, enemySpot);
				
				//Failing
				testBoard.canMove(e, offBoard);
				
				System.out.println(testBoard);
	}
	
}