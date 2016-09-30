package catchingThefts.main;

import java.util.Scanner;

import catchingThefts.main.helper.ConsoleLogger;
import catchingThefts.main.helper.InitialSetup;
import catchingThefts.main.helper.MoveHandler;
import catchingThefts.main.helper.OutputStringBuilder;
import catchingThefts.main.models.Grid;
import catchingThefts.main.models.Move;
import catchingThefts.main.models.Player;

public class GridControl {

	Grid _grid;
	Player[] _players;

	// is the whole playgroud with the players
	public GridControl(Grid grid, Player[] players) {
		ConsoleLogger.Log("=>prepare field");
		_grid = grid;
		_players = players;
	}

	public void start() {

		boolean success = InitialSetup.setRandomPosition(_players, _grid.getSize());
		if (success) {
			_grid.update(_players);
			displayGrid();
		}

		readUserInput();
	}

	void readUserInput() {

		try (Scanner scanner = new Scanner(System.in)) {

			String input = HandleConsole.getInput(_players, scanner);

			// move the game stone like the input says
			while (!input.toLowerCase().equals("exit")) {

				Move moveTo = MoveHandler.toMove(input);

				if (moveTo == Move.None) {
					// TODO: handle other commands
					input = HandleConsole.getInput(_players, scanner);
				}

				// move each player and update the grid
				for (Player player : _players) {

					if (player.IsUser()) {
						player.Move(moveTo);
						_grid.update(_players);
					}
				}

				displayGrid();

				boolean gotCatched = checkForCatching();
				if (gotCatched) {
					ConsoleLogger.Log("YOU WIN");
					break;
				} else {
					input = HandleConsole.getInput(_players, scanner);
				}
			}
		}

	}

	boolean checkForCatching() {
		if (_players[0].getX() == _players[1].getX() && _players[0].getY() == _players[1].getY())
			return true;
		else
			return false;
	}

	void displayGrid() {
		String[] grid = _grid.getGrid();
		for (int i = 0; i < _grid.getSize(); i++) {
			String output = OutputStringBuilder.toStringWithWhitespace(grid[i]);
			System.out.println(output);
		}
	}
}
