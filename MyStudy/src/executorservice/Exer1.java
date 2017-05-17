package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exer1 {

	// 执行（可运行）
	// 该execute(Runnable)方法接收一个java.lang.Runnable对象，并以异步方式执行。
	// 这里是执行的一个例子Runnable具有ExecutorService：
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + ":异步任务");
			}
		});
		executorService.shutdown();
		
//		如果有必要，没有办法获得Runnable的执行结果。您将不得不使用Callable（在以下部分中解释）。
	}

}
