package com.cdpc.aio.ams.web.cache;

/**
 * 
 * 缓存工厂类
 * @author evin.liu
 *
 */
public class CacheFactory {

	public static SysFunCache getSysFunCache() {
		if(sysFunCache == null) {
			sysFunCache = new SysFunCache();
			sysFunCache.initSysFunMap();
		}
		return sysFunCache;
	}
	
	private static SysFunCache sysFunCache = null;
	
}
