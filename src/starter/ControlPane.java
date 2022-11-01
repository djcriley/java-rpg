package starter;

import acm.graphics.GImage;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class ControlPane extends GraphicsPane {
	private static final String BACKGROUND = "controlsImage.jpg";
	private static final String BACKIMAGE = "backButton.png";

	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton back;
	private GImage background;
	private GImage backbutton;
	
	public ControlPane(MainApplication app) {
		super();
		program = app;
		background = new GImage(BACKGROUND);
		backbutton = new GImage(BACKIMAGE);
		back = new GButton("Back", 0, 0, 86, 30);
	
		back.setVisible(false);
		
		showContents();
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(backbutton);
		program.add(back);
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
	
	@Override
	public void mouseReleased(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			back.setFillColor(Color.WHITE);
			hideContents();
			program.switchToMenu();
		}
	}
}
