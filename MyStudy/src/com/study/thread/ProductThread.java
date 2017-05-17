package com.study.thread;

public class ProductThread implements Runnable {

	private ProducerConsumer producerConsumer;
	
	private boolean flag = true;
	
	public ProductThread(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
	}

	public void setFlag() {
		this.flag = false;
	}
	
	@Override
	public void run() {
		try {
			while(flag){
				producerConsumer.product();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
