package tp.p1.excepciones;

import tp.p1.juego.Game;

public class NotEnoughPointsException extends Exception{
	public NotEnoughPointsException(){
		super("No se ha podido realizar la compra: No tienes suficientes puntos (necesitas " + Integer.toString(Game.pointsToBuy) +")");
	}
}
