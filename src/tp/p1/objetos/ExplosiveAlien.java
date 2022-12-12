package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class ExplosiveAlien extends AlienShip{
	
	public ExplosiveAlien() {
		super(null, 0,0,0);
	}
	
	public ExplosiveAlien(Game game, int x, int y, int live, int numCiclos, boolean direccion) {
		super(game, x, y, live, numCiclos, direccion);
	}

	@Override
	public String toString() {
		return "E[" + this.getLive() + "]";
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		game.receivePoints(5);
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(!this.isAlive() && (Math.abs(this.x - other.getX()) <= 1) &&(Math.abs(this.y - other.getY()) <= 1)) {
			return other.receiveExplosiveAlienAttack(1);
		}
		return false;
	}
	
	@Override
	public String toStringified() {
		return "Explosive alien: E;" + super.toStringified() + "\n";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "Explosive alien: E")) {
			if(verifier.verifyAlienShipString(stringFromFile, game, 2)) {
				String[] words = stringFromFile.split(";");
				String[] coords = words[1].split (",");
				return new ExplosiveAlien(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]), Boolean.parseBoolean(words[4]));
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para ExplosiveAlien");

			}	
		}
		return null;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}
	

}
