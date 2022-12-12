package tp.p1.juego;

import tp.p1.excepciones.FileValuesException;
import tp.p1.objetos.*;

public class GameObjectGenerator {
	
	private static GameObject[] availableGameObjects = {
			new UCMShip(),
			new Ovni(),
			new RegularAlien(),
			new DestroyerAlien(),
			new ExplosiveAlien(),
			new Shockwave(),
			new Bomb(),
			new NormalMissile(),
			new SuperMissile()
			};
	
	public static GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) throws FileValuesException {
		GameObject gameObject = null;
		for (GameObject go: availableGameObjects) {
			gameObject = go.parse(stringFromFile, game, verifier);
			if (gameObject != null) break;
		}
		return gameObject;
	}
}
