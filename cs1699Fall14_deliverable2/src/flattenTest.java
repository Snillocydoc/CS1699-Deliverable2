import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class flattenTest {

	@Test
	//Test 1
	//This test ensures that when flatten() is called on an empty (null) tree,
	//it returns an empty (null) linked-list
	public void emptyTreeTest() {
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;
		
		tr.flatten(root);
		assertEquals(root,null);
	}

	@Test
	//Test 2
	//This tests ensures that when flatten() is called on a complete,
	//three level tree, the correct linked-list is returned.
	//The resulting linked-list should be with values 1->2->3->4->5->6->7
	public void completeThreeLevelTreeTest() {		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(5);
		TreeNode p3= new TreeNode(3);
		TreeNode p4= new TreeNode(4);
		TreeNode p5= new TreeNode(6);
		TreeNode p6= new TreeNode(7);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; p2.right=p6;
		
		tr.flatten(root);
		TreeNode curr=root;
		for(int i=0; i<7; i++){
			assertEquals(curr.val,i+1);
			curr=curr.right;
		}
	}
	
	@Test
	//Test 3
	//This test ensures that when flatten() is called on an incomplete,
	//three level tree, the correct linked-list is returned
	//the result linked list should be with values 1->2->3->4->5
	public void inCompleteThreeLevelTreeTest() {		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(5);
		TreeNode p3= new TreeNode(3);
		TreeNode p4= new TreeNode(4);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4;
		
		tr.flatten(root);
		TreeNode curr=root;
		for(int i=0; i<5; i++){
			assertEquals(curr.val,i+1);
			curr=curr.right;
		}
	}
	
	@Test
	//Test 4
	//This test ensures that when flatten() is called on a 1000 level tree,
	//the correct linked-list is returned.
	//The tree created has linked-list type branches on the left and right of the root,
	//which helps in specifically testing some of the recursive properties of the flatten() function.
	//The resulting linked-list should be with values 1->2->3->4->...->1000
	public void bigLeftRightTreeTest() {
		TreeTraversal tr = new TreeTraversal();
		int treeSize=1000;
		TreeNode r1= new TreeNode(0);
		TreeNode root1=r1;
		for(int i=1; i<treeSize; i++){
			r1.left= new TreeNode(i);
			r1=r1.left;
		}
		tr.flatten(root1);
		
		TreeNode curr=root1;
		for(int i=0; i<treeSize; i++){
			assertEquals(curr.val,i);
			curr=curr.right;
		}
		TreeNode r2= new TreeNode(0);
		TreeNode root2=r2;
		for(int i=1; i<treeSize; i++){
			r2.left= new TreeNode(i);
			r2=r2.left;
		}
		tr.flatten(root2);
		
		TreeNode curr2=root2;
		for(int i=0; i<treeSize; i++){
			assertEquals(curr2.val,i);
			curr2=curr2.right;
		}
	}
}