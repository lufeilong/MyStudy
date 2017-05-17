package study;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestIterators {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList(new String[]{"a", "b", "c", "d"});
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}	
