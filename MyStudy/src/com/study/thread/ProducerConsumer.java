package com.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	private Lock lock = new ReentrantLock();
	private Condition fullCondition = lock.newCondition();
	private Condition emptyCondition = lock.newCondition();

	private Object[] products = new Object[100];
	private int count;
	private int proCo;
	private int conCo;

	public void product() throws InterruptedException {
		try {
			lock.lock();
			while (count == products.length) {
				fullCondition.await();
			}
			products[proCo] = "product" + count;
			System.out.println(Thread.currentThread().getName() + "-----" + count);
			count++;
			if (++proCo == products.length) {
				proCo = 0;
			}
			emptyCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public Object consum() throws InterruptedException {
		try {
			lock.lock();
			while (count == 0) {
				emptyCondition.await();
			}
			Object currCon = products[conCo];
			count--;
			System.out.println(Thread.currentThread().getName() + "-----" + count);
			if (++conCo == products.length) {
				conCo = 0;
			}
			fullCondition.signalAll();
			return currCon;
		} finally {
			lock.unlock();
		}
	}

}
