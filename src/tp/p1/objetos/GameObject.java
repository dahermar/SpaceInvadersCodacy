package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public abstract class GameObject implements IAttack{
	protected int x;
	protected int y;
	protected int live;
	protected Game game;
	public static final String labelRefSeparator = " - ";
	protected int label = 0;
	
	public GameObject(Game game, int x, int y, int live) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.live = live;
	}
	// métodos que devuelven el valor de las coordinadas 
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isAlive() {
		return this.live > 0;
		}

	public int getLive() {
		return this.live;
	}

	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public abstract GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException;
	
	public String toStringified() {
		return this.x + "," + this.y;
	}
	
	
	@Override
	public boolean receiveExplosiveAlienAttack(int damage) {
		this.live-= damage;
		return true;	
	}
	
	
	public int getLabel() {
		return label;
	}
	
	public boolean isOwner(int ref) {
		return label == ref;
	}
}
