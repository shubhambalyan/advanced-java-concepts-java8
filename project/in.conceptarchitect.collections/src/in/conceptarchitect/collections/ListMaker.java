package in.conceptarchitect.collections;

public class ListMaker<X> implements ReturnableAction<X,LinkedList<X>> {

	LinkedList<X> list=new LinkedList<X>();
	
	
	@Override
	public void actOn(X value) {
	
		list.add(value);
		
	}


	public LinkedList<X> getList() {
		return list;
	}
	
	public LinkedList<X> result(){
		return list;
	}
	
	

}
