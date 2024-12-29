package br.com.pegasus.game.jokenpo.infra.config;

import br.com.pegasus.game.jokenpo.domain.core.GameCore;
import br.com.pegasus.game.jokenpo.domain.port.GamePort;

public class JokenpoConfig {

	public GamePort createGamePort() {
		return new GameCore();
	}

}
