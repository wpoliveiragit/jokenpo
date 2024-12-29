package br.com.pegasus.game.jokenpo.infra.entity;

import br.com.pegasus.game.jokenpo.infra.constant.GameConstant;
import br.com.pegasus.game.jokenpo.infra.method.GameMethod;
import jplay.Sprite;
import lombok.Getter;
import lombok.Setter;

public class PlayerEntity {

	private @Getter @Setter String name;
	private @Getter Sprite sprite;
	private @Getter SpriteData spriteData;

	public PlayerEntity() {
		sprite = new Sprite(GameConstant.Path.SPRITE_ROCK_PAPER_SCISSORS, GameConstant.Central.AMOUNT_FRAME);
		init("Sem Nome");
	}

	public final void init(String name) {
		this.name = name;
		spriteData = GameMethod.getSpriteData(GameConstant.Id.PAPER);
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
		spriteData = GameMethod.getSpriteData(id);
		sprite.setSequence(spriteData.getX(), spriteData.getY());
	}

}
