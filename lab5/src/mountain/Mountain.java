package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
    // private int length;
    private Point a;
    private Point b;
    private Point c;

    public Mountain(int length, Point p1, Point p2, Point p3){
        super();
        // this.length = length;
        this.a = p1;
        this.b = p2;
        this.c = p3;
    }

    @Override
    public String getTitle() {
        return "Bergfraktal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        fractalLine(turtle, order, a, b, c);

        
    }

    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c){
        if(order == 0){
            turtle.moveTo(a.getX(), a.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
        } else {

            Point AB = new Point(setNewX(a, b), setNewY(a, b));
            Point BC = new Point(setNewX(b, c), setNewY(b, c));
            Point AC = new Point(setNewX(a, c), setNewY(a, c));

            order--;
            fractalLine(turtle, order, a, AB, AC); 
            fractalLine(turtle, order, AB, b, BC);
            fractalLine(turtle, order, AC, BC, c);
            fractalLine(turtle, order, AB, BC, AC); //Mitten
        }

    }
    
    private int setNewX(Point p1, Point p2) {
        return ((p2.getX() - p1.getX())/2) + p1.getX();
    }

    private int setNewY(Point p1, Point p2) {
        return ((p2.getY() - p1.getY())/2) + p1.getY();
    }

    


}
