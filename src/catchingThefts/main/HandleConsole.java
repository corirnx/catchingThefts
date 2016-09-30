package catchingThefts.main;

import java.util.Scanner;

import catchingThefts.main.models.Player;
import catchingThefts.main.virtualUser.Stepping;

/**
 * handles input at the console for a real use or the bot
 */
public final class HandleConsole {

	public static int getGridSize(Player player, Scanner scanner) {
		
		if (player.IsVirtualUser()) {
			// TODO
			return 7;
		} else {
			System.out.println("enter grid size as integer: ");
			// initials scanner to read user input
			int size = scanner.nextInt();
			return size;
		}
		
	}

	// gets the next input from user or bot
	public static String getInput(Player[] players, Scanner scanner) {
		
		// select the user
		Player user = new Player(true, false, 0);
		for (Player player : players) {
			if (player.IsUser())
				user = player;
		}

		// handle for bot or not
		if (user.IsVirtualUser()) {
			// calculate next step of bot
			return Stepping.goNext(players);
		} else {
			// get next by user input
			return scanner.nextLine();
		}
	}
}
