package study.thread;

import java.util.concurrent.ConcurrentHashMap;

public class TestClass {
	
//	private HashMap<String, Integer> map = new HashMap<>();
	
	private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
	
//	public synchronized void add(String key){
	public void add(String key){	
		
		for (int i = 0; i < 100; i++) {
			Integer value = map.get(key);
			if(value == null){
				map.put(key, 1);
			}else{
				map.put(key, value + 1);
			}
			System.out.println(Thread.currentThread().getName() + "----" + map.get(key));
		}
	}
	
	public static void main(String[] args) {
		
		final TestClass testClass = new TestClass();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				testClass.add("aa");
			}
		}, "A").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				testClass.add("aa");
			}
		}, "B").start();
	}
}
