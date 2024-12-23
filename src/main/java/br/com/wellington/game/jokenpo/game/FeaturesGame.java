package br.com.wellington.game.jokenpo.game;

import static javax.swing.JOptionPane.showMessageDialog;

import br.com.wellington.game.jokenpo.engine.GameEngine;
import br.com.wellington.game.jokenpo.engine.PlayerControl;
import br.com.wellington.game.jokenpo.engine.keyboard.GameKeyboard;
import br.com.wellington.game.jokenpo.engine.keyboard.GameListenerKeyboard;
import br.com.wellington.game.jokenpo.engine.scoreboard.Scoreboard;
import br.com.wellington.game.jokenpo.utils.CommonMethod;
import br.com.wellington.game.jokenpo.utils.ConstantsUtils;
import lombok.Getter;

public class FeaturesGame implements GameListenerKeyboard {

	private @Getter PlayerControl player; // Instancia do controle do jogador
	protected @Getter PlayerControl npcPlayer; // Instancia do controle do computador
	protected GameKeyboard keyboard;
	private @Getter Scoreboard scoreboard;

	protected boolean loop;

	private CommonMethod commonMethod2 = new CommonMethod();

	public FeaturesGame() {

		player = new PlayerControl();
		npcPlayer = new PlayerControl();
		npcPlayer.setName(ConstantsUtils.Text.PLAYER_NPC_NAME);

		keyboard = new GameKeyboard(this, GameEngine.getKeyboard());
		scoreboard = new Scoreboard(player, npcPlayer);

		loop = false;
	}

	protected void load(String name) {
		player.reset(name);

		scoreboard.reset();
		scoreboard.setRound(1);
	}

	protected void drawUpdate() {
		GameEngine.draw();
		scoreboard.draw();
		GameEngine.update();
	}

	@Override
	public void keyEsc() {
		showMessageDialog(null, ConstantsUtils.Text.KEY_ESC);
		loop = false;
	}

	@Override
	public void keyLeft() {
		player.setaEsquerda();
	}

	@Override
	public void keyHight() {
		player.setaDireita();
	}

	@Override
	public void keyEnter() {
		if (player.getSpriteData().getWin() == npcPlayer.getSpriteData().getId()) {
			// venceu a rodada
			commonMethod2.showEndGameMessage(scoreboard, 1, 0, ConstantsUtils.Text.KEY_ENTER_WIN);
			endGame();
			return;
		}
		if (player.getSpriteData().getLose() == npcPlayer.getSpriteData().getId()) {
			// perdeu a rodada
			commonMethod2.showEndGameMessage(scoreboard, 0, 1, ConstantsUtils.Text.KEY_ENTER_DEFEAT);
			endGame();
			return;
		}
		if (player.getSpriteData().getId() == npcPlayer.getSpriteData().getId()) {
			// rodada empatada
			showMessageDialog(null, ConstantsUtils.Text.KEY_ENTER_DRAW);
		}
	}

	/** Verifica se a partida acabou */
	private void endGame() {
		if (scoreboard.isEndGame()) {
			scoreboard.setRound(scoreboard.getRound() - 1);
			drawUpdate();
			if (scoreboard.getPlayer().getWins() > scoreboard.getPlayerNPC().getWins()) {
				showMessageDialogGame("Voce venceu o jogo com " + scoreboard.getPlayer().getWins() + " vitorias");
				return;
			}

			if (scoreboard.getPlayer().getWins() < scoreboard.getPlayerNPC().getWins()) {
				showMessageDialogGame("Voce perdeu o jogo com " + scoreboard.getPlayerNPC().getWins() + " derrotas");
				return;
			}
			showMessageDialogGame("Voce empatou");
		}
	}

	private void showMessageDialogGame(String msg) {
		showMessageDialog(null, msg);
		loop = false;
	}

}
