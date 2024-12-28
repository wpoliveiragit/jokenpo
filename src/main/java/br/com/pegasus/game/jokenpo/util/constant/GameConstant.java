package br.com.pegasus.game.jokenpo.util.constant;

import java.awt.Font;

public interface GameConstant {

	int SIZE_NAME = 8; // Tamanho do nome.
	Font FONT = new Font("Comic Sans MS", Font.TRUETYPE_FONT, 35);// Fonte padrao de jogos
	int AMOUNT_ROUTES = 11;// Define quantas rodadas o jogo tera
	int AMOUNT_FRAME = 3;// quantidade de imagens na sprite

	interface Path {
		String ROOT_PATH_FILES = "src/main/resources/";
		String BACKGROUND = ROOT_PATH_FILES + "image/background.png";
	}

	interface Text {
		String PLAYER_NPC_NAME = "NPC";
		String KEY_ESC = "Esta partida foi cancelada";
		String KEY_ENTER_WIN = "VITORIA";
		String KEY_ENTER_DEFEAT = "DERROTA";
		String KEY_ENTER_DRAW = "EMPATE";
		String MAIN_MENU = "Bem vindo ao jogo Jokenpo\nDigite seu nome com até " + SIZE_NAME + " digitos";
	}

	interface Id {
		int PAPER = 0; // Identificador do elemento papel
		int ROCK = 1;// Identificador do elemento pedra
		int SCISSORS = 2; // Identificador do elemento tesoura
	}

}
