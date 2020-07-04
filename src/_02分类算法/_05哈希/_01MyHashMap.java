package _02�����㷨._05��ϣ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _01MyHashMap {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("zuo", "31");

		System.out.println(map.containsKey("zuo"));
		System.out.println(map.containsKey("chengyun"));
		System.out.println("===========1==============");

		System.out.println(map.get("zuo"));
		System.out.println(map.get("chengyun"));
		System.out.println("==========2===============");

		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("==========3===============");

		System.out.println(map.remove("zuo"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuo"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("==========4===============");

		map.put("zuo", "31");
		System.out.println(map.get("zuo"));
		map.put("zuo", "32");
		System.out.println(map.get("zuo"));
		System.out.println("==========5===============");

		map.put("zuo", "31");
		map.put("cheng", "32");
		map.put("yun", "33");

		for (String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("==========6===============");

		for (String values : map.values()) {
			System.out.println(values);
		}
		System.out.println("===========7==============");

		map.clear();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("===========8==============");

		// you can not remove item in map when you use the iterator of map
//		 for(Entry<String,String> entry : map.entrySet()){
//			 if(!entry.getValue().equals("1")){
//				 map.remove(entry.getKey());
//			 }
//		 }

		//ɾ��Hashmap�е�һϵ��ֵ
		List<String> removeKeys = new ArrayList<String>();	//����һ�����ϴ��Ҫɾ����Key
		for (Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("1")) {	//���������߼���Key����ɾ�������
				removeKeys.add(entry.getKey());
			}
		}
		for (String removeKey : removeKeys) {	//��һɾ�����ϰ�����Ԫ��
			map.remove(removeKey);
		}
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("==========9===============");

	}
}
