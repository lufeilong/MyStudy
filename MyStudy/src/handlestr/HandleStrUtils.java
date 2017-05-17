package handlestr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class HandleStrUtils {
	
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream("D:/码表.txt");
		
		StringBuilder builder = new StringBuilder();
		
		byte[] bytes = new byte[8192];
		int len = fis.read(bytes);
		while(len > 0){
			builder.append(new String(bytes));
			len = fis.read(bytes);
		}
		String resultStr = builder.toString();
		String[] split = resultStr.split("\r\n");
		Set<String> hashSet = new HashSet<>();
		for (String str : split) {
			hashSet.add(str);
		}
		for (String string : hashSet) {
			System.out.println(string);
		}
		System.out.println(hashSet.size());
	}
	
}
