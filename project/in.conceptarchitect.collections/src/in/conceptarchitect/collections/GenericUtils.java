package in.conceptarchitect.collections;

public class GenericUtils {
	
	public static <E> LinkedList<E> createList(E ... values){
		LinkedList<E> newList=new LinkedList<>();
		
		for(E value :values)
			newList.add(value);
		
		return newList;
	}
	
	public static <E> void printInfo(E value) {
		System.out.printf("Type is %s\tvalue=%s\n",value.getClass(), value);
	}
	
	public static <E> int getId(E object) {
		return object.hashCode();
	}
	
	
	public static <E> int countItems(LinkedList<E> list) {
		int c=0;
		for(int i=0;i<list.size();i++) {
			E item=list.get(i);
			c++;
		}
		
		return c;
	}
	
	
	public static  int countItems2(LinkedList<Object> list) {
		int c=0;

		for(int i=0;i<list.size();i++) {
			Object item=list.get(i);
			c++;
		}
		
		list.add("hello world");
		
		return c;
	}
	
	

	public static  int countItems3(LinkedList<?> list) {
		int c=0;

		for(int i=0;i<list.size();i++) {
			Object item=list.get(i);
			c++;
		}
		
		//list.add("hello world");
		
		return c;
	}

	
	public static <E> void   addValues(LinkedList<? super E> target, 
								LinkedList<? extends E> source) {
		
		for(E value : source) {
			target.add(value);
		}
	}
	
	

}
