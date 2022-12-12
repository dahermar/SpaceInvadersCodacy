package tp.p1.controller;
import java.io.IOException;
import java.util.Scanner;

import tp.p1.juego.Game;
import tp.p1.juego.GamePrinter;
import tp.p1.excepciones.*;



public class Control {
	private Game game;
	private Scanner in;
	private GamePrinter gameP;
	private PrinterTypes printerTypes;
		
	
	public Control(Game juego, String nivel_args) {
		game = juego;
		//nivel = Nivel.valueOf(nivel_args);
	}
	
	public void run(String[] args){
		printerTypes = PrinterTypes.valueOf("BOARDPRINTER");
		gameP = printerTypes.getObject(game);
		System.out.println(game.infoToString() + gameP.toString());
		
		Command command = null;
		
		
		while(!game.isFinished()) {
			in = new Scanner(System.in);
			System.out.println("Introduzca un comando: ");
			String[] texto  = in.nextLine().toLowerCase().trim().split ("\\s+");
			try {	
				command = CommandGenerator.parseCommand(texto);
				if(command != null) {
					if(command.execute(game)) {
						gameP = printerTypes.getObject(game);
						System.out.println(game.infoToString() + gameP);
					}
				}
			}
			catch (CommandParseException | CommandExecuteException | IOException ex) {
				System.err.format(ex.getMessage() + " %n %n");
			}

			

			
		}
		System.out.println(game.getWinnerMessage());
		in.close();
	}

}