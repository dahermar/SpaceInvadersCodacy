package tp.p1.controller;

import tp.p1.juego.Game;

public class HelpCommand extends Command{

	public HelpCommand() {
		super("help", "h", "[h]elp", "Muestra en pantalla una lista de los comandos");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}
}
