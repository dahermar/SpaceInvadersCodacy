package tp.p1.controller;

import tp.p1.juego.Game;

public class ListCommand extends Command{

	public ListCommand() {
		super("list", "l", "[l]ist", "Muestra una lista con las naves y sus datos");
		
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("\nLista de naves:\n"
				+ "[C]omun:       Puntos: 5  - Damage: 0 - Vida: 2\n"
				+ "[D]estructor:  Puntos: 10 - Damage: 1 - Vida: 1\n"
				+ "[O]vni:        Puntos: 25 - Damage: 0 - Vida: 1\n"
				+ "^__^ Player:   Damage: 1    - Vida: 3\n");
		return false;
	}
}
