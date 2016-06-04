package chess_logic;

public class Move {

	private Location initialPos;
	private Location finalPos;
	
	public Move(Location init, Location f) {
		initialPos = init;
		finalPos = f;
	}
	
	public Location init() {
		return initialPos;
	}
	
	public Location fin() {
		return finalPos;
	}
	
}
