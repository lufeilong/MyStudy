package com.study.thread;

public class ConsumThread implements Runnable {

	private ProducerConsumer producerConsumer;
	
	private boolean flag = true;
	
	public ConsumThread(ProducerConsumer producerConsumer) {
		this.producerConsumer = producerConsumer;
	}

	public void setFlag() {
		this.flag = false;
	}
	
	@Override
	public void run() {
		try {
			while(flag){
				producerConsumer.consum();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
