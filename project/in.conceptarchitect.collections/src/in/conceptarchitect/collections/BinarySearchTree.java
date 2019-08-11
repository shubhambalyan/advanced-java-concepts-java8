package in.conceptarchitect.collections;

public class BinarySearchTree<E>  implements Container<E>{

	class Node{
		
		 E value;
		 Node left;
		 Node right;
		 //Node parent;
		
		public Node(E value) {
			this.value=value;
		}
	}
	
	
	boolean allowDuplicate=false;
	Comparer<E> comparer;
	
	public BinarySearchTree(Comparer<E> comparer, boolean allowDuplicate) {
		this.allowDuplicate=allowDuplicate;
		this.comparer=comparer;
	}
	
	public BinarySearchTree(Comparer<E> comparer) {
		this(comparer, true);
	}
	
	Node root;
	private int count=0;
	
	public Container<E> add(E value) {
		root=add(root,value);
		//count++;
		return this;
	}
	
	Node add(Node root, E value){
		
		
		if(root==null){
			Node newNode=new Node(value);
			root=newNode;
			count++;
			return root;
		}  
		
		
		
		//int diff= value.compareTo(root.value);
		
		int diff= comparer.compare(value, root.value);
		
		if (diff<0 || diff==0 && allowDuplicate) {
			
			root.left= add(root.left, value);
			
		} else if(diff>0){
			
			root.right= add(root.right, value);
			
		}
		
		return root;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	@Deprecated
	public void inorder() {
		inorder(System.out::println);
	}
	
	@Deprecated
	public void print(PrintAction<E> printAction) {
		inorder(printAction);
	}
	
	public void inorder(Action<E> action) {
		
		if(root!=null) {
			inorder(root,action);
		}		
	}
	
	private void inorder(Node root,Action<E> action) {
		if(root==null)
			return ;
		
		inorder(root.left,action);
		//System.out.println(root.value);
		action.actOn(root.value);
		
		inorder(root.right,action);
	}
	
	
	
	public void preorder(Action<E> action) {
		
		if(root!=null) {
			preorder(root,action);
		}		
	}
	
	private void preorder(Node root,Action<E> action) {
		if(root==null)
			return ;
		
		//System.out.println(root.value);
		action.actOn(root.value);
		
		preorder(root.left,action);

		preorder(root.right,action);
	}

	@Override
	public <Output> Output each(ReturnableAction<E, Output> action) {
		// TODO Auto-generated method stub
		preorder(action);
		return action.result();
	}
	
	
	

}
