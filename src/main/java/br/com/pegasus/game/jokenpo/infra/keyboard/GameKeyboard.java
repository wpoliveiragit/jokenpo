package br.com.pegasus.game.jokenpo.infra.keyboard;

import br.com.pegasus.game.jokenpo.domain.port.GameKeyboardPort;
import br.com.pegasus.game.jokenpo.infra.comp.JokenpoControlCenterComp;
import jplay.Keyboard;

public class GameKeyboard {

	private Keyboard keyboard;
	private GameKeyboardPort gameKeyboardPort;

	public GameKeyboard(GameKeyboardPort gameKeyboardPort, JokenpoControlCenterComp controlCenter) {
		this.gameKeyboardPort = gameKeyboardPort;
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
			gameKeyboardPort.keyEsc();
			return;
		}
		if (keyboard.keyDown(Keyboard.LEFT_KEY)) {
			gameKeyboardPort.keyLeft();
			return;
		}
		if (keyboard.keyDown(Keyboard.RIGHT_KEY)) {
			gameKeyboardPort.keyHight();
			return;
		}
		if (keyboard.keyDown(Keyboard.ENTER_KEY)) {
			gameKeyboardPort.keyEnter();
			return;
		}
	}
}
