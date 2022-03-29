
public class Employee implements Cloneable{
	private int id;
	private String name;
	private double salary;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	protected Employee clone() throws CloneNotSupportedException {
		
		return (Employee) super.clone();
	}
	
	
}
