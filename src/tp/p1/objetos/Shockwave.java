package tp.p1.objetos;

import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class Shockwave extends Weapon{
	
	public Shockwave(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	public Shockwave() {
		super(null, 0,0,0);
	}

	@Override
	public void computerAction() {	
	}

	@Override
	public void onDelete() {
		game.disableShockWave();	
	}

	@Override
	public void move() {}

	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		return other.receiveShockWaveAttack(1);	
	}
	
	@Override
	public boolean receiveShockWaveAttack(int damage) {
		this.live = 0;
		return true;	
	}
	
	@Override
	public boolean isAlive() {
		return (this.live > 0);
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		return null;
	}
}
