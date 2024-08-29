package br.com.wellington.game.jokenpo.utils;

import static javax.swing.JOptionPane.showMessageDialog;

import br.com.wellington.game.jokenpo.engine.scoreboard.Scoreboard;
import br.com.wellington.game.jokenpo.utils.ClassUtils.SpriteData;

public class CommonMethod implements ConstantsUtils {

	private static SpriteData PAPER = new SpriteData(Id.PAPER, 0, 1, Id.SCISSORS, Id.ROCK, Id.ROCK, Id.SCISSORS);
	private static SpriteData ROCK = new SpriteData(Id.ROCK, 1, 2, Id.PAPER, Id.SCISSORS, Id.SCISSORS, Id.PAPER);
	private static SpriteData SCISSORS = new SpriteData(Id.SCISSORS, 2, 3, Id.ROCK, Id.PAPER, Id.PAPER, Id.ROCK);

	public static final void showEndGameMessage(Scoreboard scoreboard, int addPlayer, int addPlayerNpc, String msg) {
		showMessageDialog(null, msg);
		scoreboard.addWin(addPlayer, addPlayerNpc);
		scoreboard.setRound(scoreboard.getRound() + 1);
	}

	public static final String checkLengthName(String name) {
		if (name.equals("")) { // nome em branco
			return ConstantsUtils.Text.DEFAULT_PLAYER_NAME;
		}

		if (name.length() > SIZE_NAME) {// nome muito grande
			return name.substring(0, ConstantsUtils.SIZE_NAME).toUpperCase();
		}
		return name.toUpperCase();
	}

	public static final SpriteData getSpriteData(int id) {
		switch (id) {
		case Id.PAPER:
			return PAPER;
		case Id.ROCK:
			return ROCK;
		default:
			return SCISSORS;
		}
	}

}
