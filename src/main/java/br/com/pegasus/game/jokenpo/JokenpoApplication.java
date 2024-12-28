package br.com.pegasus.game.jokenpo;

import br.com.pegasus.game.jokenpo.domain.core.GameCore;
import br.com.pegasus.game.jokenpo.domain.core.GameEngine;

public class JokenpoApplication {

	// Create: 21/01/22
	// Update: 29/08/24
	// Update:
	public static void main(String[] args) throws Exception {
		GameEngine.createEngine();
		new GameCore().start();
	}

}
