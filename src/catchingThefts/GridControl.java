package catchingThefts;

import java.util.Scanner;

import catchingThefts.Helper.ConsoleLogger;
import catchingThefts.Helper.InitialSetup;
import catchingThefts.Helper.MoveHandler;
import catchingThefts.Helper.OutputStringBuilder;
import catchingThefts.Model.Grid;
import catchingThefts.Model.Move;
import catchingThefts.Model.Player;


public class GridControl {

	Grid _grid;
	Player[] _players;

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
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		while (!input.toLowerCase().equals("exit")) {

			Move moveTo = MoveHandler.toMove(input);
			
			if(moveTo == Move.None){
				// todo: handle other commands
				input = scanner.nextLine();
				//break;
			}
			
			// nutzer bewegen
			for (Player player : _players) {
				if(player.IsUser()){
					// bewegen
					player.Move(moveTo);
					// grid updaten
					_grid.update(_players);
				}
			}
			
			displayGrid();
			
			boolean gotCatched = checkForCatching();
			if(gotCatched){
				ConsoleLogger.Log("YOU WIN");
				break;
			}else{
				input = scanner.nextLine();
			}
		}
	}


	boolean checkForCatching(){
		if(_players[0].getX() == _players[1].getX() && _players[0].getY() == _players[1].getY())
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
