package executorservice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exer2 {
	
//	提交（可运行）
//	该submit(Runnable)方法也需要一个Runnable实现，但返回一个Future对象。这个Future对象可以用来检查是否执行Runnable 完毕。
//	这是一个ExecutorService submit()例子：
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<?> future = executorService.submit(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("异步任务");
			}
		});
		
		System.out.println("---------------->>>>>>>>>>>>>>>>");
		
		//线程 run 方法执行完成后才调用 get() 方法
		System.out.println(future.get());
		
		
		Map<Object, Object> hashMap = new HashMap<>();
		
		hashMap.put(1, 2);
		
		System.out.println(hashMap.get(1));
	}

}
