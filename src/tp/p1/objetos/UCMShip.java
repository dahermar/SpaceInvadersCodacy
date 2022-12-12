package tp.p1.objetos;

import tp.p1.excepciones.FileValuesException;
import tp.p1.juego.FileContentsVerifier;
import tp.p1.juego.Game;

public class UCMShip extends Ship{
	
	private boolean seMueve;
	private String direc;
	private int num;
	private boolean missile; //Sirve para saber si hay un missil en el tablero
	private boolean shockWave; //Sirve para saber si hay un shockwave disponible
	private int numSuperMissiles;
	private int points;

	public UCMShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.seMueve = false;
		this.missile = false;
		this.shockWave = false;
		this.numSuperMissiles = 0;
		this.points = 0;

	}

	public UCMShip() {
		super(null, 0,0,0);
	}

	private UCMShip(Game game, int x, int y, int live, int points, boolean shockWave, int numSuperMissiles) {
		super(game, x, y, live);
		this.seMueve = false;
		this.missile = false;
		this.points = points;
		this.shockWave = shockWave;
		this.numSuperMissiles = numSuperMissiles;
	}

	public boolean isMissile() {
		return missile;
	}

	public void setMissile(boolean missile) {
		this.missile = missile;
	}

	public boolean isShockWave() {
		return shockWave;
	}

	public void setShockWave(boolean shockWave) {
		this.shockWave = shockWave;
	}

	public int getNumSuperMissiles() {
		return numSuperMissiles;
	}

	public void setNumSuperMissiles(int numSuperMissiles) {
		this.numSuperMissiles = numSuperMissiles;
	}

	@Override
	public void computerAction() {}

	@Override
	public void onDelete() {}

	public void setSeMueve(boolean seMueve) {
		this.seMueve = seMueve;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public boolean sePuedeMover() { 
		if (direc.equals("r")) {
			if (this.y + num > 8) {
				return false;
			}
		}
		else if (direc.equals("l")){
			if (this.y - num < 0) {
				return false;
			}
		}
		else {
			return false;
		}
		
		return true;
	}

	@Override
	public void move() {
		if (seMueve) {
			if (direc.equals("r")) {
				if (this.y + num <= 8) {
					this.y += num;
				}
			}
			else{
				if (this.y - num >= 0) {
					this.y -= num;
				}
			}
		}
		this.seMueve = false;
	}

	@Override
	public String toString() {
		if (this.live > 0) {
			return "^__^";
		}
		return "!xx!";
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.live-= damage;
		return true;
	}
	
	
	@Override
	public String toStringified() {
		return "UCMShip (player): P;" + super.toStringified() + ";" + this.points + ";" + this.shockWave + ";" + this.numSuperMissiles + "\n";
	}

	public int getPoints() {
		return points;
	}

	public void recievePoints(int points) {
		this.points += points;
	}
	
	public void spendPoints(int points) {
		this.points -= points;
	}

	@Override
	public GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		if(verifier.verifyPrefix(stringFromFile, "UCMShip (player): P")) {
			if(verifier.verifyPlayerString(stringFromFile, game, 3)) {
				String[] words = stringFromFile.split(";");
				String[] coords = words[1].split (",");
				UCMShip ship = new UCMShip(game, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]), Boolean.parseBoolean(words[4]), Integer.parseInt(words[5]));
				game.setPlayer(ship);
				return ship;
			}
			else {
				throw new FileValuesException("Invalid file: Incorrect values for UCMShip (player)");
			}	
		}
		return null;
	}

}
