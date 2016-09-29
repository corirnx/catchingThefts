package catchingThefts.main.helper;

import java.util.Random;

import catchingThefts.main.models.Player;

public final class InitialSetup {

	public static boolean setRandomPosition(Player[] players, int size) {

		try {
			// players can't be at the same field at the beginning
			int x = 0, y = 0, lastX = 0, lastY = 0;

			do {

				for (int i = 0; i < players.length; i++) {
					x = getRandomInt(size);
					y = getRandomInt(size);
					if (i == 0) {
						players[i].setPosition(x, y);
						x = 0;
						y = 0;
					} else {
						lastX = players[i - 1].getX();
						lastY = players[i - 1].getY();
						if (IsntEquals(x, y, lastX, lastY))
							players[i].setPosition(x, y);
					}
				}

			} while (!IsntEquals(x, y, lastX, lastY));

		} catch (Exception e) {
			ConsoleLogger.Log(e.getMessage());
			return false;
		}
		return true;
	}

	static int getRandomInt(int max) {
		Random rand = new Random();
		return rand.nextInt(max + 1);
	}

	static boolean IsntEquals(int x, int y, int lastX, int lastY) {
		if (FirstIsEqls(x, lastX, y, lastY) || FirstIsEqls(y, lastY, x, lastX) || (x != lastX && y != lastY))
			return true;
		else
			return false;
	}

	static boolean FirstIsEqls(int f, int lastF, int s, int lastS) {
		return (f == lastF && s != lastS);
	}

}
