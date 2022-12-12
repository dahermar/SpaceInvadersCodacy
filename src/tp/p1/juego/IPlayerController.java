package tp.p1.juego;

import java.io.BufferedReader;
import java.io.IOException;

import tp.p1.excepciones.AlreadyExistsMissileException;
import tp.p1.excepciones.FileContentsException;
import tp.p1.excepciones.NotEnoughPointsException;
import tp.p1.excepciones.NotShockwaveException;
import tp.p1.excepciones.NotSupermissileException;
import tp.p1.excepciones.OutOfBoardException;

public interface IPlayerController {
	// PLAYER ACTIONS
	public void movePlayer (String direccion, int numCells) throws OutOfBoardException;
	public void shootMissile() throws AlreadyExistsMissileException;
	public void shockWave() throws NotShockwaveException;
	public void shootSuperMissile() throws AlreadyExistsMissileException, NotSupermissileException;
	public void buySuperMissile() throws NotEnoughPointsException;
	public void reset();
	public void load(BufferedReader archivo) throws IOException, FileContentsException;
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();

}
