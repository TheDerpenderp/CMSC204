
public class bookDriver {

	public static void main(String[] args) {
		
		Book toclone = new Book("example", 12345342, new Author("bob",32));
		
		try {
			Book shallowClone = (Book) toclone.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
		
		
		

	}

}
