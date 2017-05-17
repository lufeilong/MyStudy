package executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Exer4 {
	
	public static void main(String[] args) {
		
		FutureTask<Object> task = new FutureTask<>(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				System.out.println(Thread.currentThread().getName() + ":call has been invoke");
				return "call invoked";
			}
		});
		new Thread(task, "AA").start();
	}
	
}
