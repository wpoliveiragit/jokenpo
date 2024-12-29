package br.com.pegasus.game.jokenpo.infra.entity;

import lombok.Getter;

@Getter
public class SpriteData {

	private int id;
	private int esquerda;
	private int direita;
	private int x;
	private int y;
	private int win;
	private int lose;

	public SpriteData(int id, int x, int y, int esquerda, int direita, int win, int lose) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.esquerda = esquerda;
		this.direita = direita;
		this.win = win;
		this.lose = lose;
	}
}