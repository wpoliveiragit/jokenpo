package br.com.wellington.jokenpo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wellington.jokenpo.view.JogoView;

@SpringBootApplication
public class JokenpoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(JokenpoApplication.class, args);
		new JogoView().start();
	}

}
