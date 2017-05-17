package executorservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExerInvokeAll {
	
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
		
			List<Future<String>> futures = executorService.invokeAll(callables);
			
			for (Future<String> future : futures) {
				String result = future.get();
				System.out.println("result:" + result);
			}
			
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
