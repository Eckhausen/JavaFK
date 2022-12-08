package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random; //TEMP


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree. 
	 */
	public BinarySearchTree() {
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2); 
		root = null;
		size = 0;
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
		root = null;
		size = 0;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) { //DriverMetod
		if(size == 0){
			root = new BinaryNode<E>(x);
			size ++;
			return true;
		}
		return add(root, x);
	}
	
	private boolean add(BinaryNode<E> node, E x) {
		//Ifall noden är större än X, placera x till vänster. 
		if(comparator.compare(node.element, x) > 0){
			if(node.left == null){
				node.left = new BinaryNode<E>(x);
				size++;
				return true;
			} else {
				return add(node.left, x);
			}
		//Ifall noden är mindre än X, placera x till höger.
		}else if(comparator.compare(node.element, x) < 0){
			if(node.right == null){
				node.right = new BinaryNode<E>(x);
				size++;
				return true;
			}else{
				return add(node.right, x);
		}
	}return false;
}

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return levels(root);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		inOrder(root);
	}

	private void inOrder(BinaryNode<E> root) {
		if(root != null){
			inOrder(root.left); //Om placerad här blir de PreOrder
			System.out.println(root.element); //InOrder
			inOrder(root.right); //PostOrder
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<>();
		toArray(root, sorted); 
		root = buildTree(sorted, 0, sorted.size()-1); 
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> node, ArrayList<E> sorted) {
		if(node != null){
			toArray(node.left, sorted); //Rekursion för att traversera ner till vänster
			sorted.add(node.element); //"Rotnoden"
			toArray(node.right, sorted); //Traversera ner till höger.
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		int mid = (first + last) / 2; 
		BinaryNode<E> midNode = new BinaryNode<E>(sorted.get(mid)); //Ta midpunkten
		if(last < first){ //Om listan blir tom returnera null nod.
			midNode = null;
			return midNode;
		} else {
			midNode.left = buildTree(sorted, first, mid-1);
			midNode.right = buildTree(sorted, mid+1, last);
		}
		return midNode;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}

	private int levels(BinaryNode<E> node){
		if(node == null){ 
			return 0;
		} else {
			return 1 + Math.max(levels(node.left), levels(node.right));		//1 + högsta subnod.
		}
	}
	//#---Main----------------------#
	public static void main(String[] args) {
		Random rand = new Random();
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		BSTVisualizer vis = new BSTVisualizer("Tree visualizer", 500, 500);
		
		for(int i = 0; i < 20; i++){ //Skriver inte ut alla? Begränsad i BSTVis?
			bst.add(rand.nextInt(20)+1);
		}
		
		// bst.add(7);
		// bst.add(3);
		// bst.add(11);
		// bst.add(1);
		// bst.add(5);
		// bst.add(9);
		// bst.add(13);
		
		bst.rebuild();
		bst.printTree();
		vis.drawTree(bst);
	}
}

//#######Diskussion#########
//1. I vissa av de uppgifter du löst t.ex height och add finns det en publik metod som anropar motsvarande rekursiva metod.
//Varför behövs bägge metoderna?
//
//### Användaren skall inte behöva skicka in massa parametervärden samt bör inte göra det pga säkerhet. Kan ställa till det en del annars. 
//	  Rekursion bör alltid vara i privata metoder.
//
//2. I samband med ombyggnaden av trädet används en lista av typen ArrayList för att mellanlagra elementen. 
//Skulle man lika gärna kunna använda en LinkedList?
//
//### Tidskomplexiteten för LinkedList när det kommer till att komma åt elementen är O(n)(linjär) jämfört med ArrayList som är O(1)(konstant).
