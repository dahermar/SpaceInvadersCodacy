package tp.p1.controller;

import java.util.Scanner;

import tp.p1.excepciones.CommandExecuteException;
import tp.p1.excepciones.CommandParseException;
import tp.p1.excepciones.OutOfBoardException;
import tp.p1.juego.Game;

public class MoveCommand extends Command{
	
	private String direccion, numCasillas;
	//private int numCasillas;

	public MoveCommand() {
		super("move", "m", "[m]ove <[l]eft|[r]ight><1|2>", "La nave del jugador se mueve en la direccion indicada el numero de casillas establecido");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {	
		try {
		game.movePlayer(direccion, Integer.parseInt(numCasillas));
		return true;
		}
		catch(OutOfBoardException ex) {
			throw new CommandExecuteException(ex);
		}
	}


	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if(this.matchCommandName(commandWords[0])) {
			Scanner scan = new Scanner(System.in);
			if(commandWords.length < 3) {
				System.out.println("Introduzca la direccion y el numero de casillas: ");
				this.direccion = scan.next().toLowerCase();
				this.numCasillas = scan.next().toLowerCase();
			}
			else {
				this.direccion = String.valueOf(commandWords[1]);
				this.numCasillas = String.valueOf(commandWords[2]);
			}
			if (this.direccion.equals("right")) {
				this.direccion = "r";
			}
			else if (this.direccion.equals("left")) {
				this.direccion = "l";
			}
			if ((this.direccion.equals("l")||this.direccion.equals("r")) && (this.numCasillas.equals("1") || this.numCasillas.equals("2"))){
				return this;	
			}
			else {
				throw new CommandParseException("Parametros incorrectos: [m]ove <[l]eft|[r]ight><1|2>");
			}
		}
		return null;
	}
}
