package com.hp.test.duplicatable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.crxy.spider.job3.utils.RedisUtil;

public class RedisDuplicatable implements Duplicatable {
	final Logger logger = LoggerFactory.getLogger(getClass());
	final RedisUtil redisUtil = new RedisUtil();
	
	public static String key = "spider.job3.visited";
	
	public void add(String target) {
		redisUtil.sadd(key, target);
	}

	public boolean is(String target) {
		return redisUtil.sismember(key, target);
	}

}
