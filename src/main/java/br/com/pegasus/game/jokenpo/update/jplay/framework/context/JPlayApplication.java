package br.com.pegasus.game.jokenpo.update.jplay.framework.context;

import java.lang.reflect.Method;

import br.com.pegasus.game.jokenpo.update.jplay.framework.StartgGameSetup;
import br.com.pegasus.game.jokenpo.update.jplay.framework.factory.JPlayApplicationExceptionFactory;

public final class JPlayApplication {

	public static <T>void addBean(T value) {
		BeanContext.putBean(value);
	}

	/**
	 * Executa o método anotado com {@link StartgGameSetup} em uma classe fornecida.
	 * 
	 * @param clazz a classe que contém o método anotado.
	 * @param <T>   o tipo da classe fornecida.
	 */
	public static <T> void run(Class<T> clazz) {
		invokeMethod(findAnnotatedMethod(validateClass(clazz)), clazz);
	}

	/**
	 * Verifica se a classe fornecida é nula.
	 * 
	 * @param clazz a classe para validação.
	 * @param <T>   o tipo da classe fornecida.
	 * @return a própria classe, se não for nula.
	 */
	private static <T> Class<T> validateClass(Class<T> clazz) {
		if (clazz == null) {
			throw JPlayApplicationExceptionFactory.startJPlayException();
		}
		return clazz;
	}

	/**
	 * Busca o método anotado com {@link StartgGameSetup}.
	 * 
	 * @param clazz a classe que será inspecionada.
	 * @param <T>   o tipo da classe fornecida.
	 * @return o método anotado com {@link StartgGameSetup}.
	 */
	private static <T> Method findAnnotatedMethod(Class<T> clazz) {
		Method annotatedMethod = null;
		int annotationCount = 0;

		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(StartgGameSetup.class)) {
				annotatedMethod = method;
				annotationCount++;
			}
		}

		if (annotationCount == 0) {
			throw JPlayApplicationExceptionFactory.noAnnotationsFound( //
					StartgGameSetup.class.getCanonicalName(), //
					clazz.getCanonicalName() //
			);
		}

		if (annotationCount > 1) {
			throw JPlayApplicationExceptionFactory.multipleAnnotationClass( //
					StartgGameSetup.class.getCanonicalName(), //
					clazz.getCanonicalName() //
			);
		}

		return annotatedMethod;
	}

	/**
	 * Invoca o método fornecido em uma nova instância da classe associada.
	 * 
	 * @param method o método a ser invocado.
	 * @param clazz  a classe que contém o método.
	 * @param <T>    o tipo da classe fornecida.
	 */
	private static <T> void invokeMethod(Method method, Class<T> clazz) {
		try {
			method.setAccessible(true);

			Class<?>[] argsTypes = method.getParameterTypes();
			if (argsTypes.length == 0) {
				method.invoke(clazz.getDeclaredConstructor().newInstance());
			}
			Object[] args = new Object[argsTypes.length];

			for (int i = 0; i < argsTypes.length; i++) {
				Object bean = BeanContext.getBean(argsTypes[i]);
				args[i] = bean;
			}
			method.invoke(clazz.getDeclaredConstructor().newInstance(), args);
		} catch (Exception ex) {
			throw JPlayApplicationExceptionFactory.failRun(clazz, ex);
		}
	}

}