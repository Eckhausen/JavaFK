package mountain;
import java.util.HashMap;
import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
    private Point a;
    private Point b;
    private Point c;
    private double dev; 
    HashMap<Side, Point> sides = new HashMap<>();
    
    public Mountain(Point p1, Point p2, Point p3, double dev){
        super();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.dev = dev;
    }

    @Override
    public String getTitle() {
        return "Bergfraktal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        fractalLine(turtle, order, a, b, c, dev);
    }

    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev){
        if(order == 0){
            turtle.moveTo(a.getX(), a.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());            
            
        } else {
            //long t0 = System.nanoTime();
            // Point AB = new Point(setNewX(a, b), setNewY(a, b, dev));
            // Point BC = new Point(setNewX(b, c), setNewY(b, c, dev));
            // Point AC = new Point(setNewX(a, c), setNewY(a, c, dev));

            Point AB =  mid(a, b, dev);
            Point BC =  mid(b, c, dev);
            Point AC =  mid(a, c, dev);
            
            
            dev = dev/2;
            order--;
            fractalLine(turtle, order, a, AB, AC, dev); 
            fractalLine(turtle, order, AB, b, BC, dev);
            fractalLine(turtle, order, AC, BC, c, dev);
            fractalLine(turtle, order, AB, BC, AC, dev); //Mitten
            //long t1 = System.nanoTime();
            //System.out.println((t1-t0) / 1000000.0  + " ms");
        }

    }
    
    private int setNewX(Point p1, Point p2) {
        return ((p2.getX() - p1.getX())/2) + p1.getX();
    }

    private int setNewY(Point p1, Point p2, double dev) {
       double randValue = RandomUtilities.randFunc(dev);
        return (int) randValue + ((p2.getY() - p1.getY())/2) + p1.getY();
    }

    //Skapa mid (mittpunkten av en sida)
    private Point mid(Point point1, Point point2, double dev){
        int x = setNewX(point1, point2);
        int y = setNewY(point1, point2, dev);
        Side temp = new Side(point1, point2);
        Point mid = new Point(x, y);
        //Hashmap har contains metod.
        for(Side s: sides.keySet()){
            if(s.equals(temp)){
                mid = sides.get(s);
                sides.remove(s);
                return mid;
            }
        }
        sides.put(temp, mid);
        return mid;
    }


    public class Side {
        private Point p1, p2;
        private Side(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }
        
        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Side)){
                return false;
            }
            Side comp = (Side) obj;
            if(comp.p1.equals(this.p1) && comp.p2.equals(this.p2)) return true;
            if(comp.p1.equals(this.p2) && comp.p2.equals(this.p1)) return true;

            return false;
        }
    
        @Override
        public int hashCode(){
            return p1.hashCode() + p2.hashCode();
    
        }
    
    }
    
}
