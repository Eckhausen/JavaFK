package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {		
		if(last == null){ //Listan är tom. Skapar en som pekar på sig själv.
			last = new QueueNode<>(e);
			last.next = last;
			size++;
			return true;
		} else { //Mer än en, skapar ny nod som pekar på den första, 
			QueueNode<E> temp = new QueueNode<E>(e);
			temp.next = last.next;
			last.next = temp;
			last = temp;
			size++;		
			return true;
		}
		
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return this.size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(!(last == null)){
			return last.next.element;
		}
		return null;
		
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		QueueNode<E> firstNode; 
		if(last == null){ //Tom lista
			return null;
		}
		if(last.next == last){ //En nod i listan.
			firstNode = last;
			last = null;
			size--;
			return firstNode.element;
		} else {
			firstNode = last.next;
			last.next = last.next.next;
			size--;
			return firstNode.element;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() { 
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private QueueIterator(){
			this.pos = last.next;
		}
		
		@Override
		public boolean hasNext() {
			return pos != null;
		}
		
		@Override
		public E next() {
			QueueNode<E> temp;
			temp = pos;
			if(hasNext()){
				pos = pos.next;
				return temp.next.element;
			} else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}


}
