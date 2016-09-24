package catchingThefts;

import java.util.Random;

import catchingThefts.Helper.Positioners;
import catchingThefts.Model.Grid;
import catchingThefts.Model.Player;

public class GridControl {

	Grid _grid;
	Player[] _players;
	
	public GridControl(Grid grid, Player[] players){
		// spielfeld vorbereiten
		_grid = grid;
		_players = players;
		setRandomPosition();
	}
	
	void setRandomPosition(){
		
		for(int i = 0; i < _players.length; i++){
			int x = randInt(_grid.getSize());
			int y = randInt(_grid.getSize());
			_players[i].setPosition(x,y);
		}

		
		//Player currUser = Positioners.getPosition(true, currGrid);
		//currUser.Move(move);
		
	}
	
	int randInt(int max) {

	    // NOTE: This will (intentionally) not run as written so that folks
	    // copy-pasting have to think about how to initialize their
	    // Random instance.  Initialization of the Random instance is outside
	    // the main scope of the question, but some decent options are to have
	    // a field that is initialized once and then re-used as needed or to
	    // use ThreadLocalRandom (if using at least Java 1.7).
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt(max + 1);

	    return randomNum;
	}
	
	public void start(){
		// grid anzeigen
		displayGrid();
	}
	
	void displayGrid(){
		
		for(int i = 0; i < _grid.getSize(); i++){
			String[] grid = _grid.getGrid();
			String output = "";
			
			char[] lines = grid[i].toCharArray();
			
			for(int j = 0; j < lines.length; j++){
				output += lines[j] + " ";
			}
			System.out.println(output);
		}
	}
}
