package jedisexer;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class StudyRedis0 {
	
	private static Jedis jedis;
	
	private static JedisPool jedisPool;
	
	public StudyRedis0(){}
	
	static{
		jedis = jedisPool.getResource();
	}
	
	@Before
	public void setup(){
		//连接redis服务器，192.168.0.100:6379
		jedis = new Jedis("192.168.43.167", 6379);
		System.out.println("start..........");
	}

	/**
	 * redis存储字符串
	 */
	@Test
	public void testString() {
		jedis.set("name", "xinxin");
		System.out.println(jedis.get("name"));

		jedis.append("name", " is my lover"); 
		System.out.println(jedis.get("name"));

		jedis.del("name"); 
		System.out.println(jedis.get("name"));
		jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
		jedis.incr("age");
		System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	}
}
