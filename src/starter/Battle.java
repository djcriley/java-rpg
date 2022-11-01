package starter;
import java.util.Random;

import acm.graphics.*;
import acm.program.GraphicsProgram;


public class Battle extends GraphicsProgram {

	public static GLabel eHealth, cHealth;
	// higher defense and screech doesn't affect
	// if strength 

	public static void Fight(int userMove, Enemy e, Player c) {

		//System.out.println("You are in battle!");

		
		if(LevelPane.Protagonist.getHealth() > 0 && LevelPane.opponent.getHealth() > 0) {
			if(userMove == 1) {
				attack(LevelPane.Protagonist, LevelPane.opponent, enemyMove());
			}
			else if(userMove == 2) {
				block(LevelPane.Protagonist, LevelPane.opponent, enemyMove());
			}
			else {
				screech(LevelPane.Protagonist, LevelPane.opponent, enemyMove());
			}
			
			MainApplication.user.setHealth(LevelPane.Protagonist.getHealth());
			
			Overlay.cHealth.setLabel("Health: " + MainApplication.user.getHealth());
			Overlay.eHealth.setLabel("Health: " + LevelPane.opponent.getHealth());
			
			
			System.out.println("Your Health: " + LevelPane.Protagonist.getHealth() + " \nEnemy Health: " + LevelPane.opponent.getHealth() + "\n");

		}
		else {
			System.out.println("You or the enemy are out of health");

		}

	}
	public static int enemyMove() {

		Random rand = new Random(); 

		int move = rand.nextInt(3); 

		System.out.println(move);

		return move;
	}

	// attack will get passed both Healths, players Strength, The enemys stat based on their move

	public static void attack(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack

			if(LevelPane.Protagonist.getStrength() > LevelPane.opponent.getStrength()) { // if player is > enemy

				LevelPane.opponent.setHealth(LevelPane.opponent.getHealth() - 2);

				System.out.println("Your attack was higher so you hurt him");


			}
			else { //if enemy > player

				LevelPane.Protagonist.setHealth(LevelPane.Protagonist.getHealth() - 2);
				System.out.println("Your attack was lower so he hurt you");

			}
		}
		else if(enemyMove == 1) { // enemy screech

			LevelPane.opponent.setHealth(LevelPane.opponent.getHealth() -2);
			System.out.println("He Screeched so your attack hit him!");

		}
		else if(enemyMove == 2){
			System.out.println("He blocked your attack");
		}

		if(LevelPane.Protagonist.getHealth() < 0 && LevelPane.opponent.getHealth() > 0) {

			System.out.println("You lose!");

			LevelPane.Protagonist.setBalance(LevelPane.Protagonist.getBalance() - 100);

			LevelPane.Protagonist.setHealth(0);

		}
		else if(LevelPane.Protagonist.getHealth() > 0 && LevelPane.opponent.getHealth() < 0) {

			System.out.println("You win!");

			LevelPane.Protagonist.setBalance(LevelPane.Protagonist.getBalance() + LevelPane.opponent.getBalance());

			LevelPane.opponent.setHealth(0);
		}


	}

	public static void block(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack

			System.out.println("You blocked his attack");

		}
		else if(enemyMove == 1) { // enemy screech

			LevelPane.Protagonist.setHealth(LevelPane.Protagonist.getHealth() - 1);

			System.out.println("He Screeched so you took damage");

		}
		else if(enemyMove == 2){ // enemy defends

			System.out.println("You both defended, nothing happened");
		}

		if(LevelPane.Protagonist.getHealth() < 0 && LevelPane.opponent.getHealth() > 0) {

			System.out.println("You lose!");

			LevelPane.Protagonist.setBalance(LevelPane.Protagonist.getBalance() - 100);

			LevelPane.Protagonist.setHealth(0);

		}
		else if(LevelPane.Protagonist.getHealth() > 0 && LevelPane.opponent.getHealth() < 0) {

			System.out.println("You win!");

			LevelPane.Protagonist.setBalance(LevelPane.Protagonist.getBalance() + LevelPane.opponent.getBalance());

			LevelPane.opponent.setHealth(0);
		}


	}

	public static void screech(Player c, Enemy e, int enemyMove) {

		if(enemyMove == 0) { // enemy attack

			LevelPane.Protagonist.setHealth(LevelPane.Protagonist.getHealth() - 2);
			System.out.println("He attacked so you took damage");

		}
		else if(enemyMove == 1) { // enemy screech

			System.out.println("you both screeched");

		}
		else if(enemyMove == 2){ // enemy block

			LevelPane.opponent.setHealth(LevelPane.opponent.getHealth() - 1);
			System.out.println("He defended and your screech got in his head.");
		}


		if(LevelPane.Protagonist.getHealth() < 0 && LevelPane.opponent.getHealth() > 0) {

			System.out.println("You lose!");

			LevelPane.Protagonist.setBalance(LevelPane.Protagonist.getBalance() - 100);

			LevelPane.Protagonist.setHealth(0);

		}
		else if(LevelPane.Protagonist.getHealth() > 0 && LevelPane.opponent.getHealth() < 0) {

			System.out.println("You win!");

			LevelPane.Protagonist.setBalance(LevelPane.Protagonist.getBalance() + LevelPane.opponent.getBalance());

			LevelPane.opponent.setHealth(0);
		}


	}

	public boolean checkSkill(Player c, Enemy e) {
		return true;
	}
}
