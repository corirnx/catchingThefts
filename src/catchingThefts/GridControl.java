package catchingThefts;

import java.util.Random;

import catchingThefts.Model.Grid;
import catchingThefts.Model.Player;

public class GridControl {

	Grid _grid;
	Player[] _players;

	public GridControl(Grid grid, Player[] players) {
		// spielfeld vorbereiten
		_grid = grid;
		_players = players;
		setRandomPosition();
	}

	void setRandomPosition() {

		for (int i = 0; i < _players.length; i++) {
			int x = randInt(_grid.getSize());
			int y = randInt(_grid.getSize());
			_players[i].setPosition(x, y);
		}

		_grid.update(_players);

		// Player currUser = Positioners.getPosition(true, currGrid);
		// currUser.Move(move);
	}

	int randInt(int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt(max + 1);
		return randomNum;
	}

	public void start() {
		displayGrid();
	}

	void displayGrid() {

		for (int i = 0; i < _grid.getSize(); i++) {
			String[] grid = _grid.getGrid();
			String output = "";

			char[] lines = grid[i].toCharArray();

			for (int j = 0; j < lines.length; j++) {
				output += lines[j] + " ";
			}
			System.out.println(output);
		}
	}
}
