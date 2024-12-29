package br.com.pegasus.game.jokenpo.update.jplay.framework.factory;

import br.com.pegasus.game.jokenpo.update.jplay.framework.context.BeanContext;
import br.com.pegasus.game.jokenpo.update.jplay.framework.exception.JPlayException;

public class BeanContextExceptionFactory {

	private static final String MESSAGE_PUT_BEAN_NULL = "Não pode ser adicionado beans nulos em {%s}.";
	private static final String MESSAGE_GET_BEAN_NULL = "Não pode ser recuperado beans nulos em {%s}.";
	private static final String MESSAGE_GET_BEAN_NOT_FOUND = "O Bean {%s} não foi encontrado em {%s}.";
	private static final String MESSAGE_GET_BEAN_FAIL_CAST = "O Bean {%s} com cast invalido em {%s}.";

	public static final JPlayException putBeanNull() {
		return new JPlayException(String.format(MESSAGE_PUT_BEAN_NULL, BeanContext.class.getCanonicalName()));
	}

	public static final JPlayException getBeanNull() {
		return new JPlayException(String.format(MESSAGE_GET_BEAN_NULL, BeanContext.class.getCanonicalName()));
	}

	public static final <T> JPlayException getBeanNotFound(Class<T> clazz) {
		return new JPlayException(String.format(MESSAGE_GET_BEAN_NOT_FOUND, clazz.getCanonicalName(),
				BeanContext.class.getCanonicalName()));
	}

	public static final <T> JPlayException getBeanfailCast(Class<T> clazz) {
		return new JPlayException(String.format(MESSAGE_GET_BEAN_FAIL_CAST, clazz.getCanonicalName(),
				BeanContext.class.getCanonicalName()));
	}

}
