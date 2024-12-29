package br.com.pegasus.game.jokenpo.update.jplay.framework.factory;

import br.com.pegasus.game.jokenpo.update.jplay.framework.exception.JPlayException;

public class JPlayApplicationExceptionFactory {

	private static final String MESSAGE_START_JPLAY_EXCEPTION = "Problemas ao iniciar o JPlay: A classe inicial está nula.";
	private static final String MESSAGE_NO_ANNOTATIONS_FOUND = "Anotação {%s} não encontrada na classe {%s}.";
	private static final String MESSAGE_MULTIPLE_ANNOTATION_CLASS = "Múltiplas anotações {%s} foram encontradas na classe {%s}.";
	private static final String MESSAGE_FAIL_RUN = "Não foi possível executar a classe %s.";

	public static final JPlayException startJPlayException() {
		return new JPlayException(MESSAGE_START_JPLAY_EXCEPTION);
	}

	public static final JPlayException noAnnotationsFound(String annotationName, String className) {
		return new JPlayException(String.format(MESSAGE_NO_ANNOTATIONS_FOUND, annotationName, className));
	}

	public static final JPlayException multipleAnnotationClass(String annotationName, String className) {
		return new JPlayException(String.format(MESSAGE_MULTIPLE_ANNOTATION_CLASS, annotationName, className));
	}

	public static final <T> JPlayException failRun(Class<T> clazz, Throwable cause) {
		return new JPlayException(cause, String.format(MESSAGE_FAIL_RUN, clazz.getCanonicalName()));
	}

}
