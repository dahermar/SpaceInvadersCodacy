package tp.p1.objetos;

import tp.p1.juego.Game;

public abstract class UCMMissile extends Weapon{

	public UCMMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		game.enableMissile();
	}

	@Override
	public void move() {
		if(AlienShip.estaBajando()) {
			game.checkAttacksGame(this);
		}
		this.x--;
	}
	
}
