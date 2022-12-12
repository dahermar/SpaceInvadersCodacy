package tp.p1.controller;

import tp.p1.juego.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("exit", "e", "[e]xit", "Se finaliza el juego");		
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return false;
	}
}
