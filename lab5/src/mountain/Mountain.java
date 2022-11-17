package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
    private int length;
    private Point a;
    private Point b;
    private Point c;

    public Mountain(Point a, Point b, Point c){
        super();
        this.a = new Point(165, 396);
        this.b = new Point(289, 157);
        this.c = new Point(486, 433);
    }

    @Override
    public String getTitle() {
        return "Bergfraktal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        // turtle.moveTo(a.getX(), a.getY());
        // turtle.penDown();
        // turtle.forwardTo(b.getX(), b.getY());
        // turtle.forwardTo(c.getX(), c.getY());
        // turtle.forwardTo(a.getX(), a.getY());
        fractalLine(turtle, order, length, order);

        
    }

    private void fractalLine(TurtleGraphics turtle, int order, double length, double alpha){
        if(order == 0){
            turtle.moveTo(a.getX(), a.getY());
            turtle.penDown();
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
        } else {
            
        }
    }



}
