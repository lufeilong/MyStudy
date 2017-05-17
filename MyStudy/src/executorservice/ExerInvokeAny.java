package executorservice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerInvokeAny {
	
	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			
			executorService = Executors.newSingleThreadExecutor();
			
			Set<Callable <String >> callables = new HashSet <Callable <String >>();
			
			callables.add(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return "任务1";
				}
			});
			callables.add(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return "任务2";
				}
			});
			callables.add(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return "任务3";
				}
			});
		
			String result = executorService.invokeAny(callables);
			System.out.println("result=" + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			if(executorService != null){
				executorService.shutdown();
			}
		}
	}
}
