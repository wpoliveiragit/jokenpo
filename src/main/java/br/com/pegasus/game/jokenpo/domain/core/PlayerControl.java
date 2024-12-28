package br.com.pegasus.game.jokenpo.domain.core;

import br.com.pegasus.game.jokenpo.domain.entity.SpriteData;
import br.com.pegasus.game.jokenpo.infra.method.appMethod;
import br.com.pegasus.game.jokenpo.util.constant.GameConstant;
import jplay.Sprite;
import lombok.Getter;
import lombok.Setter;

public class PlayerControl {

	private final String SPRITE_ROCK_PAPER_SCISSORS = GameConstant.Path.ROOT_PATH_FILES + "image/pedra_papel_tesoura.png";

	private @Getter @Setter String name; // Nome do jogador
	private @Getter Sprite sprite; // gif do personagem
	private @Getter SpriteData spriteData;

	private appMethod commonMethod = new appMethod();

	public PlayerControl() {// cria um personagem para o jogo
		sprite = new Sprite(SPRITE_ROCK_PAPER_SCISSORS, GameConstant.AMOUNT_FRAME);
		init("Sem Nome");
	}

	public final void init(String name) {
		this.name = name;
		spriteData = commonMethod.getSpriteData(GameConstant.Id.PAPER);
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
		spriteData = commonMethod.getSpriteData(id);
		sprite.setSequence(spriteData.getX(), spriteData.getY());
	}

}
