package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class RegularAlien extends AlienShip{

	private boolean seTransforma; //Sirve para ver si una nave se transforma a explosiva
	
	public RegularAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
		seTransforma = false;
	}

	public RegularAlien() {
		super(null, 0,0,0);
		seTransforma = false;
	}
	
	private RegularAlien(Game game, int x, int y, int live, int numCiclos, boolean direccion) {
		super(game, x, y, live, numCiclos, direccion);
		seTransforma = false;
	}

	@Override
	public void onDelete() {
		super.onDelete();
		if(!seTransforma) {
			game.receivePoints(5);
		}
		
	}
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		if(!this.seTransforma) {
			this.live-= damage;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "C[" + this.getLive() + "]";
	}

	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomExplosive(game)) {
			game.generateExplosive(this.x, this.y, this.live, this.numCiclos, this.direccion);
			this.live = 0;
			this.seTransforma = true;
		}
	}

	
	
	@Override
	public String toStringified() {
		return "Regular alien: R;" + super.toStringified() + "\n";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "Regular alien: R")) {
			if(verifier.verifyAlienShipString(stringFromFile, game, 2)) {
				String[] words = stringFromFile.split(";");
				String[] coords = words[1].split (",");
				return new RegularAlien(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]), Boolean.parseBoolean(words[4]));
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para RegularAlien");

			}	
		}
		return null;
	}

}
