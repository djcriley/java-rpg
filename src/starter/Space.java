package starter;


public class Space {
	private int Row;
	private int Column;
	


//Constructor
/**
* The constructor that will set up the object to store a row and column
* 
* @param row
* @param column
*/
	public Space(int r, int c) {
		this.Row = r;
		this.Column = c;
	}

//Setters
	public void setRow(int r) {
		this.Row = r;
	}
	public void setCol(int c) {
		this.Column = c;
	}
	
//Getters
	public int getRow() {
		return Row;
	}
	public int getCol() {
		return Column;
	}

//String override
	@Override
	public String toString() {
		return "Position: Column" + getCol() + "Row" + getRow();
	}
	
//Test Main for Space.java
//Borrowed from O. Jimenez's TrafficJam Space Class
	public static void main(String[] args) {
		Space one = new Space(3, 4);
		Space two = new Space(1, 6);
		two.setRow(two.getRow()+1);
		two.setCol(two.getCol()-1);
		System.out.println("one r: " + one.getRow() + ", c: " + one.getCol());
		System.out.println("two r: " + two.getRow() + ", c: " + two.getCol());
	}
}