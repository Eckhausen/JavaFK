package mountain;

import java.util.HashMap;

public class Side {
    HashMap<Side, Point> sides = new HashMap<>();
    private Side(){
        
    }
    
    @Override
    public boolean equals(Object obj){
        return false;

    }

    @Override
    public int hashCode(){
        return 0;

    }

}
