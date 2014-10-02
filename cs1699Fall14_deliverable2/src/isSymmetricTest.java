import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class isSymmetricTest {

	@Test
	//Test 1
	//This test ensures that when isSymmetric() is called
	//on an empty (null) tree, it returns true
	//The return result should be true
	public void emptyTreeTest() {
		ListOperations lo= new ListOperations();
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;
		
		boolean result = tr.isSymmetric(root,lo);
		assertTrue(result);
	}

	@Test
	//Test 2
	//This test ensures that when isSymmetric() is called
	//on a symmetric, complete three level tree using a stub,
	// it returns true
	public void completeThreeLevelTreeTestUsingStub1() {
		ListOperations lo2=mock(ListOperations.class);
		
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(5);
		TreeNode p6= new TreeNode(4);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; p2.right=p6;
		
		when(lo2.check2StringListEqual(any(List.class), any(List.class))).thenReturn(true);
		assertTrue(tr.isSymmetric(root,lo2));
	}

	@Test
	//Test 3
	//This test ensures that when isSymmetric() is called on a symmetric 3 level complete binary tree,
	//the return value is true.
	//A stub is used to replace the return value of the check2StringListEqual function.
	//The return result should be true.
	public void completeThreeLevelTreeTestUsingStub2() {		
		TreeTraversal tr = new TreeTraversal();//mock(TreeTraversal.class);
		ListOperations lo=mock(ListOperations.class);
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(5);
		TreeNode p6= new TreeNode(4);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; p2.right=p6;
		
		when(lo.check2StringListEqual(any(List.class), any(List.class))).thenReturn(true);
		assertTrue(tr.isSymmetric(root,lo));
		
		
		List<String> l=new ArrayList<String>();
		List<String> r=new ArrayList<String>();
		l.add(Integer.toString(p1.val));
		l.add(Integer.toString(p3.val));
		l.add("n");
		l.add("n");
		l.add(Integer.toString(p4.val));
		l.add("n");
		l.add("n");
		
		r.add(Integer.toString(p2.val));
		r.add(Integer.toString(p6.val));
		r.add("n");
		r.add("n");
		r.add(Integer.toString(p5.val));
		r.add("n");
		r.add("n");
		
		when(lo.check2StringListEqual(l, r)).thenReturn(true);
		assertTrue(tr.isSymmetric(root,lo));
		verify(lo,times(0)).check2StringListEqual(l, r);
	}
	
	@Test
	//Test 4
	//This test ensures that when isSymmetric() is called on an asymmetric,
	//complete three level tree, the return value is false.
	public void completeThreeLevelAsymmetricTreeTest() {
		ListOperations lo= new ListOperations();
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(5);

		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; //p2.right=p6;
		
		assertFalse(tr.isSymmetric(root,lo));
	}
	
	@Test
	//Test 5
	//This test ensures that when isSymmetric() is called on an asymmetric, 3 level complete binary tree,
	//the return value is false.
	//A stub is used to replace the return value of the check2StringListEqual function in ListOperations.
	//The return result should be false
	public void completeThreeLevelAsymmetricTreeTestUsingStub() {		
		TreeTraversal tr = new TreeTraversal();
		ListOperations lo=mock(ListOperations.class);
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(5);

		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; 
		
		List<String> l=new ArrayList<String>();
		List<String> r=new ArrayList<String>();
		l.add(Integer.toString(p1.val));
		l.add(Integer.toString(p3.val));
		l.add("n");
		l.add("n");
		l.add(Integer.toString(p4.val));
		l.add("n");
		l.add("n");
		
		r.add(Integer.toString(p2.val));

		r.add(Integer.toString(p5.val));
		r.add("n");
		r.add("n");
		
		when(lo.check2StringListEqual(l, r)).thenReturn(true);
		assertFalse(tr.isSymmetric(root,lo));
	}
	
	@Test
	//Test 6
	//This test ensures that when isSymmetric is called on an asymmetric, 100 level tree,
	//the return result is false.
	//The tree in test has linked-list type branches on the left and right of the root,
	//which helps test recursive properties of the function.
	public void bigTreeTest() {
		ListOperations lo= new ListOperations();
		TreeTraversal tr = new TreeTraversal();
		int treeSize=1000;
		TreeNode r1= new TreeNode(0);
		TreeNode root1=r1;
		for(int i=1; i<treeSize; i++){
			r1.left= new TreeNode(i);
			r1=r1.left;
		}
		assertFalse(tr.isSymmetric(root1,lo));
		
		TreeNode r2= new TreeNode(0);
		TreeNode root2=r2;
		for(int i=1; i<treeSize; i++){
			r2.right= new TreeNode(i);
			r2=r2.right;
		}		
		assertFalse(tr.isSymmetric(root2,lo));
	}
	
}
