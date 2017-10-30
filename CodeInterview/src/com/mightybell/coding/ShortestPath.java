/**
 * 
 */
package com.mightybell.coding;

import java.util.ArrayList;

/**
 * @author theagape
 *
 */
public class ShortestPath {

	/**
	 * 
	 */
	public ShortestPath() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Node> getShortestPath(Node n1, Node n2) {
		ArrayList<Node> spath = new ArrayList<Node>();
		
		
		
		return spath;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class Node {
		
		private int element;
		private ArrayList<Node> neighbors;
		
		public Node() {
			this.element = 0;
			this.neighbors = new ArrayList<Node>();
		}

		public int getElement() {
			return element;
		}

		public void setElement(int element) {
			this.element = element;
		}

		public ArrayList<Node> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(ArrayList<Node> neighbors) {
			this.neighbors = neighbors;
		}
		
		public void addNeighbor(Node node) {
			this.neighbors.add(node);
		}
		
	}

}
