package testapp.linkedlist;

import in.conceptarchitect.collections.StringLinkedList;

public class Program {

	public static void main(String[] args) {
		
		StringLinkedList list=new StringLinkedList();
		
		for(int i=0;i<10;i++)
			list.add(""+i);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void test() {
		// TODO Auto-generated method stub
		StringLinkedList names=new StringLinkedList();  //linked list of strings
		
		

		names.add("India"); //should add to the end of the list
		names.add("USA");   
		names.add("UK");
		
		
		
		
		testAddToList(names);
		
		
		//String str = names.get(20);
		
		
		//testListGetAndSet(names);
		
		
		testRemove(names,0);
		
		testRemove(names, 3);
		
		
		
		
		
		
		
		

	}

	private static void testRemove(StringLinkedList names, int pos) {
		System.out.println("current list is "+names);
		System.out.println("trying to remove item from position "+pos);
		String name=names.remove(pos);
		System.out.println("removed item is "+name); //should be UK
		System.out.println("After removal list is "+names); //should contains [India USA ]
		System.out.println("\n\n");
	}

	private static void testListGetAndSet(StringLinkedList names) {
		System.out.println("Testing get/set");
		for(int i=0;i<names.size();i++) {
			String str= names.get(i);
			System.out.println(str);
			names.set(i,str.toLowerCase());
		}
		testAddToList(names);
	}

	private static void testAddToList(StringLinkedList names) {
		System.out.println("Testing add item");
		names.add("France");
		System.out.println("List is "+names);
		System.out.println("List size is "+names.size());
		System.out.println("\n\n");
	}

}
