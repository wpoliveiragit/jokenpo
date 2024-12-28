package br.com.pegasus.game.jokenpo.domain.core;

import java.awt.Color;
import java.awt.FontMetrics;

import br.com.pegasus.game.jokenpo.domain.entity.CartesianPoint;
import br.com.pegasus.game.jokenpo.util.constant.GameConstant;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public final class GameEngine {

	private static Window INSTANCE;
	private static GameImage BACKGROUND;
	private static FontMetrics FONT;
	private static CartesianPoint SIZE;
	private static Keyboard KEYBOARD;

	public static final void createEngine() throws Exception {
		BACKGROUND = new GameImage(GameConstant.Path.BACKGROUND);
		INSTANCE = new Window(BACKGROUND.width, BACKGROUND.height);
		INSTANCE.setFont(GameConstant.FONT);
		FONT = INSTANCE.getGraphics().getFontMetrics();
		SIZE = new CartesianPoint(INSTANCE.getWidth(), INSTANCE.getHeight());
		KEYBOARD = INSTANCE.getKeyboard();
	}

	// METHODS
	public static void drawText(String text, CartesianPoint point) {
		INSTANCE.drawText(text, point.getXInt(), point.getYInt(), Color.black);
	}

	public static void drawText(String text, int x, int y) {
		INSTANCE.drawText(text, x, y, Color.black);
	}

	public static void delay(int time) {
		INSTANCE.delay(time);
	}

	public static void draw() {
		BACKGROUND.draw();
	}

	public static void update() {
		INSTANCE.update();
	}

	public static void reset() {
		INSTANCE.clear(Color.cyan);
		INSTANCE.update();
	}

	public static final void exit() {
		INSTANCE.exit();
	}

	// GETTERS
	public static Keyboard getKeyboard() {
		return KEYBOARD;
	}

	public static FontMetrics getFont() {
		return FONT;
	}

	public static CartesianPoint getSize() {
		return SIZE;
	}

}
