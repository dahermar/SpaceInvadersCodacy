package tp.p1.juego;

import tp.p1.objetos.GameObject;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
	 objects = new GameObject[width*height];
	 currentObjects = 0;
	}
	
	public int getCurrentObjects () {
		return currentObjects;
	}
	
	public void add (GameObject object) {
	 objects[this.currentObjects] = object;
	 this.currentObjects++;
	}
	
	private GameObject getObjectInPosition(int x, int y) {
		GameObject object = null;
		for (int i = 0; i < this.currentObjects; i++) {
			if (objects[i].getX() == x && objects[i].getY() == y) {
				object = objects[i];
			}
		}
		return object;
	}
	
	
	private void remove (int i) { 
		for (int j = i; j < this.currentObjects; j++) {
				objects[j] = objects[j+1];
			}
			this.currentObjects--;
	}
	
	public void update() {
		move();
		for (int i = this.currentObjects - 1; i >= 0; i--) {
			checkAttacks(objects[i]);
		}
		removeDead();
	}
	
	private void move() {
		for (int i = 0; i < this.currentObjects; i++) {
			objects[i].move();
		}
	}
	
	public void checkAttacks(GameObject object) {
		for (int i = this.currentObjects - 1; i >= 0; i--) {
			object.performAttack(objects[i]);
		}
	}
	
	public void computerAction() {
		for (int i = 0; i < this.currentObjects; i++) {
			objects[i].computerAction();
		}
	}
	
	private void removeDead() {
		for (int i = this.currentObjects - 1; i >= 0; i--) {
			if(!objects[i].isAlive()) {
				objects[i].onDelete();
				remove(i);
				
			}
		}
	}
	
	public String toString(int x, int y) {
		GameObject object = getObjectInPosition(x, y);
		if(object == null) {
			return "";
		}
		return object.toString();
	
	}

	public String toString() {
		String string = "";
		for(int i = 0; i < this.currentObjects; i++) {
			if(objects[i].isAlive()) {
				string += objects[i].toStringified(); 
			}
		}
		return string;
		
	}

	public void removeAllObjects() {
		this.currentObjects = 0;
	}

	public GameObject getLabelOwner(int ownerRef) {
		for(int i = 0; i < this.currentObjects; i++) {
			if (objects[i].isOwner(ownerRef)) {
				return objects[i];
			}
		}
		return null;
	}
}
