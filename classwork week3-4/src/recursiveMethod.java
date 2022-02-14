
public class recursiveMethod {

	public static void main(String[] args) {
		sumOf(10);
		
		System.out.println(reverse("hello there"));
	}

	private static String reverse(String string) {
		
		if((string.length()==0))
			return "";
		
		
		return reverse(string.substring(1))+ string.charAt(0);
		
	}

	private static int sumOf(int num) {
		if(num == 0)
			return 0;
		
		
		return num + sumOf(num-1);
		
		
		
		
		
		
	}

	
	
	
}
