package br.com.pegasus.game.jokenpo.infra.scoreboard;

import java.awt.FontMetrics;

import br.com.pegasus.game.jokenpo.infra.comp.JokenpoControlCenterComp;
import br.com.pegasus.game.jokenpo.infra.entity.PlayerEntity;
import br.com.pegasus.game.jokenpo.infra.util.JokenpoPointUtil;
import jplay.Sprite;
import lombok.Getter;
import lombok.Setter;

public class JokenpoPlayerScoreboard {

	private JokenpoControlCenterComp controlCenter = JokenpoControlCenterComp.INSTANCE;

	private PlayerEntity player;
	private @Setter @Getter int wins;
	private JokenpoPointUtil namePoint;
	private JokenpoPointUtil winPoint;
	private int position;

	public JokenpoPlayerScoreboard(PlayerEntity player, int position) {
		this.player = player;
		this.position = position;
		namePoint = new JokenpoPointUtil();
		winPoint = new JokenpoPointUtil();
		setScoreboardPlayer();
	}

	public void reset() {
		wins = 0;
		setScoreboardPlayer();
	}

	public void draw() {
		player.draw();
		controlCenter.drawText(player.getName(), namePoint);
		controlCenter.drawText("" + wins, winPoint);
	}

	private void setScoreboardPlayer() {
		FontMetrics font = controlCenter.getFont();
		JokenpoPointUtil size = controlCenter.getSize();
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
