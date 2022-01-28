
public class Generic<E> {
	private int count;
    private int[] arrayOfDuplicates;
	private int sizeOfDup;
	
	public Generic(E[] arrayToCount, E whatToFind) {
		arrayOfDuplicates = new int[arrayToCount.length];
		for(int i = 0;i<arrayToCount.length;i++) {
			
			if(arrayToCount[i].equals(whatToFind)) {
				count++;
				arrayOfDuplicates[sizeOfDup] = i;
			}
		}
		
	}
	public int getCount() {
		return count;
		
	}
	
	
	public void printDupIndex() {
		for(int i = 0 ; i<sizeOfDup;i++)
		System.out.println(arrayOfDuplicates[i]);
		
		
		
	}
	
	

}
