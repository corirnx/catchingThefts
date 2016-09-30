package catchingThefts.main.models;

public class Player {

	int _positionMax, _x, _y;
	boolean _isUser, _isVirtualUser;

	public Player(boolean isUser,boolean isVirtual, int maxPosition) {
		_isUser = isUser;
		_isVirtualUser = isVirtual;
		_positionMax = maxPosition;
	}

	public boolean IsUser() {
		return _isUser;
	}
	public boolean IsVirtualUser(){
		return _isVirtualUser;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	void setX(int value) {
		if (value <= _positionMax && value >= 0)
			_x = value;
	}

	void setY(int value) {
		if (value <= _positionMax && value >= 0)
			_y = value;
	}

	public char getName() {
		return _isUser ? 'U' : 'T';
	}

	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}

	public void Move(Move move) {
		switch (move) {
		case Down:
			setY(getY() + 1);
			break;
		case Up:
			setY(getY() - 1);
			break;
		case Left:
			setX(getX() - 1);
			break;
		case Right:
			setX(getX() + 1);
			break;
		default:
			return;
		}
	}
}
