package tp.p1.auxiliar;
import tp.p1.juego.Game;
import tp.p1.juego.Level;

import java.io.IOException;

import tp.p1.controller.Control;
import tp.p1.excepciones.WrongParametersNumberException;

public class Main {
	public static void main(String[] args) throws IOException {
		Game juego; 
		Level nivel;
		String args_aux;
		Control control;
		int seed_aux;
		try {
			if(args.length > 2) {
				throw new WrongParametersNumberException();
			}
			args_aux = args[0].toUpperCase();
	
			nivel = Level.valueOf(args_aux);
			
			if (args.length < 2) {
				juego = new Game(nivel);
			}
			else {
				seed_aux = Integer.parseInt(args[1]);
				juego = new Game(nivel, seed_aux);
			}	
			control = new Control(juego, args_aux);
			control.run(args);
			
		}
		catch (ArrayIndexOutOfBoundsException | WrongParametersNumberException e) {
			System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]");
		}
		catch(NumberFormatException e){
			 System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]: the seed must be a number");
		}	
		catch(IllegalArgumentException e) {
			System.err.println("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
		}
	}
		
}