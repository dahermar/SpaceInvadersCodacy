package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class NormalMissile extends UCMMissile{

	public NormalMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	public NormalMissile() {
		super(null, 0,0,0);
	}


	@Override
	public boolean performAttack(GameObject other) {
		if(this.isAlive() && this.x == other.getX() && this.y == other.getY() && other.receiveMissileAttack(1)) {
			this.live = 0;
			return true;
		}
		
		
		return false;
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.live-= damage;
		return true;
	}

	@Override
	public String toString() {
		return "oo";
	}
	
	@Override
	public String toStringified() {
		return "Missile: M;" + super.toStringified() + "\n";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "Missile: M")) {
			if(verifier.verifyWeaponString(stringFromFile, game)) {
				String[] words = stringFromFile.split(";");
				String[] coords = words[1].split (",");
				if(!game.isPlayerMissile()) {
					game.setPlayerMissile(true);
					return new NormalMissile(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), 1);
				}
				else{
					throw new FileValuesException("Archivo no valido: No puede haber mas de un misil");
				}
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para NormalMissile");

			}	
		}
		return null;
	}
	
}
