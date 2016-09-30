package catchingThefts.main.virtualUser;

import catchingThefts.main.models.Move;
import catchingThefts.main.models.Player;

public final class Stepping {

	public static String goNext(Player[] players) {

		Player user = new Player(true, false, 0), theft = new Player(false, false, 0);

		for (Player player : players) {
			if (!player.IsUser())
				theft = player;
			else
				user = player;
		}

		int targetX = theft.getX(), actualX = user.getX();

		// start checking for x
		if (isAtSamePosition(targetX, actualX)) {

			// checking for y
			int targetY = theft.getY(), actualY = user.getY();

			if (!isAtSamePosition(targetY, actualY)) {
				if (targetY > actualY) {
					return Move.Down.toString();
				} else {
					return Move.Up.toString();
				}
			}
		}
		else{
			if(targetX > actualX){
				return Move.Right.toString();
			}else{
				return Move.Left.toString();
			}
		}

		return Move.None.toString();
	}

	static boolean isAtSamePosition(int shouldBe, int isActual) {
		if (shouldBe != isActual)
			return false;
		else
			return true;
	}

}
