package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.*;

public class CharacterPane extends GraphicsPane {
	private static final String[] IMAGES = { "characterSelection.jpg", "mage.png", "warrior.png", "rogue.png" };
	
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton back;
	private GImage background, warrior, rogue, mage;
	
	protected Player selectedCharacter;
	
	private int windowHeight = MainApplication.WINDOW_HEIGHT;
	private int windowWidth = MainApplication.WINDOW_WIDTH;

	public CharacterPane(MainApplication app) {
		super();
		program = app;
		
		background = new GImage(IMAGES[0]);
		warrior = new GImage(IMAGES[2], windowWidth - (windowWidth * .99), windowHeight/6);
		rogue = new GImage(IMAGES[3], (windowWidth * .33) + 10, windowHeight/6);
		mage = new GImage(IMAGES[1], (windowWidth * .66) + 10, windowHeight/6);
		back = new GButton("Back", 0, 0, 86, 30);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(warrior);
		program.add(rogue);
		program.add(mage);
		program.add(back);
		back.setVisible(false);
		
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			back.setFillColor(Color.GRAY);
		}
	}
	
	public Player sendPlayer() {
		return selectedCharacter;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == warrior) {
			System.out.println("Selected Warrior!");
			selectedCharacter = new Player(Character.startSpace.getRow(), Character.startSpace.getCol(), CharacterType.WARRIOR);
			MainApplication.user = selectedCharacter;
			hideContents();
			program.switchToLevelPane();
		}
		else if (obj == rogue) {
			System.out.println("Selected Rogue!");
			selectedCharacter = new Player(Character.startSpace.getRow(), Character.startSpace.getCol(), CharacterType.ROGUE);
			MainApplication.user = selectedCharacter;
			hideContents();
			program.switchToLevelPane();
		}
		else if (obj == mage) {
			System.out.println("Selected Mage!");
			selectedCharacter = new Player(Character.startSpace.getRow(), Character.startSpace.getCol(), CharacterType.MAGE);
			MainApplication.user = selectedCharacter;
			hideContents();
			program.switchToLevelPane();
		}
		else if (obj == back) {
			back.setFillColor(Color.WHITE);
			hideContents();
			program.switchToMenu();
		}
	}
}
