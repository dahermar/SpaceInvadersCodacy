package tp.p1.objetos;

import tp.p1.juego.Game;

public abstract class Weapon extends GameObject{

	public Weapon(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isAlive() {
		return (this.live > 0 && this.x >= 0 && this.x <= 7);
	}

}
