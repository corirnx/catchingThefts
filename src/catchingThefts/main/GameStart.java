package catchingThefts.main;

import java.util.Scanner;

import catchingThefts.main.models.Grid;
import catchingThefts.main.models.Player;

public class GameStart {

	/**
	 * this is the start of the game
	 */
	public static void main(String[] args) {

		System.out.println("===============");
		System.out.println("catchingThefts");
		System.out.println("===============");

		System.out.println("enter grid size as integer: ");

		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		System.out.println("okay!");

		Grid grid = new Grid(size);
		Player theft = new Player(false, (size - 1));
		Player user = new Player(true, (size - 1));

		System.out.println("===============");

		GridControl control = new GridControl(grid, new Player[] { theft, user });

		System.out.println("===============");
		System.out.println("catch the theft (T) as the user (U)");
		System.out.println("enter as direction: 'down', 'up', 'left', 'right'");
		System.out.println("===============");

		control.start();
	}

}
