package tp.p1.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import tp.p1.excepciones.CommandExecuteException;
import tp.p1.juego.Game;
import tp.p1.juego.GamePrinter;

public class SaveCommand extends Command{

	private String nombreArchivo;
	
	public SaveCommand() {
		super("savecommand", "v", "sa[v]e command <nombreArchivo>", "Guarda la partida actual en un archivo con el nombre proporcionado");
	}

	@Override
	public boolean execute(Game game) throws IOException{
		try (BufferedWriter archivo = new BufferedWriter(new FileWriter(this.nombreArchivo))){
			PrinterTypes printerTypes = PrinterTypes.valueOf("STRINGIFIER");
			GamePrinter gameP = printerTypes.getObject(game);
			archivo.write(gameP.toString());
		}
		System.out.println("Game successfully saved in file " + this.nombreArchivo + 
				". Use the load command to reload it\n");
		return false;
	}
	
	@Override
	public Command parse(String[] commandWords) {
		if(this.matchCommandName(commandWords[0])) {
			Scanner scan = new Scanner(System.in);
			if(commandWords.length < 2) {
				System.out.println("Introduzca el nombre del archivo");
				this.nombreArchivo = scan.next();
			}
			else {
				this.nombreArchivo = String.valueOf(commandWords[1]);
			}
			nombreArchivo += ".dat";
			return this;
		}
		return null;
	}
}
