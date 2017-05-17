package study.thread;

public class StudyImplRunnable implements Runnable{

	@Override
	public void run() {
		
		System.out.println("运行中");
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new StudyImplRunnable(), "implRunnable");
		thread.start();
		System.out.println("运行结束");
	}
}
