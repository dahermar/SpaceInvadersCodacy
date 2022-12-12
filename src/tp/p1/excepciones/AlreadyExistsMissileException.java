package tp.p1.excepciones;

public class AlreadyExistsMissileException extends Exception{
	public AlreadyExistsMissileException() { super("No se ha podido disparar: Ya existe un misil");}
}
