/**
 * 
 */
package com.coupang.coding;

/**
 * @author David J. Lim
 *
 */
public class TransformStructure {

	/**
	 * 
	 */
	public TransformStructure() {
	}
	
	public int getDepth(BiNode root) {
		int depth = 0;
		
		depth = this.postOrder(root, 0);
		
		return depth;
	}
	
	private int postOrder(BiNode node, int d) {
		int depth = 0;
		int lDepth = 0;
		int rDepth = 0;
		
		if (node.node1 != null) {
			lDepth = this.postOrder(node.node1, d+1);
		}
		if (node.node2 != null) {
			rDepth = this.postOrder(node.node2, d+1);
		}
		
		depth = Math.max(Math.max(d, lDepth), rDepth);
		
		return depth;
	}
	
	private BiNode inOrderEnlist(BiNode node, BiNode tail) {
		
		BiNode listTail = tail;
		
		if (node.node1 != null) {
			listTail = this.inOrderEnlist(node.node1, listTail);
			node.node1.node2 = node;
		}
		
		if (listTail == null) {
			//
			// System.out.println("> node : " + node.data);
			listTail = node;
		}
		else {
			//
			// System.out.println("> node : " + node.data);
			listTail.node1 = node;
			listTail = node;
		}
		
		if (node.node2 != null) {
			listTail = this.inOrderEnlist(node.node2, listTail);
			node.node2.node2 = node;
		}
		
		return listTail;
	}
	
	public BiNode binaryTreeToList(BiNode root) {
		BiNode head = null;
		BiNode tail = null;
		
		head = root;
		
		while (head.node1 != null) {
			head = head.node1;
		}
		
		this.inOrderEnlist(root, tail);
		
		root.node2 = null;
		
		return head;
	}
	
	public BiNode listToBinaryTree(BiNode head, BiNode root) {
		
		/*
		// for debugging!!
		System.out.println("> BiNode.listToBinaryTree()");
		System.out.println(head.data);
		System.out.println(root.data);
		*/
		
		root = this.buildTree(head, root);
		
		return root;
	}
	
	private BiNode buildTree(BiNode head, BiNode root) {
		
		if (root == null) {
			return null;
		}
		else if (head == root) {
			root.node1 = null;
			root.node2 = null;
			return root;
		}
		
		/*
		// for debugging!!
		System.out.println("--- HEAD ---");
		this.printBiNode(head);
		System.out.println("--- ROOT ---");
		this.printBiNode(root);
		*/
		
		BiNode lhead = head;
		BiNode lroot = this.findLeftNode(head, root);
		// for debugging!!
		// System.out.println(">> l_head : " + lhead.data + "  l_root : " + lroot.data);
		
		BiNode rhead = root.node1;
		BiNode rroot = this.findRightNode(root);
		// for debugging!!
		// System.out.println(">> r_head : " + rhead.data + "  r_root : " + ((rroot == null) ? "null" : rroot.data));
		
		root.node1 = this.buildTree(lhead, lroot);
		root.node2 = this.buildTree(rhead, rroot);
		
		// for debugging!!
		// this.printBiNode(root);
		
		return root;
	}
	
	public BiNode findLeftNode(BiNode head, BiNode root) {
		BiNode lnode = null;
		
		lnode = head;
		while (lnode.node2 != root) {
			lnode = lnode.node2;
		}
		
		return lnode;
	}
	
	public BiNode findRightNode(BiNode root) {
		BiNode rnode = null;
		
		rnode = root.node1;
		while (rnode.node2 != root) {
			
			if (rnode.node2 == null) {
				return null;
			}
			
			rnode = rnode.node2;
		}
		
		return rnode;
	}
	
	public void printList(BiNode head) {
		BiNode node = head;
		
		System.out.print(node.data + "  ");
		while (node.node1 != null) {
			node = node.node1;
			System.out.print(node.data + "  ");
		}
		System.out.println();
	}
	
	public void printListNodesInverseLink(BiNode head) {
		BiNode node = head;
		
		System.out.print(node.node2.data + "  ");
		while (node.node1 != null) {
			node = node.node1;
			
			if (node.node2 == null) {
				System.out.print("_" + "  ");
			}
			else {
				System.out.print(node.node2.data + "  ");
			}
		}
		System.out.println();
	}
	
	public void printBinaryTreeInOrder(BiNode root) {
		System.out.println();
		this.printBiTreeInOrder(root);
		System.out.println();

	}
	
	private void printBiTreeInOrder(BiNode node) {
		if (node.node1 != null) {
			this.printBiTreeInOrder(node.node1);
		}
		System.out.println(node.data + "  ");
		if (node.node2 != null) {
			this.printBiTreeInOrder(node.node2);
		}
	}
	
	public void printBiNode(BiNode node) {
		System.out.println(">> Node Data : " + node.data);
		System.out.println("       node1 : " + ((node.node1 == null)? "null":node.node1.data));
		System.out.println("       node2 : " + ((node.node2 == null)? "null":node.node2.data));
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiNode node1 = new BiNode(1);
		BiNode node2 = new BiNode(2);
		BiNode node3 = new BiNode(3);
		node1.node1 = node2;
		node1.node2 = node3;
		
		BiNode node4 = new BiNode(4);
		BiNode node5 = new BiNode(5);
		node2.node1 = node4;
		node2.node2 = node5;
		
		BiNode node6 = new BiNode(6);
		BiNode node7 = new BiNode(7);
		node3.node1 = node6;
		node3.node2 = node7;
		
		BiNode node8 = new BiNode(8);
		// BiNode node9 = new BiNode(9);
		node4.node1 = node8;
		// node4.node2 = node9;
		
		/*
		BiNode node10 = new BiNode(10);
		BiNode node11 = new BiNode(11);
		node5.node1 = node10;
		node5.node2 = node11;
		
		BiNode node12 = new BiNode(12);
		BiNode node13 = new BiNode(13);
		node6.node1 = node12;
		node6.node2 = node13;
		
		BiNode node14 = new BiNode(14);
		BiNode node15 = new BiNode(15);
		node7.node1 = node14;
		node7.node2 = node15;
		*/
		
		TransformStructure trans = new TransformStructure();
		// System.out.println(trans.getDepth(node1));
		
		/**
		 * [1] Prints the binary tree by in-order traversal
		 */
		trans.printBinaryTreeInOrder(node1);
		
		/**
		 * [2] Transforms the binary tree into a list in-place method
		 */
		BiNode listHead = trans.binaryTreeToList(node1);
		
		/**
		 * [3] Prints the list
		 */
		trans.printList(listHead);
		
		// for debugging!!
		// prints the node2s that hold parent node
		trans.printListNodesInverseLink(listHead);
		
		BiNode root = node1;
		
		/**
		 * [4] Transforms the list into the binary tree in-place method
		 */
		root = trans.listToBinaryTree(listHead, root);
		
		/**
		 * [5] Prints the binary tree by in-order traversal, where the tree has been rebuilt.
		 *     -- you can find the order is correct.
		 */
		trans.printBinaryTreeInOrder(root);

	}

}
