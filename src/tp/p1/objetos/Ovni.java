package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class Ovni extends EnemyShip implements IExecuteRandomActions{

	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	public Ovni() {
		super(null, 0,0,0);
	}

	@Override
	public void computerAction() {
		if(this.live <= 0 && IExecuteRandomActions.canGenerateRandomOvni(this.game)) {
			this.x = 0;
			this.y = 9;
			this.live = 1;
		}
		
	}

	@Override
	public void onDelete() {
		game.receivePoints(25);
		game.enableShockWave();
		this.y = -1;
	}

	@Override
	public void move() {
		if(this.live > 0){
			this.y--;
			if(this.y < 0) {
				this.live = 0;
				this.y = -1;
			}
		}
	}

	@Override
	public String toString() {
		if(this.live > 0) {
			return "O[" + this.getLive() + "]";
		}
		return "";
	}
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		super.receiveMissileAttack(damage);
		if(this.live <= 0) {
			onDelete();
		}
		return true;
	}

	@Override
	public boolean isAlive() {
		return true;
	}
	
	@Override
	public String toStringified() {
		if(this.live > 0) {
			return "Ovni: O;" + super.toStringified() + "\n";
		}
		return "";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException{
		if(verifier.verifyPrefix(stringFromFile, "Ovni: O")) {
			if(verifier.verifyOvniString(stringFromFile, game, 1)) {
				String[] words = stringFromFile.split(";");
				String[] coords = words[1].split (",");
				return new Ovni(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(words[2]));
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para Ovni");
			}
		}
		return null;
	}
}
