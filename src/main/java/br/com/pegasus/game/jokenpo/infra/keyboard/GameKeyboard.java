package br.com.pegasus.game.jokenpo.infra.keyboard;

import br.com.pegasus.game.jokenpo.infra.comp.JokenpoControlCenterComp;
import jplay.Keyboard;

public class GameKeyboard {

	private Keyboard keyboard;
	private GameListenerKeyboard gameListenerKeyboard;

	public GameKeyboard(GameListenerKeyboard gameListenerKeyboard, JokenpoControlCenterComp controlCenter) {
		this.gameListenerKeyboard = gameListenerKeyboard;
		this.keyboard = controlCenter.getKeyboard();
		config();
	}

	private void config() {
		keyboard.addKey(Keyboard.LEFT_KEY);
		keyboard.addKey(Keyboard.RIGHT_KEY);
		keyboard.addKey(Keyboard.UP_KEY);
		keyboard.addKey(Keyboard.DOWN_KEY);
	}

	public void listener() {
		if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			gameListenerKeyboard.keyEsc();
			return;
		}
		if (keyboard.keyDown(Keyboard.LEFT_KEY)) {
			gameListenerKeyboard.keyLeft();
			return;
		}
		if (keyboard.keyDown(Keyboard.RIGHT_KEY)) {
			gameListenerKeyboard.keyHight();
			return;
		}
		if (keyboard.keyDown(Keyboard.ENTER_KEY)) {
			gameListenerKeyboard.keyEnter();
			return;
		}
	}
}
