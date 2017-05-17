package studycollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExerTraverseMap {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();
		map.put("AA", 1);
		map.put("BB", 2);
		map.put("CC", 3);
		map.put("DD", 4);
		map.put("EE", 5);
		map.put("FF", 6);

		// 1.二次取值
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println(key + ":" + map.get(key));
		}

		System.out.println("------------------------------------>>>>>>>>>>>>>>>>>");

		// 2.
		Set<Entry<String, Object>> entrySet = map.entrySet();
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("------------------------------------>>>>>>>>>>>>>>>>>");

		// 3.
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		System.out.println("------------------------------------>>>>>>>>>>>>>>>>>");

		// 4. 仅仅关心 vlaue
		for (Object value : map.values()) {
			System.out.println(value);
		}

	}

}
