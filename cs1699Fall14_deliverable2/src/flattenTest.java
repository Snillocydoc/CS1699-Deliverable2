import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class flattenTest {

	@Test
	//test 1
	//this test tests the return result of an empty tree
	//the result linked list should be an empty linkedlist
	public void emptyTreeTest() {
		TreeTraversal tr = new TreeTraversal();
		TreeNode root=null;
		
		tr.flatten(root);
		assertEquals(root,null);
	}

	@Test
	//test 2
	//this test tests the return result of a complete 3 level binary tree
	//the result linked list should be with values 1->2->3->4->5->6->
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
	//test 3
	//this test tests the return result of an incomplete 3 level binary tree
	//the result linked list should be with values 1->2->3->4
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
	//test 4
	//this test tests the return result of a left/right node only 1000 level binary tree
	//the result linked list should be with values 1->2->3->4->...->1000
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
		///////////////////////////////////////////////
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
/*
	@Test
	//test 3
	public void completeThreeLevelTreeTestUsingStub() {		
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
	//test 4
	public void completeThreeLevelAsymmetricTreeTest() {
		ListOperations lo= new ListOperations();
		TreeTraversal tr = new TreeTraversal();
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(5);
//		TreeNode p6= new TreeNode(4);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; //p2.right=p6;
		
		assertFalse(tr.isSymmetric(root,lo));
	}
	
	@Test
	//test 5
	public void completeThreeLevelAsymmetricTreeTestUsingStub() {		
		TreeTraversal tr = new TreeTraversal();//mock(TreeTraversal.class);
		ListOperations lo=mock(ListOperations.class);
		TreeNode root= new TreeNode(1);
		TreeNode p1= new TreeNode(2);
		TreeNode p2= new TreeNode(2);
		TreeNode p3= new TreeNode(4);
		TreeNode p4= new TreeNode(5);
		TreeNode p5= new TreeNode(5);
//		TreeNode p6= new TreeNode(4);
		
		root.left=p1; root.right=p2;
		p1.left=p3; p1.right=p4; p2.left=p5; //p2.right=p6;
		
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
//		r.add((char)p6.val);
//		r.add('n');
//		r.add('n');
		r.add(Integer.toString(p5.val));
		r.add("n");
		r.add("n");
		
		when(lo.check2StringListEqual(l, r)).thenReturn(true);
		assertFalse(tr.isSymmetric(root,lo));
	}
	
	@Test
	//test 6
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
	*/
/*	@Test
	//test 7
	public void bigTreeTest() {
		TreeTraversal tr = new TreeTraversal();
		int treeSize=1000;
		TreeNode r1= new TreeNode(0);
		TreeNode root1=r1;
		for(int i=1; i<treeSize; i++){
			r1.left= new TreeNode(i);
			r1=r1.left;
		}
		assertFalse(tr.isSymmetric(root1));
		
		TreeNode r2= new TreeNode(0);
		TreeNode root2=r2;
		for(int i=1; i<treeSize; i++){
			r2.right= new TreeNode(i);
			r2=r2.right;
		}		
		assertFalse(tr.isSymmetric(root2));
	}*/
}
