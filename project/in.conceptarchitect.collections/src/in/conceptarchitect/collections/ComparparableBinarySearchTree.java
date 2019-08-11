package in.conceptarchitect.collections;

public class ComparparableBinarySearchTree<E extends Comparable<E>> {

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
	
	public ComparparableBinarySearchTree(boolean allowDuplicate) {
		this.allowDuplicate=allowDuplicate;
	}
	
	public ComparparableBinarySearchTree() {
		this(true);
	}
	
	Node root;
	private int count=0;
	
	public void add(E value) {
		root=add(root,value);
		//count++;
	}
	
	Node add(Node root, E value){
		
		
		if(root==null){
			Node newNode=new Node(value);
			root=newNode;
			count++;
			return root;
		}  
		
		int diff= value.compareTo(root.value);
		
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
	
	
	public void inorder() {
		
		if(root!=null) {
			inorder(root);
		}		
	}
	
	private void inorder(Node root) {
		if(root==null)
			return ;
		
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);
	}
	
	
	
	public void preorder() {
		
		if(root!=null) {
			inorder(root);
		}		
	}
	
	private void preorder(Node root) {
		if(root==null)
			return ;
		
		System.out.println(root.value);
		
		preorder(root.left);

		preorder(root.right);
	}
	
	
	

}
