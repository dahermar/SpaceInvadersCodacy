package tp.p1.controller;

import java.util.Scanner;

import tp.p1.excepciones.AlreadyExistsMissileException;
import tp.p1.excepciones.CommandExecuteException;
import tp.p1.excepciones.CommandParseException;
import tp.p1.excepciones.NotSupermissileException;
import tp.p1.juego.Game;

public class ShootCommand extends Command{

	private String TipoDisparo; //Sirve para seber cual de los dos disparos realiza
	
	public ShootCommand() {
		super("shoot", "s", "[s]hoot <[n]normal|[s]uper>", "La nave del jugador realiza un disparo normal o super");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try{
			if(this.TipoDisparo.equals("n")) {

			game.shootMissile();
			return true;
			}
			else if(this.TipoDisparo.equals("s")){
				game.shootSuperMissile();
				return true;
			}
			return false;
		}
		catch(AlreadyExistsMissileException | NotSupermissileException ex) {
			throw new CommandExecuteException(ex);
		}
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {	
		if(this.matchCommandName(commandWords[0])) {
			Scanner scan = new Scanner(System.in);
			if(commandWords.length < 2) {
				System.out.println("Introduzca el tipo de misil que desea disparar (<N>: Normal | <S>: Super): ");
				this.TipoDisparo = scan.next().toLowerCase();
			}
			else {
				this.TipoDisparo = String.valueOf(commandWords[1]);
			}
			if (this.TipoDisparo.equals("normal")) {
				this.TipoDisparo = "n";
			}
			else if (this.TipoDisparo.equals("super")) {
				this.TipoDisparo = "s";
			}
			if (this.TipoDisparo.equals("n")||this.TipoDisparo.equals("s")){
				return this;
			}
			else {
				throw new CommandParseException("Parametros incorrectos: [s]hoot <[n]normal|[s]uper>");
			}
		}
		return null;
	}
}
