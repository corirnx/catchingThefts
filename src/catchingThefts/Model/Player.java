package catchingThefts.Model;

public class Player {

	int _x, _y;
	boolean _isUser;
	
	public Player(boolean isUser){
		_isUser = isUser;
	}
	
	public boolean IsUser(){
		return _isUser;
	}
	
	public int getX(){
		return _x;
	}
	
	public int getY(){
		return _y;
	}
	
	public void MoveUp(){
		_y--;
	}
	
	public char getName(){
		if(_isUser){
			return 'U';
		}
		else{
			return 'T';
		}
	}
	
	public void setPosition(int x, int y){
		_x = x;
		_y = y;
	}
	
	public void Move(Move move){
		switch(move){
		case Down:
			_y++;
			break;
		case Up:
			_y--;
			break;
		case Left:
			_x--;
			break;
		case Right:
			_x++;
			break;
		}
	}
}
