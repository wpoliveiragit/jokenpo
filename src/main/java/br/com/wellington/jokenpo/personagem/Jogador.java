/** O jogo e iniciado atravez da classe main.Main */
package br.com.wellington.jokenpo.personagem;

import java.awt.Color;
import java.awt.FontMetrics;

import br.com.wellington.jokenpo.constante.Constante;
import br.com.wellington.jokenpo.view.JogoView;
import jplay.Sprite;

/**
 * Classe de controle de personagem
 * 
 * @author Wellington Pires de Oliveira.
 */
public class Jogador implements Constante {

	/** Nome do jogador */
	private String nome;

	/** local onde o nome sera desenhado */
	private Ponto pontoNome;

	/** A escolha do elemento pedra, papel ou tesoura */
	private int escolha;

	/** Registra as vitorias do jogador. */
	private int vitorias;

	/** Local onde as vitorias correntes sera impressa */
	private Ponto pontoVitoria;

	private Sprite sprite;

	/**
	 * Cria um novo personagem para o jogo.
	 * 
	 * @param nome O nome do personagem.
	 */
	public Jogador(String nome) {
		sprite = new Sprite(PATH_SPRITE, 3);
		pontoNome = new Ponto();
		pontoVitoria = new Ponto();
		this.nome = nome;
		escolha = ID_PAPEL;
		vitorias = 0;
		setXY(sprite.x, sprite.y);
		setPontoVitorias();
		setImg();
	}

	/**
	 * Configura um novo local para a imagem.
	 * 
	 * @param x ponto do eixo x.
	 * @param y Ponto do eixo y.
	 */
	public final void setXY(double x, double y) {
		sprite.x = x;
		sprite.y = y;

		FontMetrics font = JogoView.getInstancia().getGraphics().getFontMetrics();
		pontoNome.x = sprite.x + (sprite.width - font.stringWidth(nome)) / 2;
		pontoNome.y = (sprite.y + sprite.height) + font.getHeight();
		setPontoVitorias();
	}

	/** Ajusta o quadro da sprite */
	private void setImg() {
		switch (escolha) {
		case ID_PAPEL:
			sprite.setSequence(0, 1);
			break;
		case ID_PEDRA:
			sprite.setSequence(1, 2);
			break;
		case ID_TESOURA:
			sprite.setSequence(2, 3);
		}
	}

	/** Avanca um elemento */
	public void moveDireita() {
		if (++escolha == 3)
			escolha = 0;
		setImg();
	}

	/** Retorna um elemento **/
	public void moveEsquerda() {
		if (--escolha == -1)
			escolha = 2;
		setImg();
	}

	/** Adiciona um ponto na vitoria do jogador */
	public void addVitoria() {
		vitorias++;
		setPontoVitorias();
	}

	/** Posiciona o local onde sera impressa as vitorias correntes */
	private void setPontoVitorias() {
		FontMetrics font = JogoView.getInstancia().getGraphics().getFontMetrics();
		pontoVitoria.x = sprite.x + (sprite.width - font.stringWidth(vitorias + "")) / 2;
		pontoVitoria.y = pontoNome.y + font.getHeight();
	}

	/** Imprime o desenho na janela. */
	public void draw() {
		sprite.draw();
		JogoView.getInstancia().drawText(nome, (int) pontoNome.x, (int) pontoNome.y, Color.black);
		JogoView.getInstancia().drawText("" + vitorias, (int) pontoVitoria.x, (int) pontoVitoria.y, Color.black);
	}

	/** Retorna as vitorias que o jogador obteve na partida. */
	public int getVitorias() {
		return vitorias;
	}

	/** Retorna o nome do jogador. */
	public String getNome() {
		return nome;
	}

	/** Retorna a escolha corrente. */
	public int getEscolha() {
		return escolha;
	}

	/** Retorna a sprite. */
	public Sprite getSprite() {
		return sprite;
	}

	private class Ponto {
		double x;
		double y;
	}

}
