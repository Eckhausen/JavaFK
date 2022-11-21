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
    
    public Mountain(int length, Point p1, Point p2, Point p3, double dev){
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

            Point AB = new Point(setNewX(a, b), setNewY(a, b, dev));
            Point BC = new Point(setNewX(b, c), setNewY(b, c, dev));
            Point AC = new Point(setNewX(a, c), setNewY(a, c, dev));

            sides.put(new Side(a, b), AB);
            sides.put(new Side(b, c), BC);
            sides.put(new Side(a, c), AC);

            

            

            dev = dev/2;
            order--;
            fractalLine(turtle, order, a, AB, AC, dev); 
            fractalLine(turtle, order, AB, b, BC, dev);
            fractalLine(turtle, order, AC, BC, c, dev);
            fractalLine(turtle, order, AB, BC, AC, dev); //Mitten
        }

    }
    
    private int setNewX(Point p1, Point p2) {
        return ((p2.getX() - p1.getX())/2) + p1.getX();
    }

    private int setNewY(Point p1, Point p2, double dev) {
       double randValue = RandomUtilities.randFunc(dev);
        return (int) randValue + ((p2.getY() - p1.getY())/2) + p1.getY();
    }

    public class Side {
        private Point p1, p2;
        private Side(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }
        
        @Override
        public boolean equals(Object obj){
            return false;
    
        }
    
        @Override
        public int hashCode(){
            return p1.hashCode() + p2.hashCode();
    
        }
    
    }
    


}
