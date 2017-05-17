package networkinstance;

import java.net.InetAddress;

//获取本机ip地址及主机名
public class GetIpAndHost {
	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("Local HostAddress:" + addr.getHostAddress());
		String hostname = addr.getHostName();
		System.out.println("Local host name: " + hostname);
	}
}
