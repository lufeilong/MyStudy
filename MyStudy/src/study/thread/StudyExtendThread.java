package study.thread;

public class StudyExtendThread extends Thread {
	
//	测试用例1
//	@Override
//	public void run() {
//		try {
//			for (int i = 0; i < 10; i++) {
//				int time = (int) (Math.random() * 1000);
//				Thread.sleep(time);
//				System.out.println("run=" + Thread.currentThread().getName());
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public static void main(String[] args) {
//		
//		StudyExtendThread thread = new StudyExtendThread();
//		thread.setName("StudyExtendThread");
//		thread.start();
//		
//		try {
//			for (int i = 0; i < 10; i++) {
//				int time = (int) (Math.random() * 1000);
//				Thread.sleep(time);
//				System.out.println("main=" + Thread.currentThread().getName());
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	测试用例2      说明执行start() 方法的顺序不代表线程启动的顺序
//	private int i;
//	
//	public StudyExtendThread(int i){
//		super();
//		this.i= i;
//	}
//	
//	@Override
//	public void run() {
//		System.out.println(i);
//	}
//	public static void main(String[] args) {
//		
//		StudyExtendThread t11 = new StudyExtendThread(1);
//		StudyExtendThread t12 = new StudyExtendThread(2);
//		StudyExtendThread t13 = new StudyExtendThread(3);
//		StudyExtendThread t14 = new StudyExtendThread(4);
//		StudyExtendThread t15 = new StudyExtendThread(5);
//		StudyExtendThread t16 = new StudyExtendThread(6);
//		StudyExtendThread t17 = new StudyExtendThread(7);
//		StudyExtendThread t18 = new StudyExtendThread(8);
//		StudyExtendThread t19 = new StudyExtendThread(9);
//		StudyExtendThread t110 = new StudyExtendThread(10);
//		StudyExtendThread t111 = new StudyExtendThread(11);
//		StudyExtendThread t112 = new StudyExtendThread(12);
//		StudyExtendThread t113 = new StudyExtendThread(13);
//		
//		t11.start();
//		t12.start();
//		t13.start();
//		t14.start();
//		t15.start();
//		t16.start();
//		t17.start();
//		t18.start();
//		t19.start();
//		t110.start();
//		t111.start();
//		t112.start();
//		t113.start();
//	}
	
	
	
//	不共享数据的情况
//	private int count = 5;
//	
//	public StudyExtendThread(String name){
//		this.setName(name);
//	}
//	
//	@Override
//	public void run() {
//		super.run();
//		
//		while(count > 0) {
//			count--;
//			System.out.println("由 " + Thread.currentThread().getName() + " 计算， count=" + count);
//		}
//	}
//	
//	public static void main(String[] args) {
//		
//		StudyExtendThread a = new StudyExtendThread("A");
//		StudyExtendThread b = new StudyExtendThread("B");
//		StudyExtendThread c = new StudyExtendThread("C");
//		a.start();
//		b.start();
//		c.start();
//	}
	
//	private int count = 5;
//	
//	@Override
//	public void run() {
//		
//		super.run();
//		// 此示例不要用for 语句，因为使用同步后其他线程就得不到运行的机会了，
//		// 一直由一个线程进行减法运算
//		synchronized(this){
//			for (int i = 0; i < 10; i++) {
//				
//				count--;
//				System.out.println(" 由 "+Thread.currentThread().getName()+" 计算，count="+count);
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		
//		StudyExtendThread myThread = new StudyExtendThread();
//		
//		Thread a = new Thread(myThread, "A");
//		Thread b = new Thread(myThread, "B");
//		Thread c = new Thread(myThread, "C");
//		Thread d = new Thread(myThread, "D");
//		Thread e = new Thread(myThread, "E");
//		a.start();
//		b.start();
//		c.start();
//		d.start();
//		e.start();
//	}
	
	
//	private int count = 5;
//	
//	@Override
//	public void run() {
//		super.run();
//		System.out.println("count=" + (count--) + " ThreadName=" + Thread.currentThread().getName());
//	}
//	
//	public static void main(String[] args) {
//		StudyExtendThread run = new StudyExtendThread();
//		Thread a = new Thread(run, "A");
//		Thread b = new Thread(run, "B");
//		Thread c = new Thread(run, "C");
//		Thread d = new Thread(run, "D");
//		Thread e = new Thread(run, "E");
//		a.start();
//		b.start();
//		c.start();
//		d.start();
//		e.start();
//	}
	
	public StudyExtendThread(){
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("CountOperate---end");
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("run---end");
	}
	
	
	public static void main(String[] args) {
		
		StudyExtendThread c = new StudyExtendThread();
		Thread t1 = new Thread(c);
		t1.setName("A");
		t1.start();
	}
	
}	
