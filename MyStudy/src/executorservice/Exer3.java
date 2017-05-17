package executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Exer3 {

	// 提交（赎回）
	// 该submit(Callable)方法与该方法类似，submit(Runnable)除了所需的参数类型。
	// 该Callable实例非常类似于一个，Runnable 除了它的call()方法可以返回一个结果。该Runnable.run()方法不能返回结果。
	// 该Callable结果可以通过方法Future返回的对象 获得submit(Callable)。这是一个ExecutorService
	// Callable例子：
	public static void main(String[] args) {
		ExecutorService executorService = null;
		Future<Object> future = null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			future = executorService.submit(new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					System.out.println("Asynchronous Callable");
					return "可调用结果";
				}
			});
			System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}
		}
	}
}
