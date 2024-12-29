package br.com.pegasus.game.jokenpo.infra.method;

import static javax.swing.JOptionPane.showMessageDialog;

import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;
import br.com.pegasus.game.jokenpo.infra.constant.GameConstant.Id;
import br.com.pegasus.game.jokenpo.infra.entity.SpriteData;
import br.com.pegasus.game.jokenpo.infra.scoreboard.JokenpoScoreboard;

public class GameMethod {

	public static final SpriteData getSpriteData(int id) {
		switch (id) {
		case Id.PAPER:
			return GameConstant.DataObjects.PAPER;
		case Id.ROCK:
			return GameConstant.DataObjects.ROCK;
		case Id.SCISSORS:
			return GameConstant.DataObjects.SCISSORS;
		}
		throw new RuntimeException("ID não encontrado");
	}

	public static final String checkLengthName(String name) {
		if (name.isBlank()) {
			return GameConstant.Central.DEFAULT_PLAYER_NAME;
		}

		if (name.length() > GameConstant.Central.SIZE_NAME) {
			return name.substring(0, GameConstant.Central.SIZE_NAME).toUpperCase();
		}
		return name.toUpperCase();
	}

	public static void showEndGameMessage(JokenpoScoreboard scoreboard, int addPlayer, int addPlayerNpc, String msg) {
		showMessageDialog(null, msg);
		scoreboard.addWin(addPlayer, addPlayerNpc);
		scoreboard.setRound(scoreboard.getRound() + 1);
	}
}
