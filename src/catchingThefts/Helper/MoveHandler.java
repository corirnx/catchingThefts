package catchingThefts.Helper;

import catchingThefts.Model.Move;

public final class MoveHandler {
	
	public static Move toMove(String input) {
		switch (input.toLowerCase()) {
		case "down":
			return Move.Down;
		case "up":
			return Move.Up;
		case "right":
			return Move.Right;
		case "left":
			return Move.Left;
		default:
			return Move.None;
		}
	}

}
