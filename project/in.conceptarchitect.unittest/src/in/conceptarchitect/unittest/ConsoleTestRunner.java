package in.conceptarchitect.unittest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleTestRunner {

	public void runTest(Class cls) throws InstantiationException, IllegalAccessException {

		List<Method> testMethods = Arrays
									.asList(cls.getMethods())
									.stream()
									//.filter(m -> m.getName().startsWith("test"))
									.filter(m-> m.getAnnotationsByType(TestMethod.class).length>0)
									.filter(m -> !Modifier.isStatic(m.getModifiers()))
									.collect(Collectors.toList());

		Method initMethod = null;

		try {
			initMethod = cls.getMethod("init");
		} catch (NoSuchMethodException ex) {
			// do nothing. Its ok not to have init
		}

		
		Object testObject = cls.newInstance();
		List<TestResult> result = new ArrayList<>();

		for (Method testMethod : testMethods) {
			try {

				if (initMethod != null)
					initMethod.invoke(testObject);

				testMethod.invoke(testObject);
				result.add(new TestResult(testMethod));

			} catch (Exception ex) {

				Throwable cause = ex.getCause();

				if (ex instanceof InvocationTargetException &&  cause instanceof AssertionFailedException) {
					result.add(new TestResult(testMethod, cause, TestStatus.Failure));

				} else {
					result.add(new TestResult(testMethod, cause, TestStatus.Error));
				}

			}

		}
		
		
		System.out.println("Failed Tests");
		result
			.stream()
			.filter(r->r.status==TestStatus.Failure)
			.forEach(
					r->{
						System.out.printf("\t\t%s :\t %s\n",r.getMethod().getName(),r.getFailure().getMessage());
					});
		
		System.out.println("Errors");
		result
		.stream()
		.filter(r->r.status==TestStatus.Error)
		.forEach(
				r->{
					System.out.printf("\t\t%s :\t %s\n",r.getMethod().getName(),r.getFailure().getMessage());
				});
		
		
		List<String> success= result
								.stream()
								.filter(r->r.isSuccess())
								.map(r->r.getMethod().getName())
								.collect(Collectors.toList());
		
		System.out.println("Success:"+success.size()+" out of "+result.size());
		success
			.forEach(s->System.out.println("\t"+s));
		

	}

}
