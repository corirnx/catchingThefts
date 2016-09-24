package catchingThefts.Model;

import java.util.HashMap;
import java.util.Map;

public class Grid {

	int currSize;
	String[] currGrid;
		
	public Grid(int size){
		currSize = size;
		buildGrid();
	}
	
	void clearGrid(){
		int len = currGrid.length;
		for(int i = 0; i <len; i++){
			currGrid[i] = getEmptyCol(len);
		}
	}
	
	String getEmptyCol(int length){
		String col = "";
		for(int j = 0; j < length; j++){
			col += '-';
		}
		return col;
	}
	
	void buildGrid(){
		currGrid = new String[currSize];
		clearGrid();
	}

	boolean updateGrid(Player[] players){
		if(players.length != 2)
			return false;
		
		clearGrid();
		setNewPosition(players[0]);
		setNewPosition(players[1]);
		return true;
	}
	
	void setNewPosition(Player player){
		
		for(int i = 0; i < currGrid.length; i++){
			// horizontalle ---
			
			if(player.getY() == i){
				// vertikale setzen: unter einander
				char[] chars = currGrid[i].toCharArray();
				
				for(int j = 0; j < chars.length; j++){
					if(player.getX() == j){
						chars[j] = player.getName();
					}
				}
				
				String col = chars.toString();
				currGrid[i] = col;
			}
		}
	}
	
	
	public int getSize(){
		return currSize;
	}
	
	public String[] getGrid(){
		return currGrid;
	}
}
