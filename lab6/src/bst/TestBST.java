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
        assertEquals(0, BstInt.height());
        BstInt.add(1);
        BstInt.add(2);
        BstInt.add(3);
        assertEquals(3, BstInt.size());
        // assertEquals(0, BstString.height());
    }
    
    @Test
    void testSize(){

    }

    @Test
    void testClear(){

    }

    @Test
    void testAdd(){

    }
}
