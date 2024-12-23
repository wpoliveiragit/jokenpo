
/** O jogo e iniciado atravez da classe main.Main */
package br.com.wellington.game.jokenpo.game;

import static javax.swing.JOptionPane.showInputDialog;

import javax.swing.JOptionPane;

import br.com.wellington.game.jokenpo.engine.GameEngine;
import br.com.wellington.game.jokenpo.utils.CommonMethod;
import br.com.wellington.game.jokenpo.utils.ConstantsUtils;
import br.com.wellington.game.jokenpo.utils.InterfaceUtils.StartGame;

public class JokenpoGame extends FeaturesGame implements StartGame {

	private CommonMethod commonMethod2 = new CommonMethod();
	
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
		String name = showInputDialog(null, ConstantsUtils.Text.MAIN_MENU, "JOKENPO", JOptionPane.QUESTION_MESSAGE);
		if (name == null) { // esc -> Encerra o jogo
			return true;
		}

		load(commonMethod2.checkLengthName(name));
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
