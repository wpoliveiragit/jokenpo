package br.com.pegasus.game.jokenpo.infra.method;

import static javax.swing.JOptionPane.showMessageDialog;

import br.com.pegasus.game.jokenpo.domain.entity.SpriteData;
import br.com.pegasus.game.jokenpo.infra.scoreboard.Scoreboard;
import br.com.pegasus.game.jokenpo.util.constant.GameConstant;

public class appMethod implements GameConstant {
	
	private static final String DEFAULT_PLAYER_NAME = "JOGADOR";

	private SpriteData PAPER = new SpriteData(Id.PAPER, 0, 1, Id.SCISSORS, Id.ROCK, Id.ROCK, Id.SCISSORS);
	private SpriteData ROCK = new SpriteData(Id.ROCK, 1, 2, Id.PAPER, Id.SCISSORS, Id.SCISSORS, Id.PAPER);
	private SpriteData SCISSORS = new SpriteData(Id.SCISSORS, 2, 3, Id.ROCK, Id.PAPER, Id.PAPER, Id.ROCK);

	public void showEndGameMessage(Scoreboard scoreboard, int addPlayer, int addPlayerNpc, String msg) {
		showMessageDialog(null, msg);
		scoreboard.addWin(addPlayer, addPlayerNpc);
		scoreboard.setRound(scoreboard.getRound() + 1);
	}

	public String checkLengthName(String name) {
		if (name.isBlank()) { // NOME EM BRANCO
			return DEFAULT_PLAYER_NAME;
		}

		if (name.length() > SIZE_NAME) {// NOME MUITO GRANDE
			return name.substring(0, GameConstant.SIZE_NAME).toUpperCase();
		}
		return name.toUpperCase();
	}

	public SpriteData getSpriteData(int id) {
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
