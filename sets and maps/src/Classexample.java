
import java.util.*;

public class Classexample {

	public static void main(String[] args) {
		Set<String> mySet = new HashSet<String>();
		mySet.add("Hi");
		mySet.add("my");
		mySet.add("name");
		mySet.add("is");
		mySet.add("bubba");
		System.out.println(mySet.contains("bubba"));
		Object[] myArr =  mySet.toArray();
		
		for(int i = 0;i<myArr.length;i++) {
			System.out.println(myArr[i]);
			
		}
		System.out.println("----------------------------");
		Iterator myIter = mySet.iterator();
		
		for(String s: mySet) {
			System.out.println(s);
			
		}
		
		
		
	}

}
