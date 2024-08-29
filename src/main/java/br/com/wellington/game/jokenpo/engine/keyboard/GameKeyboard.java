package br.com.wellington.game.jokenpo.engine.keyboard;

import jplay.Keyboard;

public class GameKeyboard {

	private Keyboard keyboard;
	private GameListenerKeyboard keyboardGameListener;

	public GameKeyboard(GameListenerKeyboard keyboardGameListener, Keyboard keyboard) {
		this.keyboardGameListener = keyboardGameListener;
		keyboard.addKey(Keyboard.LEFT_KEY);
		keyboard.addKey(Keyboard.RIGHT_KEY);
		keyboard.addKey(Keyboard.UP_KEY);
		keyboard.addKey(Keyboard.DOWN_KEY);
		this.keyboard = keyboard;
	}

	public void listener() {
		if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			keyboardGameListener.keyEsc();
			return;
		}
		if (keyboard.keyDown(Keyboard.LEFT_KEY)) {
			keyboardGameListener.keyLeft();
			return;
		}
		if (keyboard.keyDown(Keyboard.RIGHT_KEY)) {
			keyboardGameListener.keyHight();
			return;
		}
		if (keyboard.keyDown(Keyboard.ENTER_KEY)) {
			keyboardGameListener.keyEnter();
			return;
		}
	}
}
