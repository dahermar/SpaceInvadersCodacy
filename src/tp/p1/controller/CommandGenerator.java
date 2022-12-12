package tp.p1.controller;

import tp.p1.excepciones.CommandParseException;

public class CommandGenerator {
	private static Command[] Comandos = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ShootCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new BuySuperMissile(),
			new StringifyCommand(),
			new ListPrintersCommand(),
			new SaveCommand(),
			new LoadCommand()
			};
	
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		Command comando = null;
		int i = 0;
		while(i < Comandos.length) {
			comando = Comandos[i].parse(commandWords);
			if (comando != null) {
				return comando;
			}
			i++;
		}
		throw new CommandParseException("Comando inexistente");
	}
	
	public static String commandHelp() {
		String help = "";
		for(int i =0; i < Comandos.length; i++) {
			help = help + "\n" + Comandos[i].helpText();
		}
		return help;
	}
}
