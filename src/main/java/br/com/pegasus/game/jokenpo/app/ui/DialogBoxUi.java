package br.com.pegasus.game.jokenpo.app.ui;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;
import lombok.RequiredArgsConstructor;

public class DialogBoxUi {

	@RequiredArgsConstructor
	enum MessageBox{
		
		WIN("Você venceu o jogo com %d vitorias."),//
		LOSE("Você perdeu o jogo com %d derrotas."),//
		DRAW("Você empatou o jogo."),
		
		
		
		
		KEY_ESC ("Esta partida foi cancelada");
		
		public final String value;
	}
	
	

	public String showBoxWelcome() {
		return showInputDialog(null, GameConstant.Menu.MAIN_MENU, GameConstant.Menu.WINDOW_TITTLE,
				JOptionPane.QUESTION_MESSAGE);
	}

	public void showBoxCanceled() {
		showMessageDialog(null, MessageBox.KEY_ESC.value,"title", JOptionPane.CANCEL_OPTION);
	}

	public void showBoxWin(int value) {
		showMessageDialog(null, String.format(MessageBox.WIN.value, value));
	}

	public void showBoxLose(int value) {
		showMessageDialog(null, String.format(MessageBox.LOSE.value, value));
	}

	public void showBoxDraw() {
		showMessageDialog(null, MessageBox.DRAW.value);
	}
}
