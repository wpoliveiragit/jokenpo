
/** O jogo e iniciado atravez da classe main.Main */
package br.com.wellington.jokenpo.view;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;

import javax.swing.JOptionPane;

import br.com.wellington.jokenpo.constante.Constante;
import br.com.wellington.jokenpo.personagem.Jogador;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

/**
 * Controla toda mec�nica do jogo.
 * 
 * ROTINA:
 * 
 * Passo 1- Apresenta e solicita um nome para o jogador e esc finaliza o
 * jogo<br>
 * Passo 2- Inicia o jogo:<br>
 * SETAS para esquerda ou pra direita: troca o elemento a ser escolhido.<br>
 * ENTER: escolhe o elemento.<br>
 * ESC: finaliza a partida.<br>
 * Passo 3- Apos 10 rodadas e apresentado o resultado do jogo.<br>
 * Passo 4- Volta ao Passo 1
 * 
 * @author Wellington Pires de Oliveira.
 */
public class JogoView implements Constante {

	/** Registra a rodada corrente da partida */
	private static int RODADA;

	/** Constante de controle da interface do jogo */
	private static Window INSTANCIA = null;

	private static GameImage background;

	/** Instancia do controle do jogador */
	private Jogador j1;

	/** Instancia do controle do computador */
	private Jogador j2;

	/** Instancia todo o controle do jogo. */
	public JogoView() {
		if (INSTANCIA != null) {
			return;
		}
		background = new GameImage(PATH_BACKGROUND);
		INSTANCIA = new Window(background.width, background.height);

		// configuracao da fonte dos textos do jogo
		INSTANCIA.setFont(FONT_COMIC);
		// Prepara as chaves de controle do teclado
		INSTANCIA.getKeyboard().addKey(Keyboard.LEFT_KEY);
		INSTANCIA.getKeyboard().addKey(Keyboard.RIGHT_KEY);
		INSTANCIA.getKeyboard().addKey(Keyboard.UP_KEY);
		INSTANCIA.getKeyboard().addKey(Keyboard.DOWN_KEY);
	}

	/**
	 * Retorna o controle do view do jogo.
	 * 
	 * @return O controle do view do jogo.
	 */
	public static Window getInstancia() {
		return INSTANCIA;
	}

	/**
	 * Emite ums mensagem referente ao resultado da rodada, adiciona +1 na vitoria
	 * se ouver vencedor e avanca a rodada caso nou exista emate.
	 * 
	 * @param ganha
	 * @param perde
	 */
	private void revelaResultado(int ganha, final int perde) {
		int res = j1.getEscolha() - j2.getEscolha();
		if (res == ganha) {
			RODADA++;
			j1.addVitoria();
			showMessageDialog(null, "VITORIA");
			return;
		}
		if (res == perde) {
			RODADA++;
			j2.addVitoria();
			showMessageDialog(null, "DERROTA");
			return;
		}
		if (res == 0) {
			showMessageDialog(null, "EMPATE");
			return;
		}
		String msg = "Erro falal - resultado invalido {";
		msg += j1.getNome() + ":" + j1.getEscolha();
		msg += "-" + j2.getNome() + ":" + j2.getEscolha() + "}";
		throw new RuntimeException(msg);
	}

	public void start() {

		do {
			String resp = showInputDialog(null, MSG_GET_NOME, "JOKENPO", JOptionPane.QUESTION_MESSAGE);
			if (resp == null) {
				break;
			}
			if (resp.length() > MAX_CHAR_NAME) {// ajuste de tamaho do nome
				resp = resp.substring(0, MAX_CHAR_NAME);
			} else if (resp.equals("")) {// inicializa o jogo com um nome padrao
				resp = "jogador";
			}
			resp = resp.toUpperCase();
			{
				int apoioX = JogoView.getInstancia().getWidth() / 2;
				int apoioY = JogoView.getInstancia().getHeight();

				j1 = new Jogador(resp);
				j1.setXY((apoioX - j1.getSprite().width) / 2, (apoioY - j1.getSprite().height) / 2);

				j2 = new Jogador("MAQUINA");
				j2.setXY(apoioX + j1.getSprite().getX(), (apoioY - j2.getSprite().height) / 2);
			}
			RODADA = 1;
			while (true) {// loop de controle do jogo

				// acoes maquina
				j2.moveDireita();

				update();
				INSTANCIA.delay(50);

				// Acoes do teclado
				if (INSTANCIA.getKeyboard().keyDown(Keyboard.ESCAPE_KEY)) {// ESC
					showMessageDialog(null, "Esta partida foi cancelada");
					break;
				}

				if (INSTANCIA.getKeyboard().keyDown(Keyboard.LEFT_KEY))// SETA PRA ESQUERDA
					j1.moveEsquerda();
				if (INSTANCIA.getKeyboard().keyDown(Keyboard.RIGHT_KEY))// SETA PRA DIREITA
					j1.moveDireita();
				if (INSTANCIA.getKeyboard().keyDown(Keyboard.ENTER_KEY)) {// ENTER
					switch (j1.getEscolha()) {
					case ID_PAPEL:
						revelaResultado(-1, -2);
						break;
					case ID_PEDRA:
						revelaResultado(-1, 1);
						break;
					case ID_TESOURA:
						revelaResultado(2, 1);
					}

					if (RODADA > LIMITADOR_RODADAS) {
						RODADA--; // ajuste de rodada final
						update();
						if (j1.getVitorias() > j2.getVitorias()) {
							showMessageDialog(null, "Voce venceu o jogo com " + j1.getVitorias() + " vitorias");
						} else if (j1.getVitorias() < j2.getVitorias()) {
							showMessageDialog(null, "Voce perdeu o jogo com " + j2.getVitorias() + " derrotas");
						} else {
							showMessageDialog(null, "Ouve um empate entre os jogadores");
						}
						break;
					}
				}
			}
			reinicializa();
		} while (true);
		showMessageDialog(null, "O jogo foi encerrado");
		INSTANCIA.exit();
	}

	private void update() {
		// atualizacao da tela
		background.draw();
		j1.draw();
		j2.draw();
		String msg = RODADA + "ª RODADA";
		INSTANCIA.drawText(msg,
				(INSTANCIA.getWidth() / 2)
						- JogoView.getInstancia().getGraphics().getFontMetrics().stringWidth(msg) / 2,
				INSTANCIA.getHeight() / 4, Color.black);
		INSTANCIA.update();
	}

	private void reinicializa() {
		RODADA = 1;
		INSTANCIA.clear(Color.cyan);
		INSTANCIA.update();
	}

}
