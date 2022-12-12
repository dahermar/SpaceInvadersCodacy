package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions{

	private Bomb bomb;
	private static int currentSerialNumber;
	
	public DestroyerAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	public DestroyerAlien() {
		super(null, 0,0,0);
	}
	


	private DestroyerAlien(Game game, int x, int y, int live, int numCiclos, boolean direccion, int label) {
		super(game, x, y, live, numCiclos, direccion);
		this.label = label;
	}

	@Override
	public void computerAction() {
		if(this.bomb == null && IExecuteRandomActions.canGenerateRandomBomb(this.game)) {
			if(AlienShip.FinTablero == false) {
				if (numCiclos == game.getNumCyclesToMoveOneCellLevel()) {
					if(this.direccion) {
						this.bomb = new Bomb(this.game, this.x, this.y + 1, 1, this);
						this.game.addObject(this.bomb);
					}
					else {
						this.bomb = new Bomb(this.game, this.x, this.y - 1, 1, this);
						this.game.addObject(this.bomb);
					}
				}
				else {
					this.bomb = new Bomb(this.game, this.x, this.y, 1, this);
					this.game.addObject(this.bomb);
				}
			}
			else {
				this.bomb = new Bomb(this.game, this.x + 1, this.y, 1, this);
				this.game.addObject(this.bomb);
			}
		}
	}
	

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}


	@Override
	public void onDelete() {
		super.onDelete();
		game.receivePoints(10);
	}

	@Override
	public String toString() {
		return "D[" + this.getLive() + "]";
	}
	
	@Override
	public String toStringified() {
		if (!game.isStringifying()) {
			game.setStringifying();
			initialiseLabelling();
			}
		return "Destroyer alien: D;" + super.toStringified() + generateStringifyLabel() + "\n";
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "Destroyer alien: D")) {
			String[] splitOnRef = stringFromFile.split(labelRefSeparator);
			if(verifier.verifyAlienShipString(splitOnRef[0], game, 1) && verifier.verifyRefString(stringFromFile)) {
				String[] words = splitOnRef[0].split(";");
				String[] coords = words[1].split (",");
				return new DestroyerAlien(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]), Boolean.parseBoolean(words[4]), Integer.parseInt(splitOnRef[1]));
			}
			else {
				throw new FileValuesException("Archivo no valido: Valores incorrectos para RegularAlien");
			}	
		}
		return null;
	}
	
	private void initialiseLabelling () {
		currentSerialNumber = 1;
	}
		
	private String generateStringifyLabel() {
		label = currentSerialNumber;
		currentSerialNumber++;
		return labelRefSeparator + label;
	}

}
