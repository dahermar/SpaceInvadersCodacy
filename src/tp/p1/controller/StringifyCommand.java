package tp.p1.controller;

import tp.p1.juego.Game;
import tp.p1.juego.GamePrinter;

public class StringifyCommand extends Command{

	public StringifyCommand() {
		super("stringify", "t", "s[t]ringify", "El juego se printea en modo stringified");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		PrinterTypes printerTypes = PrinterTypes.valueOf("STRINGIFIER");
		GamePrinter gameP = printerTypes.getObject(game);
		System.out.println(gameP);
		return false;
	}

}
