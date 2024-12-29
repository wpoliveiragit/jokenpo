package br.com.pegasus.game.jokenpo.update.jplay.framework.context;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.com.pegasus.game.jokenpo.update.jplay.framework.factory.BeanContextExceptionFactory;

public final class BeanContext {

	private static final Map<String, Object> BEANS;

	static {
		BEANS = new HashMap<>();
	}

	public static <T> void putBean(T value) {
		if (value == null) {
			throw BeanContextExceptionFactory.putBeanNull();
		}
		BEANS.put(value.getClass().getCanonicalName(), value);

		for (Class<?> iface : value.getClass().getInterfaces()) {
			BEANS.put(iface.getCanonicalName(), value);
		}
	}

	public static <T> T getBean(Class<T> clazz) {
		if (clazz == null) {
			throw BeanContextExceptionFactory.getBeanNull();
		}

		Object value = BEANS.get(clazz.getCanonicalName());
		if (value == null) {
			throw BeanContextExceptionFactory.getBeanNotFound(clazz);
		}

		if (clazz.isInstance(value)) {
			return clazz.cast(value);
		}

		throw BeanContextExceptionFactory.getBeanfailCast(clazz);
	}

	public static Map<String, Object> getBeans() {
		return Collections.unmodifiableMap(BEANS);
	}

}
