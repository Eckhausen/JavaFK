package testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import queue_delegate.FifoQueue;
import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

class TestAppendFifoQueue {
	private FifoQueue<Integer> list1;
    private FifoQueue<Integer> list2;
	private Queue<String> myStringQueue;
    
    

	@BeforeEach
	void setUp() {
		list1 = new FifoQueue<Integer>();
        list2 = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
        
	}

	@AfterEach
	void tearDown(){
		list1 = null;
        list2 = null;
		myStringQueue = null;
	}

	/**
	 * Test if a newly created queue is empty.
	 */
	@Test
	void testNewFifoQueue() {
		assertTrue(list1.isEmpty(), "Wrong result from empty of queue");
		assertEquals(0, list1.size(), "Wrong size of empty queue");
	}

	/** Test a single offer followed by a single peek. */
	@Test
	void testPeek() {
		list1.offer(1);
		int i = list1.peek();
		assertEquals(1, i, "peek on queue of size 1");
		assertEquals(1, list1.size(), "peek on queue of size 1");
	}

	/**
	 * Test a single offer followed by a single poll.
	 */
	@Test
	void testPoll() {
		list1.offer(1);
		int i = list1.poll();
		assertEquals(1, i, "poll on queue of size 1");
		assertEquals(0, list1.size(), "Wrong size after poll");
	}

	/**
	 * Test peek of empty queue.
	 */
	@Test
	void testPeekOfEmpty() {
		assertEquals(null, list1.peek(), "Front of empty queue not null");
	}

	/**
	 * Test poll of empty queue.
	 */
	@Test
	void testPollOfEmpty() {
		assertEquals(null, list1.poll(), "Poll of empty queue should return null") ;
	}

	/**
	 * Test that implementation works for a queue of strings.
	 */
	@Test
	void testStringQueue() {
		myStringQueue.offer("First");
		myStringQueue.offer("Second");
		myStringQueue.offer("Third");
		assertEquals(3, myStringQueue.size(), "Wrong size of queue");
		assertEquals("First", myStringQueue.peek(), "peek on queue of strings");
		assertEquals("First", myStringQueue.poll(), "String First expected");
		assertEquals("Second", myStringQueue.poll(), "String Second expected");
		assertEquals("Third", myStringQueue.poll(), "String Third expected");
		assertTrue(myStringQueue.isEmpty(), "Queue of strings should be empty");
	}

	/**
	 * Test that polling gives elements in right order.
	 */
	@Test
	void testOrder() {
		list1.offer(1);
		list1.offer(2);
		list1.offer(3);
		list1.offer(4);
		list1.offer(5);
		for (int i = 1; i <= 5; i++) {
			int k = list1.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
		assertTrue(list1.isEmpty(), "Queue not empty");
	}

	/**
	 * Test that polling all elements gives an empty queue.
	 */
	@Test
	void testMakeQueueEmpty() {
		list1.offer(1);
		list1.offer(2);
		list1.poll();
		list1.poll();
		assertEquals(0,  list1.size(), "Wrong size after poll");
		assertTrue(list1.isEmpty(), "Queue not empty after poll");
		list1.offer(3);
		list1.offer(4);
		assertEquals(2, list1.size(), "Wrong size after offer");
		for (int i = 3; i <= 4; i++) {
			int k = list1.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
		assertEquals(0, list1.size(), "Wrong size after poll");
		assertTrue(list1.isEmpty(), "Queue not empty after poll");
	}

	/**
	 * Test iterator on empty queue.
	 */
	@Test
	void testIteratorEmptyQueue() {
		Iterator<Integer> itr = list1.iterator();
		assertFalse(itr.hasNext(), "Wrong result from next in empty queue");
		assertThrows(NoSuchElementException.class, () -> itr.next());
	}

	/**
	 * Test iterator on non empty queue.
	 */
	@Test
	void testIteratorNonEmptyQueue() {
		int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			list1.offer(i);
		}
		Iterator<Integer> itr = list1.iterator();
		assertTrue(itr.hasNext(), "Wrong result from hasNext");
		for (int i = 1; i <= nbr; i++) {
			assertTrue(itr.hasNext(), "Wrong result from hasNext");
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
		}
		assertFalse(itr.hasNext(), "Wrong result from hasNext");
		assertThrows(NoSuchElementException.class, () -> itr.next());
	}

	/**
	 * Test iterator multiple times, to ensure that the iterator does not modify the
	 * queue.
	 */
	@Test
	void testThreeIterators() {
		int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			list1.offer(i);
		}

		// first, set up two iterators at the same time, and check that they both work

		Iterator<Integer> itr1 = list1.iterator();
		Iterator<Integer> itr2 = list1.iterator();
		
		for (int i = 1; i <= nbr; i++) {
			assertTrue(itr1.hasNext(), "Wrong result from itr1.hasNext");
			assertEquals(Integer.valueOf(i), itr1.next(), "Wrong result from itr1.next");
		}
		
		for (int i = 1; i <= nbr; i++) {
			assertEquals(Integer.valueOf(i), itr2.next(), "Wrong result from itr2.next");
		}

		// then, test a third iterator after the previous iterations
		
		Iterator<Integer> itr3 = list1.iterator();
		for (int i = 1; i <= nbr; i++) {
			assertTrue(itr3.hasNext(), "Wrong result from itr3.hasNext");
			assertEquals(Integer.valueOf(i), itr3.next(), "Wrong result from itr3.next");
		}
	}

    @Test
    void two_empty_queues() {
        assertEquals(0, list1.size(), "Wrong size for queue 1");
        assertEquals(0, list2.size(), "Wrong size for queue 1");
        list1.append(list2);
        
        assertTrue(list1.isEmpty(), "Queue 1 not empty.");
        assertTrue(list2.isEmpty(), "Queue 2 not empty.");
    }

    @Test
    void empty_queue_appended_to_non_empty_queue(){
        list1.offer(1);
        list1.offer(2);
        assertFalse(list1.isEmpty(), "Queue 1 is empty"); //Ska inte va tom
        assertTrue(list2.isEmpty(), "Queue 2 is empty"); //Ska va tom
        
        list1.append(list2);
        assertEquals(2, list1.size(), "Wrong size");
        
        assertEquals(1, list1.poll(), "sadasdasd");
        assertEquals(2, list1.poll(), "sadasdasd");
        assertEquals(null, list1.poll(), "sadasdasd");
        assertEquals(0, list1.size(), "Wrong size");


    }

    @Test
    void non_empty_queue_appended_to_empty_queue(){
        list2.offer(1);
        list2.offer(2);
        list1.append(list2);
        
        assertEquals(1, list1.poll());
        assertEquals(2, list1.poll());
        assertEquals(null, list1.poll());
        assertTrue(list2.isEmpty(),"List 2 is NOT empty.");
        assertEquals(0, list1.size()); 
    }

    @Test
    void two_non_empty_queues(){
        list1.offer(1);
        list1.offer(2);
        list2.offer(3);
        list2.offer(4);
        list1.append(list2);

        assertEquals(1, list1.poll());
        assertEquals(2, list1.poll());
        assertEquals(3, list1.poll());
        assertEquals(4, list1.poll());
        
        assertEquals(null, list1.poll());
        assertEquals(0, list1.size());
    }

    @Test
    void append_to_itself(){
        assertThrows(IllegalArgumentException.class, () -> {
            list1.append(list1);
    });
    }
}
