package testapp.employeemanagement;

public class Manager extends Employee {

	public Manager(int id, double salary) {
		super(id, salary);
		// TODO Auto-generated constructor stub
	}
	
	public void manage() {
		System.out.println("Manager Manages");
	}

}
