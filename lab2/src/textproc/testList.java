package textproc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class testList {
    
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(rand.nextInt(20));    
        }
        System.out.println(list);
        list.sort((e1, e2) -> e2 -e1);
        System.out.println(list);
    }
}
