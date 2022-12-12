package tp.p1.controller;
import java.io.IOException;

import tp.p1.excepciones.CommandExecuteException;
import tp.p1.excepciones.CommandParseException;
import tp.p1.juego.Game;

public abstract class Command {
	
	protected final String name;
	protected final String shortcut;
	private final String details ;
	private final String help;

	
	public Command(String name, String shortcut, String details, String help){
	this.name = name;
	this.shortcut = shortcut;
	this.details = details;
	this.help = help;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException, IOException;
	
	public Command parse(String[] commandWords) throws CommandParseException {
		if(this.matchCommandName(commandWords[0])) {
			return this;
		}
		else {
			return null;
			
		}
	}
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) ||
				this.name.equalsIgnoreCase(name);
	}
	public String helpText(){
		return details + ": " + help + "\n";
	}

}
