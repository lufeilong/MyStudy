package study.thread;

public class Efficiency implements Runnable{
	
	private int count;
	private int num;
	
	@Override
	public void run() {
		
		for (int count = this.count; count < num; count++) {
			System.out.println(Thread.currentThread().getName() + " count: " + count);
		}
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public static void main(String[] args) {
		
		Efficiency efficiency = new Efficiency();
		efficiency.setCount(0);
		efficiency.setNum(5000);
		Thread thread1 = new Thread(efficiency, "aaa");
		thread1.start();
		
		Efficiency efficiency2 = new Efficiency();
		efficiency2.setCount(5000);
		efficiency2.setNum(10000);
		Thread thread2 = new Thread(efficiency2, "bbb");
		thread2.start();
		
	}
}
