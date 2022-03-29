import java.util.*;

public class Classmap {
	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("Konstantin", 20);
		myMap.put("Ben", 20);
		myMap.put("Feroz", 20);
		myMap.put("notMe", 40);
		myMap.put("shrikoar", 238);
		
		System.out.println(myMap.containsValue(40));
		myMap.remove("notMe");
		System.out.println(myMap.size());
		
		//Set mySet = myMap.entrySet();
		
		
		Set myKeySet = myMap.keySet();
		
		for(Object s: myKeySet) {
			System.out.println("The Key is: "+ s);
			System.out.println("The Value is:" + myMap.get(s));
			
		}
		 Collection myValues = myMap.values();
		 System.out.println("---------------------");
		 for(Object o: myValues) {
			 
			 System.out.println(o);
		 }
		
	}
}
