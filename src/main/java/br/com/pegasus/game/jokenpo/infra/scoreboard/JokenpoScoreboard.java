package br.com.pegasus.game.jokenpo.infra.scoreboard;

import java.awt.FontMetrics;

import br.com.pegasus.game.jokenpo.infra.comp.JokenpoControlCenterComp;
import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;
import br.com.pegasus.game.jokenpo.infra.entity.PlayerEntity;
import br.com.pegasus.game.jokenpo.infra.util.JokenpoPointUtil;
import lombok.Getter;
import lombok.Setter;

public class JokenpoScoreboard {

	private JokenpoControlCenterComp controlCenter = JokenpoControlCenterComp.INSTANCE;
	
	private JokenpoPointUtil size;
	private FontMetrics font;

	private @Getter @Setter int round;
	private @Getter JokenpoPlayerScoreboard player;
	private @Getter JokenpoPlayerScoreboard playerNPC;

	public JokenpoScoreboard(PlayerEntity plr, PlayerEntity plrNPC) {
		size = controlCenter.getSize();
		font = controlCenter.getFont();

		player = new JokenpoPlayerScoreboard(plr, 1);
		playerNPC = new JokenpoPlayerScoreboard(plrNPC, 3);

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
		return round == GameConstant.Central.AMOUNT_ROUTES;
	}

	/** Define como o desenho sera feiro na janela */
	public void draw() {
		player.draw();
		playerNPC.draw();
		String msg = new StringBuilder().append(round).append("ª RODADA").toString(); 
		controlCenter.drawText(msg, //
				(int) ((size.x / 2) - font.stringWidth(msg) / 2), // Ponto X do texto Rodada
				(int) (size.y / 4) // Ponto Y do texto Rodada
		);
	}

}
