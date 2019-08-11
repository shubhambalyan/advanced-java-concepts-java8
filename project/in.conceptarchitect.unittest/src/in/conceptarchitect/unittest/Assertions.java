package in.conceptarchitect.unittest;

public class Assertions {

	public static void shouldBeEqual(Object expected, Object actual) {
		if(!expected.equals(actual))
			throw new AssertionFailedException("Objects Not Equals - expected:"+expected+"\tActual:"+actual);
	}
	
	public static void shouldNotBeEqual(Object expected, Object actual) {
		if(expected.equals(actual))
			throw new AssertionFailedException("Objects Are Equals - expected:"+expected+"\tActual:"+actual);
	}
	
	public static void shouldBeNull(Object target) {
		if(target!=null)
			throw new AssertionFailedException("Objects is Not Null :"+target);
	}
	
	public static void shouldNotBeNull(Object target) {
		if(target==null)
			throw new AssertionFailedException("Objects  is Null :");
	}
	
	public static void shouldBeTrue(boolean value) {
		if(value==false)
			throw new AssertionFailedException("Object found false");
	}
	
	public static void shouldBeFalse(boolean value) {
		if(value==true)
			throw new AssertionFailedException("Object found true");
	}
	
	public static void shouldThrow(Class exCls, Action action) {
		try {
			action.execute();
			throw new AssertionFailedException("Expected Exception was not thrown "+exCls);
		} catch( Exception ex) {
			if (!ex.getClass().equals(exCls))
				throw ex;
			
		}
		
	}

	

}
