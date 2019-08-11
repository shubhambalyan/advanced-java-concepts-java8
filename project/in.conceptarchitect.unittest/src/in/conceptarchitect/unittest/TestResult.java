package in.conceptarchitect.unittest;

import java.lang.reflect.Method;

public class TestResult {

	
	Method method;
	Throwable failure;
	TestStatus status;
	public TestResult(Method method, Throwable failure,TestStatus status) {
		super();
		this.method = method;
		this.failure = failure;
		this.status=status;
		
	}
	public TestResult(Method method) {
		super();
		this.method = method;
		this.status=TestStatus.Success;
	}


	public boolean isSuccess() {return failure==null;}
	public Method getMethod() {
		return method;
	}
	public Throwable getFailure() {
		return failure;
	}
	
	
}
