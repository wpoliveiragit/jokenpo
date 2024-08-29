package br.com.wellington.game.jokenpo.utils;

import lombok.Getter;

public interface ClassUtils {

	class CartesianPoint {
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

	class SpriteData {
		private @Getter int id;
		private @Getter int esquerda;
		private @Getter int direita;
		private @Getter int x;
		private @Getter int y;
		private @Getter int win;
		private @Getter int lose;

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

}
