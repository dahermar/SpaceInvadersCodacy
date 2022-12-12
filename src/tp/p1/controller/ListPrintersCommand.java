package tp.p1.controller;

import tp.p1.juego.Game;

public class ListPrintersCommand extends Command{

	public ListPrintersCommand() {
		super("listprinterscommand", "p", "list [p]rinters command", "Muestra los printers disponibles");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(PrinterTypes.printerHelp(game));
		return false;
	}

}
