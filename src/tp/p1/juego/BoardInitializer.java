package tp.p1.juego;

import tp.p1.objetos.DestroyerAlien;
import tp.p1.objetos.Ovni;
import tp.p1.objetos.RegularAlien;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this. game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}
	
	private void initializeOvni () {
		Ovni ovni = new Ovni(game, -1, -1, 0);
		board.add(ovni);
	}
	
	private void initializeRegularAliens () {
		RegularAlien regular;
		switch (level) {
		
		case EASY:
			for(int i = 0; i < 4; i++ ) {
				regular = new RegularAlien(game, 1, 3+i, 2);
				board.add(regular);
			}
			break;
		case HARD:
			
			for(int i = 0; i < 4; i++ ) {
				regular = new RegularAlien(game, 1, 3+i, 2);
				board.add(regular);
			}
			for(int j = 4; j < 8; j++) {
				regular = new RegularAlien(game, 2, 3+(j-4), 2);
				board.add(regular);
			}
			break;
		case INSANE: 
			
			for(int i = 0; i < 4; i++ ) {
				regular = new RegularAlien(game, 1, 3+i, 2);
				board.add(regular);
			}
			for(int j = 4; j < 8; j++) {
				regular = new RegularAlien(game, 2, 3+(j-4), 2);
				board.add(regular);
			}
			for(int k = 8; k < 12; k++) {
				regular = new RegularAlien(game, 3, 3+(k-8), 2);
				board.add(regular);
			}
			break;
		}
	}
	
	private void initializeDestroyerAliens () {
		DestroyerAlien destroyer;
		switch (level) {
		
		case EASY:
			for(int i = 0; i < 2; i++ ) {
				destroyer = new DestroyerAlien(game, 2, 4+i, 1);
				board.add(destroyer);
			}
			break;
		case HARD:
			
			for(int i = 0; i < 4; i++ ) {
				destroyer = new DestroyerAlien(game, 3, 3+i, 1);
				board.add(destroyer);
			}
			break;
		case INSANE: 
			
			for(int i = 0; i < 4; i++ ) {
				destroyer = new DestroyerAlien(game, 4, 3+i, 1);
				board.add(destroyer);
			}
			break;
		}
	}

}
