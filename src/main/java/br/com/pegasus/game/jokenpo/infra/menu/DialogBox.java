package br.com.pegasus.game.jokenpo.infra.menu;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;

public class DialogBox {

	public String welcome() {
		return showInputDialog(null, GameConstant.Menu.MAIN_MENU, GameConstant.Menu.WINDOW_NAME,
				JOptionPane.QUESTION_MESSAGE);
	}

	public void gameCanceled() {
		showMessageDialog(null, GameConstant.Menu.KEY_ESC);
	}
}
