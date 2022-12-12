package tp.p1.objetos;

import tp.p1.juego.Game;

public abstract class Ship extends GameObject {

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toStringified() {
		return super.toStringified() +";" + this.live;
	}

}
