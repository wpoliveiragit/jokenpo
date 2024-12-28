package br.com.pegasus.game.jokenpo.domain.entity;

public class CartesianPoint {
	
	public double x;
	public double y;

	public CartesianPoint() {
		init();
	}

	public CartesianPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public final void init() {
		x = -1;
		y = -1;
	}

	public int getXInt() {
		return (int) x;
	}

	public int getYInt() {
		return (int) y;
	}
}
