package study.classloader;

public class FindClassPath {
	
	public static void main(String[] args) {
		String classPath = FindClassPath.class.getClassLoader().getResource("").toString();
		System.out.println(classPath);
	}
	
}
