package org.dkit.fxclient;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext CONTEXT;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		CONTEXT = applicationContext ;
	}

	public static <T> T getBean(Class<T> aClass){
		return CONTEXT.getBean(aClass);
	}

	public static Object getBean(final String name){
		return CONTEXT.getBean(name);
	}
}
