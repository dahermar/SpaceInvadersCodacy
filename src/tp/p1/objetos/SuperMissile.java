package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class SuperMissile extends UCMMissile{

	public SuperMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}
	
	public SuperMissile() {
		super(null, 0,0,0);
	}

	@Override
	public String toString() {
		return "!^!";
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(this.isAlive() && this.x == other.getX() && this.y == other.getY() && other.receiveMissileAttack(2)) {
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
	public String toStringified() {
		return "Supermissile: X;" + super.toStringified() + "\n";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "Supermissile: X")) {
			if(verifier.verifyWeaponString(stringFromFile, game)) {
				String[] words = stringFromFile.split(";");
				String[] coords = words[1].split (",");
				if(!game.isPlayerMissile()) {
					game.setPlayerMissile(true);
					return new SuperMissile(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), 1);
				}
				else{
					throw new FileValuesException("Archivo no valido: No puede haber mas de un misil");
				}
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para SuperMissile");
			}	
		}
		return null;
	}
	
}
