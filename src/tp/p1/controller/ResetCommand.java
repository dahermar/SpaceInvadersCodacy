package tp.p1.controller;

import tp.p1.juego.Game;

public class ResetCommand extends Command{

	public ResetCommand() {
		super("reset", "r", "[r]eset", "Empieza una nueva partida");
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}
}
