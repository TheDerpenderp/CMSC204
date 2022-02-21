
public class ArraySum {

	public int sumOfArray(Integer[] myArray, int i) {
		
		if (i==(-1)) {
			return 0;
			
		}
		return  sumOfArray(myArray,i-1) + myArray[i];
	}

}
