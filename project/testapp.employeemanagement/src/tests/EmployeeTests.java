package tests;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.GenericUtils;
import in.conceptarchitect.collections.LinkedList;
import testapp.employeemanagement.Employee;
import testapp.employeemanagement.EmployeeManager;
import testapp.employeemanagement.Manager;
import testapp.employeemanagement.Programmer;
import static org.junit.Assert.*;

public class EmployeeTests {

	Programmer p1=new Programmer(1,20000);
	Programmer p2=new Programmer(2,30000);
	Programmer p3=new Programmer(3,40000);
	Manager m1=new Manager(4,50000);
	Manager m2=new Manager(5,60000);
	Manager m3=new Manager(6,70000);
	Manager m4=new Manager(7,80000);
	
	EmployeeManager empManager=new EmployeeManager();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canCalculateAverageSalaryOfEmployees() {
		
		LinkedList<Employee> employees=GenericUtils.createList(p1,p2,p3,m1);
		
		double avg= empManager.average(employees);
		
		assertEquals(35000, avg, 0.01);
		
	}
	
	@Test
	public void canCalculateAverageSalaryOfManager() {
		
		LinkedList<Manager> employees=GenericUtils.createList(m1,m2,m3);
		
		double avg= empManager.averageSalary(employees);
		
		assertEquals(60000, avg, 0.01);
		
	}
	
	@Test
	public void canAddValuesFromOneListOfManagerToAnotherListOfManager() {
		
		LinkedList<Manager> managers=GenericUtils.createList(m1,m2);
		LinkedList<Manager> newManagers= GenericUtils.createList(m3,m4);
		
		
		GenericUtils.addValues(managers, newManagers);
		
		assertEquals(4, managers.size());
		
	}
	
	
	@Test
	public void canAddManagersToEmployeeList() {
		
		LinkedList<Employee> employees=GenericUtils.createList(p1,m2);
		LinkedList<Manager> newManagers= GenericUtils.createList(m3,m4);
		
		
		GenericUtils.addValues(employees, newManagers);
		
		assertEquals(4, employees.size());
		
	}
	

}
