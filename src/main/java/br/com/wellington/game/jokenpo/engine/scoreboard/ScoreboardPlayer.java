package br.com.wellington.game.jokenpo.engine.scoreboard;

import java.awt.FontMetrics;

import br.com.wellington.game.jokenpo.engine.GameEngine;
import br.com.wellington.game.jokenpo.engine.PlayerControl;
import br.com.wellington.game.jokenpo.utils.ClassUtils.CartesianPoint;
import jplay.Sprite;
import lombok.Getter;
import lombok.Setter;

public class ScoreboardPlayer {

	private PlayerControl player;
	private @Setter @Getter int wins;
	private CartesianPoint namePoint;
	private CartesianPoint winPoint;
	private int position;

	public ScoreboardPlayer(PlayerControl player, int position) {
		this.player = player;
		this.position = position;
		namePoint = new CartesianPoint();
		winPoint = new CartesianPoint();
		setScoreboardPlayer();
	}

	public void reset() {
		wins = 0;
		setScoreboardPlayer();
	}

	public void draw() {
		player.draw();
		GameEngine.drawText(player.getName(), namePoint);
		GameEngine.drawText("" + wins, winPoint);
	}

	private void setScoreboardPlayer() {
		FontMetrics font = GameEngine.getFont();
		CartesianPoint size = GameEngine.getSize();
		Sprite sprite = player.getSprite();

		int width = (size.getXInt() / 4) * position;
		int height = (size.getYInt() / 2);
		int heightCenter = sprite.height / 2;
		int fontHeight = font.getHeight();

		// set sprite
		sprite.setX(width - (sprite.width / 2));
		sprite.setY(height - heightCenter);

		// set name
		namePoint.x = width - (font.stringWidth(player.getName()) / 2);
		namePoint.y = height + heightCenter + fontHeight;

		// set win
		winPoint.x = width - (font.stringWidth("X") / 2);
		winPoint.y = height + heightCenter + fontHeight * 2;
	}
	

}
