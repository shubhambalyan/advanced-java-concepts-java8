package testapp.employeemanagement;

public class Employee {
	
	int id;
	double salary;
	public Employee(int id, double salary) {
		super();
		this.id = id;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + "]";
	}
	
	public void work() {
		System.out.println("Employee works ");
		
	}

}
