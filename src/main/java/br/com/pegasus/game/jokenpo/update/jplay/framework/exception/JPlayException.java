package br.com.pegasus.game.jokenpo.update.jplay.framework.exception;

public class JPlayException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public JPlayException(Throwable cause, String message) {
		super(message, cause);
	}

	public JPlayException(String message) {
		super(message);
	}
}