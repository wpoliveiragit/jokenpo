package br.com.wellington.game.jokenpo;

import br.com.wellington.game.jokenpo.engine.GameEngine;
import br.com.wellington.game.jokenpo.game.JokenpoGame;

public class JokenpoApplication {

	/* Criado em 21/01/22 */
	/* Alterado em 29/08/24 */

	public static void main(String[] args) throws Exception {
		GameEngine.createEngine(JokenpoGame.class);
	}

}
