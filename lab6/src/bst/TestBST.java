package bst;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//  import bst.BinarySearchTree;

public class TestBST {
    private BinarySearchTree<Integer> BstInt; 
    private BinarySearchTree<String> BstString;
    @BeforeEach
    void setUp(){
        //Sortera efter heltal
        BstInt = new BinarySearchTree<>();
        //Sortera alfabetiskt
        BstString = new BinarySearchTree<>((e1, e2) -> Character.compare(e1.charAt(0), e2.charAt(0)));
    }

    @AfterEach
    void tearDown(){
        BstInt = null;
        BstString = null;
    }

    @Test
    void testHeight(){
        //##################################
        assertEquals(0, BstInt.height());
        BstInt.add(7);
		BstInt.add(3);
		BstInt.add(11);
		BstInt.add(1);
		BstInt.add(5);
		BstInt.add(9);
		BstInt.add(13);
        assertEquals(3, BstInt.height());
        //#################################
        assertEquals(0, BstString.height());
        BstString.add("B");
        BstString.add("A");
        BstString.add("C");
        assertEquals(2, BstString.height());
    }
    
    @Test
    void testSize(){
        //######################################
        assertEquals(0, BstInt.size());
        BstInt.add(7);
		BstInt.add(3);
		BstInt.add(11);
		BstInt.add(1);
		BstInt.add(5);
		BstInt.add(9);
		BstInt.add(13);
        assertEquals(7, BstInt.size());
        assertEquals(3, BstInt.height());
        BstInt.clear();
        //######################################
        assertEquals(0, BstString.size());
        BstString.add("B");
        BstString.add("A");
        BstString.add("C");
        assertEquals(3, BstString.size());
    }

    @Test
    void testClear(){
        //######################################
        BstInt.add(7);
		BstInt.add(3);
		BstInt.add(11);
		BstInt.add(1);
		BstInt.add(5);
		BstInt.add(9);
		BstInt.add(13);
        assertEquals(7, BstInt.size());
        assertEquals(3, BstInt.height());
        BstInt.clear();
        assertEquals(0, BstInt.size());
        assertEquals(0, BstInt.height());
        //######################################
        assertEquals(0, BstString.size());
        assertEquals(0, BstString.height());
        BstString.add("B");
        BstString.add("A");
        BstString.add("C");
        assertEquals(3, BstString.size());
        assertEquals(2, BstString.height());
        BstString.clear();
        assertEquals(0, BstString.size());
        assertEquals(0, BstString.height());
        
    }

    @Test
    void testAdd(){
        //#######################################
        assertEquals(0, BstInt.size());
        assertEquals(0, BstInt.height());
        BstInt.add(7);
		BstInt.add(3);
		BstInt.add(11);
		BstInt.add(1);
		BstInt.add(5);
		BstInt.add(9);
		BstInt.add(13);
        assertEquals(7, BstInt.size());
        assertEquals(3, BstInt.height());
        //#######################################
        assertEquals(0, BstString.size());
        assertEquals(0, BstString.height());
        BstString.add("B");
        BstString.add("A");
        BstString.add("C");
        assertEquals(3, BstString.size());
        assertEquals(2, BstString.height());
    }
}
