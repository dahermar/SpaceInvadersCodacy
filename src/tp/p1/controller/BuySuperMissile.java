package tp.p1.controller;

import tp.p1.excepciones.CommandExecuteException;
import tp.p1.excepciones.NotEnoughPointsException;
import tp.p1.juego.Game;

public class BuySuperMissile extends Command{

	public BuySuperMissile() {
		super("buy", "b", "[b]uy SuperMissile", "Compra un SuperMisil por 20 puntos");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
		game.buySuperMissile();
		return true; //He interpretado que el comprar un misil no gasta un ciclo pero si printea el tablero
		             //para que muestre el nuevo número de Supermisiles. Tambien podrría haber mostrado solo la
		             //información del juego y no el tablero, pero me daba la sensación de que quedaba peor
		}
		catch(NotEnoughPointsException ex) {
			throw new CommandExecuteException(ex);
		}
	}

}
