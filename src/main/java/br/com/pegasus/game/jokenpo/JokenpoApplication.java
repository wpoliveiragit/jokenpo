package br.com.pegasus.game.jokenpo;

import br.com.pegasus.game.jokenpo.app.JokenpoGame;
import br.com.pegasus.game.jokenpo.infra.config.JokenpoConfig;
import br.com.pegasus.game.jokenpo.update.jplay.framework.context.JPlayApplication;

public class JokenpoApplication {

	public static void main(String[] args) throws Exception {

		JokenpoConfig jokenpoConfig = new JokenpoConfig();
		
		JPlayApplication.addBean(jokenpoConfig.createGamePort());
		JPlayApplication.run(JokenpoGame.class);
	}

}
