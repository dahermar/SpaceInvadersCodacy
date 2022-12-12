package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class Bomb extends Weapon{

	private DestroyerAlien owner;
	private int ownerRef;
	
	public Bomb(Game game, int x, int y, int live, DestroyerAlien owner) {
		super(game, x, y, live);
		this.owner = owner;
		if(owner != null) {
			owner.setBomb(this);
		}
	}

	public Bomb() {
		super(null, 0,0,0);
	}

	@Override
	public void computerAction() {
		
	}

	@Override
	public void onDelete() {
		if(owner != null) {
			owner.setBomb(null);
		}
	}

	@Override
	public void move() {
		this.x++;
		
	}

	@Override
	public String toString() {
		return "·";
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(this.isAlive() && (this.x == other.x || this.x == other.x + 1) && this.y == other.y && this.x <= 7 && other.receiveBombAttack(1)) {
			this.live--;
			return true;
		}
		return false;
	}
	
	@Override
	public String toStringified() {
		return "Bomb: B;" + super.toStringified() + ( owner.isAlive() ? generateSerialRef() : "" ) + "\n";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "Bomb: B")) {
			String[] splitOnRef = stringFromFile.split(labelRefSeparator);
			if(verifier.verifyWeaponString(splitOnRef[0], game) && verifier.verifyRefString(stringFromFile)) {
				String[] words = splitOnRef[0].split(";");
				String[] coords = words[1].split (",");
				ownerRef = Integer.parseInt(splitOnRef[1]);
				return new Bomb(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), 1, game.getBombOwner(ownerRef));
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para Bomb");

			}	
		}
		return null;
	}
	
	public String generateSerialRef() {
		return labelRefSeparator + owner.getLabel();
	}

}
