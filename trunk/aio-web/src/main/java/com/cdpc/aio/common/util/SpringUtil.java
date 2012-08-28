package com.cdpc.aio.common.util;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


/**
 * spring工具类
 * 
 * @author evin.liu
 *
 */
public class SpringUtil {

	private SpringUtil() {
	}

	/**
	 * 在Spring容器中查找指定bean
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		Object bean = wac.getBean(beanName);
		return bean;
	}
}
