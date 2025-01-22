package br.com.pegasus.game.jokenpo.app;

import br.com.pegasus.game.jokenpo.domain.port.GamePort;
import br.com.pegasus.game.jokenpo.update.jplay.framework.StartgGameSetup;

public class JokenpoGame {

	@StartgGameSetup
	public void start(GamePort gameCore) {
		gameCore.init();
	}

}
