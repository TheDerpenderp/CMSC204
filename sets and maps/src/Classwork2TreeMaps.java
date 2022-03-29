import java.util.*;

public class Classwork2TreeMaps {

	public static void main(String[] args) {
		Map<String, Integer> myMap = new TreeMap<String, Integer>();
		myMap.put("one", 1);
		myMap.put("two", 2);
		myMap.put("three", 3);
		myMap.put("four", 4);
		myMap.put("five", 5);
		
		Set<String> keySet = myMap.keySet();
		
		for(String s: keySet) {
			System.out.println("\nKey: "+ s+ "\nValue: "+ myMap.get(s));
		}
		
		
		Collection<Integer> valueSet = myMap.values(); 
		for(Integer i: valueSet) {
			System.out.println("\nValue: "+ i);
		}
		
		Set<Map.Entry<String, Integer>> mySet = myMap.entrySet();
		
		for(Map.Entry<String, Integer> m: mySet) {
			System.out.println("\nMapping "+ m);
		}
		
	}

}
