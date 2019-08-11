package in.conceptarchitect.collections;

import org.junit.Assert;
import org.junit.Test;
@Deprecated
public class IntBinarySearchTree {

	class Node{
		
		 int value;
		 Node left;
		 Node right;
		 //Node parent;
		
		public Node(int value) {
			this.value=value;
		}
	}
	
	
	Node root;
	private int count=0;
	
	public void add(int value) {
		root=add(root,value);
		//count++;
	}
	
	Node add(Node root, int value){
		
		if(root==null){
			Node newNode=new Node(value);
			root=newNode;
			count++;
			
		}  else if (value < root.value) {			
			root.left= add(root.left, value); 
		} else if(value>root.value){
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
	
	
	
	
	//DONT USE THIS KIND OF TEST
	public static class TestClass{
		
		@Test
		public void countChangesOnAdd() {
			IntBinarySearchTree tree=new IntBinarySearchTree();
			tree.add(20);
			Assert.assertEquals(1,tree.count);
		}
		
	}

}
