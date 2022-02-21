import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class mainThing {

	public static void main(String[] args) {
		ArrayList<String> mine = new ArrayList<String>();
		
		mine.add("bob");
		mine.add("bill");
		mine.add("bubba");
		mine.add("sam");
		mine.add("eric");
		
		Iterator iter = mine.iterator();
		
		
		
	//	System.out.println("hasNext: "+iter.hasNext());
		//System.out.println("Next: "+iter.next());
		
		//System.out.println("hasNext: "+iter.hasNext());
		//System.out.println("Next: "+iter.next());
		
		//System.out.println("hasNext: "+iter.hasNext());
	//	System.out.println("Next: "+iter.next());
		
		
		
		while(iter.hasNext()) {
			
			
			System.out.println(iter.next());
			iter.remove();
		}
		
		
		
		ListIterator listIter = mine.listIterator();
				
				
		System.out.println("next\n\n");
		
		while(listIter.hasNext()) {
			
			
			System.out.println(listIter.next());
			
		}
		
		System.out.println("Prev\n\n");
		
		
		while(listIter.hasPrevious()) {
			
			
			System.out.println(listIter.previous());
			
		}
		
		
		
	}

}
