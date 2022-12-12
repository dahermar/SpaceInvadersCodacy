package tp.p1.objetos;

import tp.p1.juego.Game;

public abstract class EnemyShip extends Ship{

	public EnemyShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		this.live-= damage;
		return true;
	}

}
