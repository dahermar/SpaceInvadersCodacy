package tp.p1.juego;

public class Stringifier extends GamePrinter{

	private String stringiflied;
	
	private void encodeGame(Game game) {
		stringiflied = game.toString();
	}
	
	@Override
	public void setGame(Game game) {
		encodeGame(game);
	}

	@Override
	public String toString() {
		return this.stringiflied;
	}

}
