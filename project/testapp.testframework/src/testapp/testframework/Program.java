package testapp.testframework;

import in.conceptarchitect.unittest.ConsoleTestRunner;

public class Program {

	public Program() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		ConsoleTestRunner runner=new ConsoleTestRunner();		
		runner.runTest(LinkedListTest.class)	;

	}

}
