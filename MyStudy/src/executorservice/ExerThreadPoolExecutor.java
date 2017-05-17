package executorservice;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExerThreadPoolExecutor {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		poolExecutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("run");
			}
		});
		poolExecutor.shutdown();
	}
	
}
