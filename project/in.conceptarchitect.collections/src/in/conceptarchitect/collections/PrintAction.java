package in.conceptarchitect.collections;

public class PrintAction<X> implements Action<X> {

	Printer printer;
	
	public  PrintAction(Printer printer) {
		this.printer=printer;
	}
	
	@Override
	public void actOn(X value) {
		// TODO Auto-generated method stub
		printer.print(value);
	}

}
