package br.com.pegasus.game.jokenpo.infra.comp;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;
import br.com.pegasus.game.jokenpo.infra.util.JokenpoPointUtil;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;
import lombok.Getter;

public final class JokenpoControlCenterComp {

	public static final JokenpoControlCenterComp INSTANCE = new JokenpoControlCenterComp();

	private Window window;
	private GameImage background;

	private @Getter FontMetrics font;
	private @Getter JokenpoPointUtil size;
	private @Getter Keyboard keyboard;

	private JokenpoControlCenterComp() {
		background = new GameImage(GameConstant.Path.BACKGROUND);
		window = new Window(background.width, background.height);
		window.setFont(new Font("Comic Sans MS", Font.TRUETYPE_FONT, 35));
		font = window.getGraphics().getFontMetrics();
		size = new JokenpoPointUtil(window.getWidth(), window.getHeight());
		keyboard = window.getKeyboard();
	}

	public void drawText(String text, JokenpoPointUtil point) {
		window.drawText(text, point.getXInt(), point.getYInt(), Color.black);
	}

	public void drawText(String text, int x, int y) {
		window.drawText(text, x, y, Color.black);
	}

	public void delay() {
		window.delay(GameConstant.Central.DELAY_TIME);
	}

	public void draw() {
		background.draw();
	}

	public void update() {
		window.update();
	}

	public void reset() {
		window.clear(Color.cyan);
		window.update();
	}

	public void exit() {
		window.exit();
	}

}
