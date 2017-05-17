package networkinstance;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Java 实例 - 查看端口是否已使用
public class TestIpUsed {
	public static void main(String[] args) {
		Socket skt = null;
		String host = "localhost";
		if (args.length > 0) {
			host = args[0];
		}
		for (int i = 0; i < 1024; i++) {
			try {
				System.out.println("查看 " + i);
				skt = new Socket(host, i);
				System.out.println("端口 " + i + " 已被使用");
			} catch (UnknownHostException e) {
				System.out.println("Exception occured" + e);
				break;
			} catch (IOException e) {
			}finally {
				try {
					if(skt != null){
						skt.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
