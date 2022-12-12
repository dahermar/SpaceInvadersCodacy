package tp.p1.excepciones;

public class CommandExecuteException extends Exception{
	public CommandExecuteException() { super();}
	public CommandExecuteException(String message){ super(message);}
	public CommandExecuteException(Throwable cause){ super(cause);}
}
