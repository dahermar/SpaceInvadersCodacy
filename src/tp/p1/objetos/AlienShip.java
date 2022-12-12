package tp.p1.objetos;

import tp.p1.juego.Game;

public abstract class AlienShip extends EnemyShip{

	protected int numCiclos;
	protected boolean direccion; //Este booleano indica en que direccion se deben mover las naves: True= derecha, false = izquierda
	protected static int numNaves;
	protected static int contador = 0;
	protected static int contadorBajada = 0;
	protected static boolean FinTablero = false;
	protected static boolean haveLanded;//Indica si alguna nave ha llegado a la fila del jugador
	
	public AlienShip(Game game, int x, int y, int live) {
		
		super(game, x, y, live);
		this.numCiclos = 1;
		this.direccion = true; 
		if(game != null) {
			AlienShip.numNaves = game.getNumRegularAliensLevel() + game.getNumDestroyerAliensLevel();
			
		}
	}
	
	public AlienShip(Game game, int x, int y, int live, int numCiclos, boolean direccion) {
		super(game, x, y, live);
		this.numCiclos = numCiclos;
		this.direccion = direccion; 
		AlienShip.numNaves++;
	
	}
	

	@Override
	public void move() {
		if(FinTablero && contador == 0) {
			contadorBajada = numNaves;
			FinTablero = false;
		}
		if(contador == 0 || contador > numNaves) {
			contador = numNaves;
		}
		if(contadorBajada != 0 && contador == numNaves) {
			this.x++;
			this.direccion = !this.direccion;
			contadorBajada--;
			if (this.x == 7) {
				AlienShip.haveLanded = true;
			}
		}
		else {
			if (numCiclos == game.getNumCyclesToMoveOneCellLevel()) {
				if(this.direccion) {
					this.y++;
					if (this.y >= 8) {
						FinTablero = true;
					}
				}
				else {
					this.y--;	
					if (this.y <= 0) {
						FinTablero = true;
					}
				}
				this.numCiclos = 1;
			}
			else {
				this.numCiclos++;
			}
			contador--;
		}
	}


	@Override
	public void onDelete() {
		AlienShip.numNaves--;
	}

	public static boolean haveLanded() {		
		return AlienShip.haveLanded;
	}
	
	@Override
	public boolean receiveShockWaveAttack(int damage) {
		this.live-= damage;
		return true;	
	}

	public static boolean allDead() {
		return AlienShip.numNaves == 0;
	}
	
	public static boolean estaBajando() {
		
		return AlienShip.contador == numNaves;
	}
	
	public static int getNumNaves(){
		return AlienShip.numNaves;
	}
	
	public static void setNumNaves(int numNaves) {
		AlienShip.numNaves = numNaves;
	}
	

	public static void setFinTablero(boolean valor){
		AlienShip.FinTablero = false;
	}

	@Override
	public String toStringified() {
		return super.toStringified() +";" + this.numCiclos + ";" + this.direccion;
	}
	


	
	

}
