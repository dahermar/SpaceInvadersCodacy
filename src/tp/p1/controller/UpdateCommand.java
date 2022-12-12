package tp.p1.controller;

import tp.p1.juego.Game;

public class UpdateCommand extends Command{

	public UpdateCommand() {
		super("none", "n", "[n]one", "Se deja pasar un ciclo");
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		return true;
	}
}
