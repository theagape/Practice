/**
 * 
 */
package com.amazon.algorithm;

import java.util.ArrayDeque;

/**
 * @author theagape
 *
 */
public class MyBinaryTree {
	
	public int pLevel = -1;
	public ArrayDeque<Node> queue;
	
	public MyBinaryTree() {
		this.queue = new ArrayDeque<Node>();
	}
	
	public void setRoot(Node node) {
		// this.root = node;
		// this.queue.add(node);
	}
	
	public void printTree(Node node) {
		//System.out.println(this.pLevel);
		//System.out.println(node.level);
		
		if (this.pLevel == -1) {
			System.out.print(node.value);
		}
		else if (this.pLevel < node.getLevel()) {
			System.out.print("\n" + node.value);
		}
		else if (this.pLevel == node.getLevel()) {
			System.out.print(", " + node.value);
		}
		// updates pLevel with current level
		this.pLevel = node.getLevel();
		
		if (node.left != null) {
			this.queue.add(node.left);
		}
		if (node.right != null) {
			this.queue.add(node.right);
		}
		
		if (this.queue.isEmpty() == false) {
			this.printTree(this.queue.remove());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
	    * Example input:
		
		    5
		   / \
		  3   1
		/   / \
		9   4   5
		   /
		  2
		
		Example output:
		5
		3,1
		9,4,5
		2
		 */
		
		MyBinaryTree binTree = new MyBinaryTree();
		
		Node n5 = new Node(5);
		n5.setRoot();
		Node n3 = new Node(3);
		Node n1 = new Node(1);
		n5.setLeft(n3);
		n5.setRight(n1);
		Node n9 = new Node(9);
		n3.setLeft(n9);
		Node n4 = new Node(4);
		Node n5d = new Node(5);
		n1.setLeft(n4);
		n1.setRight(n5d);
		Node n2 = new Node(2);
		n4.setLeft(n2);
		
		binTree.printTree(n5);
		
		System.out.println();
		System.out.println(">> test <<");
		
		MyBinaryTree binTreeTest = new MyBinaryTree();
		
		Node nn1 = new Node(1);
		nn1.setRoot();
		
		Node nn2 = new Node(2);
		Node nn3 = new Node(3);
		nn1.setLeft(nn2);
		nn1.setRight(nn3);
		
		Node nn4 = new Node(4);		
		Node nn5 = new Node(5);
		nn2.setLeft(nn4);
		nn2.setRight(nn5);
		
		Node nn6 = new Node(6);
		Node nn7 = new Node(7);
		nn3.setLeft(nn6);
		nn3.setRight(nn7);
		
		Node nn8 = new Node(8);
		nn5.setRight(nn8);
		
		Node nn9 = new Node(9);
		nn7.setRight(nn9);
		
		Node nn10 = new Node(10);
		nn8.setLeft(nn10);
		
		binTreeTest.printTree(nn1);
		
		

	}

}
