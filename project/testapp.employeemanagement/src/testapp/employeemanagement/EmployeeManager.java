package testapp.employeemanagement;

import in.conceptarchitect.collections.LinkedList;

public class EmployeeManager {

	public double average(LinkedList<Employee> employees) {
		
		double sum=0;
		for(Employee emp : employees)
			sum+=emp.getSalary();
		
		return sum/employees.size();
		
	}
	
	public double averageSalary(LinkedList<? extends Employee> employees) {
		
		double sum=0;
		for(Employee emp : employees)
			sum+=emp.getSalary();
		
		return sum/employees.size();
		
	}
}
