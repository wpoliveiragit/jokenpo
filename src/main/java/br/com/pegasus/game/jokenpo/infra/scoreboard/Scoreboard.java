package br.com.pegasus.game.jokenpo.infra.scoreboard;

import java.awt.FontMetrics;

import br.com.pegasus.game.jokenpo.domain.core.GameEngine;
import br.com.pegasus.game.jokenpo.domain.core.PlayerControl;
import br.com.pegasus.game.jokenpo.domain.entity.CartesianPoint;
import br.com.pegasus.game.jokenpo.util.constant.GameConstant;
import lombok.Getter;
import lombok.Setter;

public class Scoreboard {

	private @Getter ScoreboardPlayer player;
	private @Getter ScoreboardPlayer playerNPC;
	private @Getter @Setter int round;
	private CartesianPoint size;

	private FontMetrics font;

	public Scoreboard(PlayerControl plr, PlayerControl plrNPC) {
		size = GameEngine.getSize();
		font = GameEngine.getFont();

		player = new ScoreboardPlayer(plr, 1);
		playerNPC = new ScoreboardPlayer(plrNPC, 3);

		reset();
	}

	public void reset() {
		player.reset();
		playerNPC.reset();
		round = 0;
	}

	public void addWin(int plrWin, int npcWin) {
		player.setWins(player.getWins() + plrWin);
		playerNPC.setWins(playerNPC.getWins() + npcWin);
	}

	/** Verifica se ja foram todas as rodadas */
	public boolean isEndGame() {
		return round == GameConstant.AMOUNT_ROUTES;
	}

	/** Define como o desenho sera feiro na janela */
	public void draw() {
		player.draw();
		playerNPC.draw();
		String msg = round + "ª RODADA"; // IMPRIME A RODADA ATUAL
		GameEngine.drawText(msg, //
				(int) ((size.x / 2) - font.stringWidth(msg) / 2), // Ponto X do texto Rodada
				(int) (size.y / 4) // Ponto Y do texto Rodada
		);
	}

}
