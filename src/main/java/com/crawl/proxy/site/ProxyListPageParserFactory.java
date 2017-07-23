package com.crawl.proxy.site;


import com.crawl.proxy.ProxyListPageParser;

import java.util.HashMap;
import java.util.Map;

public class ProxyListPageParserFactory {
	
	/**
	 * 代理解析器的名字
	 */
    private static Map<String, ProxyListPageParser> map  = new HashMap<>();
    
    public static ProxyListPageParser getProxyListPageParser(Class clazz){
        String parserName = clazz.getSimpleName();
        ProxyListPageParser proxyListPageParser = null;
        if (map.containsKey(parserName)){
            return map.get(parserName);
        }
        else {
            try {
                ProxyListPageParser parser = (ProxyListPageParser) clazz.newInstance();
                parserName = clazz.getSimpleName();
                map.put(parserName, parser);
                return parser;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
