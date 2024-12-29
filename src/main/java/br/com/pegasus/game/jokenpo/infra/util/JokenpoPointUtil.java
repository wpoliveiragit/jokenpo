package br.com.pegasus.game.jokenpo.infra.util;

public class JokenpoPointUtil {
	
	public double x;
	public double y;

	public JokenpoPointUtil() {
		init();
	}

	public JokenpoPointUtil(int x, int y) {
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
