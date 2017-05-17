package com.study.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExerCachedThreadPool {
	public static void main(String[] args) {
		// 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
		ExecutorService pool = Executors.newCachedThreadPool();
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Thread t1 = new MyThread2();
		Thread t2 = new MyThread2();
		Thread t3 = new MyThread2();
		Thread t4 = new MyThread2();
		Thread t5 = new MyThread2();
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		// 关闭线程池 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
		pool.shutdown();
		// pool.shutdownNow() 试图停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
	}
}
class MyThread3 extends Thread {
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "正在执行。。。");
	}
}