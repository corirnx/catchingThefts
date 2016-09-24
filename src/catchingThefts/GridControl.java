package catchingThefts;

import java.util.Random;

import catchingThefts.Helper.ConsoleLogger;
import catchingThefts.Helper.OutputStringBuilder;
import catchingThefts.Model.Grid;
import catchingThefts.Model.Player;

public class GridControl {

	Grid _grid;
	Player[] _players;

	public GridControl(Grid grid, Player[] players) {
		ConsoleLogger.Log("=>prepare field");
		_grid = grid;
		_players = players;
		setRandomPosition();
	}

	void setRandomPosition() {
		for (int i = 0; i < _players.length; i++) {
			int x = getRandomInt(_grid.getSize());
			int y = getRandomInt(_grid.getSize());
			_players[i].setPosition(x, y);
		}
		_grid.update(_players);
	}

	int getRandomInt(int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt(max + 1);
		return randomNum;
	}

	public void start() {
		displayGrid();
		
		// todo:  impl. nutzereingabe  
	}

	void displayGrid() {
		String[] grid = _grid.getGrid();
		for (int i = 0; i < _grid.getSize(); i++) {
			String output = OutputStringBuilder.toStringWithWhitespace(grid[i]);
			System.out.println(output);
		}
	}
}
