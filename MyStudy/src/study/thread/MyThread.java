package study.thread;

public class MyThread extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i=" + (i + 1));
		}
	}

	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			// Thread.currentThread().interrupt();
			System.out.println(" 是否停止1 ？ =" + Thread.interrupted());
			System.out.println(" 是否停止2 ？ =" + Thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}
