package tp.p1.controller;
import tp.p1.juego.*;;

public enum PrinterTypes {
	BOARDPRINTER("boardprinter",
		"muestra el juego en forma de tablero de dimension: ",
		new BoardPrinter(8, 9)),
	STRINGIFIER("stringifier",
		"muestra el juego en forma de texto plano",
		new Stringifier());
	private String printerName;
	private String helpText;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		printerName = name;
		helpText = text;
		printerObject = printer;
	}
			
	public static String printerHelp(Game game) {
		String helpString = "";
		for (PrinterTypes printer : PrinterTypes.values())
			helpString += String.format(" %s : %s %s %n", printer.printerName, printer.helpText,
			(printer == BOARDPRINTER ? Game.DIM_X + " x " + Game.DIM_Y : "") );
		return helpString;
	}
			
	// Assumes a max of one object of each printer type is needed (otherwise return a copy)
	public GamePrinter getObject(Game game) {
		printerObject.setGame(game);
		return printerObject;
	}

}
