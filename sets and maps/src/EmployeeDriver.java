
public class EmployeeDriver {
	public static void main(String[] args) {
		Employee myEmp = new Employee();
		try {
			Employee clone = myEmp.clone();
		} catch (CloneNotSupportedException e) {
		
			e.printStackTrace();
		}
	}
	
	
	
}
