package in.conceptarchitect.collections;

public class NullPrinter implements Printer {

	public NullPrinter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print(Object value) {

		//This is all I do

	}
	
	public static final Printer instance=new NullPrinter();

}
