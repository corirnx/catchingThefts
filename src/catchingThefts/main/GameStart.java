package catchingThefts.main;

import java.util.Scanner;

import catchingThefts.main.models.Grid;
import catchingThefts.main.models.Player;

/**
 * @author corycoffee
 * @since September 2016
 * @none this is a test
 */
public class GameStart {

	/*
	 * this is the beginning of the game
	 */
	public static void main(String[] args) {

		System.out.println("===============");
		System.out.println("catchingThefts");
		System.out.println("===============");

		Scanner scanner = new Scanner(System.in);

		System.out.println("wanna play as user(U) or should the bot(b) play? ");
		// initials scanner to read user input
		String s = scanner.nextLine();

		Player user = new Player(true, false, 0);

		if(s.contains("b")){
			user = new Player(true, true, 7);
		}
		
		int size = HandleConsole.getGridSize(user, scanner);

		System.out.println("okay!");

		Grid grid = new Grid(size);
		Player theft = new Player(false, false, (size - 1));
		
		if(s.contains("u"))
		{
			user = new Player(true, false, (size - 1));
			System.out.println("===============");
			System.out.println("catch the theft (T) as the user (U)");
			System.out.println("enter as direction: 'down', 'up', 'left', 'right'");
			System.out.println("===============");
		}

		GridControl control = new GridControl(grid, new Player[] { theft, user });
		
		// start the game
		control.start();
		scanner.close();
	}

}
