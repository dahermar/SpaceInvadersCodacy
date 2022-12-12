package tp.p1.controller;

import tp.p1.excepciones.CommandExecuteException;
import tp.p1.excepciones.NotShockwaveException;
import tp.p1.juego.Game;

public class ShockwaveCommand extends Command{

	public ShockwaveCommand() {
		super("shockwave", "w", "shock[w]ave", "La nave del jugador lanza una onda que afecta a todos los enemigos menos al ovni");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
		game.shockWave();
		return true;
		}
		catch(NotShockwaveException ex){
			throw new CommandExecuteException(ex);
		}
	}
}
