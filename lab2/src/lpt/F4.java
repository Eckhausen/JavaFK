package lpt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class F4 {
    public static void main(String[] args) {
        // List<Integer> nbrs = new ArrayList<Integer>();
        Set<Integer> nbrs = new HashSet<Integer>();
        for (int i = 0; i < 100; i += 10){
            nbrs.add(i);
            nbrs.add(i);
        }
        int counter = 0;
        for(int a : nbrs){
            System.out.println(a);
            counter++;
        }
        System.out.println(counter);
    }
}
