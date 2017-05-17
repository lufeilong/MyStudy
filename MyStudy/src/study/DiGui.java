package study;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class DiGui {

	public static int getJieSheng(int i){
		
		if(i == 1){
			return 1;
		}
		
		return i * getJieSheng(i - 1);
	}
	
	public static void main(String[] args) {
		int result = getJieSheng(15);
		System.out.println(result);
		
		Method[] methods = getAllMethod(ArrayList.class);
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
	
	//根据父节点查询所有的子节点
	
	//1.查询出所有的节点
	//2.
	
	public List<?> getAllChildrens(String pid, List<?> all){
		List<Object> list = new ArrayList<>();
		for (Object object : all) {
			//找到所有的父节点下面的子节点
			if(object.getClass().toString().equals(pid)){
				
				List<?> allChildrens = getAllChildrens(object.getClass().toString(), all);
				list.add(object.getClass().toString());
				list.addAll(allChildrens);
			}
		}
		return list;
	}
	
	
	//获取一个类的所有方法，包含父类
	public static Method[] getAllMethod(Class<?> clazz){
		
		Class<?> superClass = clazz.getSuperclass();
		if(superClass == null){
			return null;
		}
		
		Method[] parentMethods = getAllMethod(superClass);
		Method[] methods = clazz.getDeclaredMethods();
		
		if(parentMethods != null && parentMethods.length > 0){
			
			Method[] all = new Method[methods.length + parentMethods.length];
			System.arraycopy(parentMethods, 0, all, 0, parentMethods.length);
			System.arraycopy(methods, 0, all, parentMethods.length, methods.length);
			methods = all;
		}
		return methods;
	}
}
