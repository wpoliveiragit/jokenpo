
/** O jogo e iniciado atravez da classe main.Main */
package br.com.pegasus.game.jokenpo.domain.core;

import static javax.swing.JOptionPane.showInputDialog;

import javax.swing.JOptionPane;

import br.com.pegasus.game.jokenpo.infra.method.appMethod;
import br.com.pegasus.game.jokenpo.infra.scene.FeaturesGame;
import br.com.pegasus.game.jokenpo.util.constant.GameConstant;

public class GameCore extends FeaturesGame {

	private appMethod commonMethod = new appMethod();

	public void start() {
		while (true) {
			if (mainMenu()) {
				break;
			}
			startGame();
		}
		GameEngine.exit();
	}

	private boolean mainMenu() {
		String name = showInputDialog(null, GameConstant.Text.MAIN_MENU, "JOKENPO", JOptionPane.QUESTION_MESSAGE);
		if (name == null) { // esc -> Encerra o jogo
			return true;
		}

		load(commonMethod.checkLengthName(name));
		return false;
	}

	private void startGame() {
		if (loop) {
			return;
		}
		loop = true;
		while (loop) {
			npcPlayer.setaDireita();
			GameEngine.delay(50);
			drawUpdate();
			keyboard.listener();
		}
	}

}
