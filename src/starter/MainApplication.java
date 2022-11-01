package starter;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends GraphicsApplication {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "music";
	private static final String[] SOUND_FILES = { "Skyrim.mp3" };
	public static final String TEXT_FILES_FOLDER = "Text Files";
	public static ArrayList<String> speech;

	private AudioPlayer audio;

	private CharacterPane characterPane;
	private MenuPane menuPane;
	private ControlPane controlPane;
	private LevelPane levelPane;
	
	private Item[] itemList;
	
	protected static Player user;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		setTitle("King of BloodCity");
		
		System.out.println("If you see this, use the Java Applet, not the this!");
		menuPane = new MenuPane(this);
		
		generateItems();
		try {
			generateNarrative();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switchToMenu();
		
	}
	
	private void generateItems() {
		itemList = new Item[50];
		Item.generateItemList(itemList);
		Item.printItemList();
	}
	
	private void generateNarrative() throws IOException {
		Narrative.print("NPC-1");
	}
	
	public void switchToMenu() {
		playMenuMusic();
		switchToScreen(menuPane);
	}
	public void switchToCharacterPane() {
		characterPane = new CharacterPane(this);
		switchToScreen(characterPane);
	}
	public void switchToControlPane() {
		controlPane = new ControlPane(this);
		switchToScreen(controlPane);
	}
	public void switchToLevelPane() {
		audio.stopSound(MUSIC_FOLDER, SOUND_FILES[0]);
		levelPane = new LevelPane(this);
		user = characterPane.sendPlayer();
		switchToScreen(levelPane);
	}
	
	private void playMenuMusic() {
		audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);
	}
}