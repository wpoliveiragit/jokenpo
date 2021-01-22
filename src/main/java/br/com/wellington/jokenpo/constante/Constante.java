/** O jogo e iniciado atravez da classe main.Main */
package br.com.wellington.jokenpo.constante;

import java.awt.Font;

/**
 * Guarda as constantes necess�rias para o jogo fluir
 * 
 * @author Wellington Pires de Oliveira.
 */
public interface Constante {

	/** Tamanho maximo de caracteres que um jogador pode ter no nome. */
	public int MAX_CHAR_NAME = 7;

	/** Mensagem de boas vindas do programa */
	public String MSG_GET_NOME = "Bem vindo ao jogo Jokenpo\nDigite seu nome com ate " + MAX_CHAR_NAME + " digitos";

	/** Fonte padrao de jogos */
	public Font FONT_COMIC = new Font("Comic Sans MS", Font.TRUETYPE_FONT, 35);

	/** Caminho da sprite pedra/papel/tesoura */
	public String PATH_SPRITE = "imagens//pedra_papel_tesoura.png";

	/** Caminho da imagem de fundo do jogo */
	public String PATH_BACKGROUND = "imagens//background.png";

	/** Identificador do elemento papel */
	public int ID_PAPEL = 0;

	/** Identificador do elemento pedra */
	public int ID_PEDRA = 1;

	/** Identificador do elemento tesoura */
	public int ID_TESOURA = 2;

	/** Resuldado de resultado invalido */
	public int ERRO_RESULTADO = -30;

	/** Define quantas rodadas o jogo tera */
	public int LIMITADOR_RODADAS = 10;

}
