package com.study.thread;

public class Test {

	public static void main(String[] args) {

		ProducerConsumer producerConsumer = new ProducerConsumer();
		
		ProductThread productThread1 = new ProductThread(producerConsumer);
		ProductThread productThread2 = new ProductThread(producerConsumer);
		ProductThread productThread3 = new ProductThread(producerConsumer);
		
		ConsumThread consumThread1 = new ConsumThread(producerConsumer);
		ConsumThread consumThread2 = new ConsumThread(producerConsumer);
		ConsumThread consumThread3 = new ConsumThread(producerConsumer);
		
		new Thread(productThread1, "productThread1").start();
		new Thread(productThread2, "productThread2").start();
		new Thread(productThread3, "productThread3").start();
		new Thread(consumThread1, "consumThread1").start();
		new Thread(consumThread2, "consumThread2").start();
		new Thread(consumThread3, "consumThread3").start();
		
		int i = 0;
		while(true){
			i++;
			if(i == 100000000){
				productThread1.setFlag();
				productThread2.setFlag();
				productThread3.setFlag();
				consumThread1.setFlag();
				consumThread2.setFlag();
				consumThread3.setFlag();
				break;
			}
		}
	}

}
