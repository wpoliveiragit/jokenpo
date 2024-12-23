package br.com.wellington.game.jokenpo.engine;

import br.com.wellington.game.jokenpo.utils.ClassUtils.SpriteData;
import br.com.wellington.game.jokenpo.utils.CommonMethod;
import br.com.wellington.game.jokenpo.utils.ConstantsUtils;
import jplay.Sprite;
import lombok.Getter;
import lombok.Setter;

public class PlayerControl {

	private @Getter @Setter String name; // Nome do jogador
	private @Getter Sprite sprite; // gif do personagem
	private @Getter SpriteData spriteData;

	private CommonMethod commonMethod2 = new CommonMethod();

	public PlayerControl() {// cria um personagem para o jogo
		sprite = new Sprite(ConstantsUtils.Path.SPRITE_ROCK_PAPER_SCISSORS, ConstantsUtils.AMOUNT_FRAME);
		reset("Sem Nome");
	}

	public final void reset(String name) {
		this.name = name;
		spriteData = commonMethod2.getSpriteData(ConstantsUtils.Id.PAPER);
	}

	/** Avanca um elemento */
	public void setaDireita() {
		setSprite(spriteData.getDireita());
	}

	/** Retorna um elemento **/
	public void setaEsquerda() {
		setSprite(spriteData.getEsquerda());
	}

	/** Imprime o desenho na janela. */
	public void draw() {
		sprite.draw();
	}

	private void setSprite(int id) {
		spriteData = commonMethod2.getSpriteData(id);
		sprite.setSequence(spriteData.getX(), spriteData.getY());
	}

}
