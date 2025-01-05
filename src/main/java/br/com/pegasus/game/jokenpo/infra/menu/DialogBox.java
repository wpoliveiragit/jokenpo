package br.com.pegasus.game.jokenpo.infra.menu;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;

public class DialogBox {

	private static interface Message {
		String SHOW_BOX_WIN = "Você venceu o jogo com %d vitorias";
		String SHOW_BOX_LOSE = "Você perdeu o jogo com %d derrotas";
		String SHOW_BOX_DRAW = "Você empatou o jogo";
	}

	public String showBoxWelcome() {
		return showInputDialog(null, GameConstant.Menu.MAIN_MENU, GameConstant.Menu.WINDOW_NAME,
				JOptionPane.QUESTION_MESSAGE);
	}

	public void showBoxCanceled() {
		showMessageDialog(null, GameConstant.Menu.KEY_ESC);
	}

	public void showBoxWin(int value) {
		showMessageDialog(null, String.format(Message.SHOW_BOX_WIN, value));
	}

	public void showBoxLose(int value) {
		showMessageDialog(null, String.format(Message.SHOW_BOX_LOSE, value));
	}

	public void showBoxDraw() {
		showMessageDialog(null, Message.SHOW_BOX_DRAW);
	}
}
