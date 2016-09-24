package catchingThefts.Helper;

import catchingThefts.Model.Player;

public final class Positioners {

	public static Player getPosition(Player player, String[] grid){
		// horizontale und vertikale
		int x = 0, y = 0;
		
		for(int i = 0; i < grid.length; i++){
			// vertical lines
			char[] line = grid[i].toCharArray();
			y = getVerticalIndex(line, player.getName());
			
			if(y >= 0)
			{
				x = i;
				break;
			}
		}
		
		// return
		return player;
	}
	
	static int getVerticalIndex(char[] line, char letter){
		for(int i = 0; i < line.length; i++){
			if(line[i] == 'U'){
				return i;
			}
		}
		return -1;
	}
}
