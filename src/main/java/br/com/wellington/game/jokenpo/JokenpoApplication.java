package br.com.wellington.game.jokenpo;

import br.com.wellington.game.jokenpo.engine.GameEngine;
import br.com.wellington.game.jokenpo.game.JokenpoGame;

public class JokenpoApplication {

	// Create: 21/01/22
	// Update: 29/08/24
	// Update:
	public static void main(String[] args) throws Exception {
		GameEngine.createEngine();
		new JokenpoGame().start();
	}

}
