package tp.p1.objetos;

import tp.p1.juego.Game;

public interface IExecuteRandomActions {
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
	static boolean canGenerateRandomExplosive(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getTurnExplodeFrequency();
	}
		
}
