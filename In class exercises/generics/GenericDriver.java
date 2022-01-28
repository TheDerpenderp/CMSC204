
public class GenericDriver {

	public static void main(String[] args) {
		Integer[] array = new Integer[10];
		for(int i = 0; i<array.length-2;i++) {
			array[i] = i;
			
		}
		array[array.length-1] = 10;
		array[array.length-2] = 10;
		
		Generic<Integer> myGeneric = new Generic<Integer>(array, 10);
		System.out.println(myGeneric.getCount());
		
		
		
		String[] array1 = new String[10];
		for(int i = 0; i<array1.length-2;i++) {
			array1[i] = i+"";
			
		}
		array1[array.length-1] = 10+"";
		array1[array.length-2] = 10+"";
		
		Generic<Integer> myGeneric1 = new Generic<Integer>(array, 10);
		System.out.println(myGeneric.getCount());
	}
		
}


