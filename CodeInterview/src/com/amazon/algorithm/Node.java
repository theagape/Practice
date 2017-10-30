package com.amazon.algorithm;

public class Node {
	public int value;
	public Node left;
	public Node right;
	private int level;
	
	public Node(int val) {
		this.value = val;
		this.left = null;
		this.right = null;
		this.level = -1;
	}
	
	public void setRoot () {
		this.level = 0;
	}
	
	public void setLeft (Node node) {
		this.left = node;
		this.left.level = this.level + 1;
	}
	
	public void setRight (Node node) {
		this.right = node;
		this.right.level = this.level + 1;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
	
	public int getLevel () {
		return this.level;
	}

}
