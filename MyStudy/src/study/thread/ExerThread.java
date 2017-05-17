package study.thread;

public class ExerThread implements Runnable {

	private int[] idsA;

	public ExerThread(int[] idsA) {
		this.idsA = idsA;
	}

	@Override
	public void run() {

		for (int i = 0; i < idsA.length; i++) {
			System.out.println(Thread.currentThread().getName() + "---->" + idsA[i]);
		}
	}
	
	//模拟多个线程共同完成一项工作
	public static void main(String[] args) {

		int[] ids = new int[] { 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
				26, 27, 28, 29, 30, 31, 32, 33 };

		int[] idsA = new int[ids.length / 2];
		int[] idsB = new int[ids.length - ids.length / 2];
		for (int i = 0; i < idsA.length; i++) {
			idsA[i] = ids[i];
		}
		for (int i = 0; i < idsB.length; i++) {
			idsB[i] = ids[i + idsA.length];
		}
		ExerThread runA = new ExerThread(idsA);
		ExerThread runB = new ExerThread(idsB);
		Thread aa = new Thread(runA, "AA");
		Thread bb = new Thread(runB, "BB");
		aa.start();
		bb.start();
	}
}
