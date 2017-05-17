package study.thread;

//本类模拟一个Servlet组件
public class LoginServlet {
	
	private static String usernameRef;
	private static String passwordRef;
	
	synchronized public static void doPost(String username, String password) {
		
//		synchronized (LoginServlet.class) {
			
			try {
				usernameRef = username;
				if(username.equals("a")){
					Thread.sleep(1000);
				}
				passwordRef = password;
				System.out.println("username=" + usernameRef + " password=" + passwordRef);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}
	
	public static void main(String[] args) {
		
		ALogin aLogin = new ALogin();
		BLogin bLogin = new BLogin();
		aLogin.start();
		bLogin.start();
	}
}
