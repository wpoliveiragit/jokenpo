package br.com.pegasus.game.jokenpo.infra.constant;

import br.com.pegasus.game.jokenpo.infra.entity.SpriteData;

public interface GameConstant {

	interface Central {
		int SIZE_NAME = 8;
		int AMOUNT_ROUTES = 11;
		int AMOUNT_FRAME = 3;
		String DEFAULT_PLAYER_NAME = "JOGADOR";
		int DELAY_TIME = 50;
		String PLAYER_NPC_NAME = "NPC";
	}

	interface DataObjects {
		SpriteData PAPER = new SpriteData(Id.PAPER, 0, 1, Id.SCISSORS, Id.ROCK, Id.ROCK, Id.SCISSORS);
		SpriteData ROCK = new SpriteData(Id.ROCK, 1, 2, Id.PAPER, Id.SCISSORS, Id.SCISSORS, Id.PAPER);
		SpriteData SCISSORS = new SpriteData(Id.SCISSORS, 2, 3, Id.ROCK, Id.PAPER, Id.PAPER, Id.ROCK);
	}

	interface Path {
		String ROOT_FILES = "src/main/resources/";
		String BACKGROUND = new StringBuilder(ROOT_FILES)//
				.append("image/background.png")//
				.toString();
		String SPRITE_ROCK_PAPER_SCISSORS = new StringBuilder(ROOT_FILES)//
				.append("image/pedra_papel_tesoura.png")//
				.toString();
	}

	interface Menu {
		String WINDOW_NAME = "JOKENPO";
		String KEY_ESC = "Esta partida foi cancelada";
		String KEY_ENTER_WIN = "VITORIA";
		String KEY_ENTER_DEFEAT = "DERROTA";
		String KEY_ENTER_DRAW = "EMPATE";
		String MAIN_MENU = new StringBuilder()//
				.append("Bem vindo ao jogo Jokenpo")//
				.append("\n")//
				.append("Digite seu nome com até")//
				.append(" ")//
				.append(Central.SIZE_NAME)//
				.append(" ")//
				.append("dígitos.")//
				.toString();
	}

	interface Id {
		int PAPER = 0;
		int ROCK = 1;
		int SCISSORS = 2;
	}

}
