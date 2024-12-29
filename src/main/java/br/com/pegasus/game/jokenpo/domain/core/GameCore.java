
/** O jogo e iniciado atravez da classe main.Main */
package br.com.pegasus.game.jokenpo.domain.core;

import static javax.swing.JOptionPane.showMessageDialog;

import br.com.pegasus.game.jokenpo.domain.port.GamePort;
import br.com.pegasus.game.jokenpo.infra.comp.JokenpoControlCenterComp;
import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;
import br.com.pegasus.game.jokenpo.infra.entity.PlayerEntity;
import br.com.pegasus.game.jokenpo.infra.keyboard.GameKeyboard;
import br.com.pegasus.game.jokenpo.infra.keyboard.GameListenerKeyboard;
import br.com.pegasus.game.jokenpo.infra.menu.DialogBox;
import br.com.pegasus.game.jokenpo.infra.method.GameMethod;
import br.com.pegasus.game.jokenpo.infra.scoreboard.JokenpoScoreboard;

public class GameCore implements GamePort, GameListenerKeyboard {

	private JokenpoControlCenterComp controlCenter;
	private GameKeyboard keyboard;
	private boolean loop;
	private DialogBox dialogBox;

	private PlayerEntity player;
	private PlayerEntity npcPlayer;
	private JokenpoScoreboard scoreboard;

	public GameCore() {
		controlCenter = JokenpoControlCenterComp.INSTANCE;
		dialogBox = new DialogBox();
		player = new PlayerEntity();
		npcPlayer = new PlayerEntity();
		npcPlayer.setName(GameConstant.Central.PLAYER_NPC_NAME);
		keyboard = new GameKeyboard(this, controlCenter);
		scoreboard = new JokenpoScoreboard(player, npcPlayer);
		loop = false;
	}

	@Override
	public void init() {
		while (true) {
			if (mainMenu()) {
				break;
			}
			startGame();
		}
		controlCenter.exit();
	}

	private boolean mainMenu() {
		String name = dialogBox.welcome();
		if (name == null) {
			return true;
		}

		load(GameMethod.checkLengthName(name));
		return false;
	}

	private void startGame() {
		if (loop) {
			return;
		}
		loop = true;
		while (loop) {
			npcPlayer.setaDireita();
			controlCenter.delay();
			drawUpdate();
			keyboard.listener();
		}
	}

	protected void load(String name) {
		player.init(name);

		scoreboard.reset();
		scoreboard.setRound(1);
	}

	protected void drawUpdate() {
		controlCenter.draw();
		scoreboard.draw();
		controlCenter.update();
	}

	@Override
	public void keyEsc() {
		dialogBox.gameCanceled();
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
			GameMethod.showEndGameMessage(scoreboard, 1, 0, GameConstant.Menu.KEY_ENTER_WIN);
			endGame();
			return;
		}
		if (player.getSpriteData().getLose() == npcPlayer.getSpriteData().getId()) {
			// perdeu a rodada
			GameMethod.showEndGameMessage(scoreboard, 0, 1, GameConstant.Menu.KEY_ENTER_DEFEAT);
			endGame();
			return;
		}
		if (player.getSpriteData().getId() == npcPlayer.getSpriteData().getId()) {
			// rodada empatada
			showMessageDialog(null, GameConstant.Menu.KEY_ENTER_DRAW);
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
