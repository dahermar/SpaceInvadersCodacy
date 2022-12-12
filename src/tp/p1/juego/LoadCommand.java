package tp.p1.juego;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import tp.p1.excepciones.CommandExecuteException;
import tp.p1.excepciones.FileContentsException;
import tp.p1.juego.Game;
import tp.p1.juego.GamePrinter;

public class LoadCommand extends Command{

	private String nombreArchivo;

	public LoadCommand() {
		super("loadcommand", "o", "l[o]ad command <nombreArchivo", "Carga la partida guardada en el archivo proporcionado");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException, IOException {
		try (BufferedReader archivo = new BufferedReader(new FileReader(this.nombreArchivo))){
			if(archivo.readLine().equals("--- Space Invaders v2.0 ---")) {
				if(archivo.readLine().isEmpty()) {
					game.load(archivo);
				}
				else {
					throw new CommandExecuteException("No se ha podido cargar: La segunda linea del archivo debe ser una linea en blanco");
				}			
			}
			else {
				throw new CommandExecuteException("No se ha podido cargar: El archivo debe empezar por '--- Space Invaders v2.0 ---'");
			}
			
			
		}
		catch (FileContentsException ex) {
			throw new CommandExecuteException(ex);
		}
		System.out.println("Game successfully loaded from file " + this.nombreArchivo + "\n");
		return true;
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
