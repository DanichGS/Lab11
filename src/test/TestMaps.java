package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class TestMaps {

	public static void main(String[] args) {
		
		Properties props = System.getProperties();
		props.forEach((key, value)-> System.out.println(key + "->" + value));
		
		
		Map<String, String> map = new TreeMap<>();
		
		map.put("file", "файл");
		map.put("block", "блок");
		map.put("dictionary", "словник");
		
		map.keySet().forEach(System.out::println);
		map.values().forEach(System.out::println);
		map.entrySet().forEach(System.out::println);
		
		
		
		map.put("file", "файл");
		map.put("block", "блок");
		map.put("dictionary", "словник");
		
		map.keySet().forEach(System.out::println);
		
		
	}
	
}
