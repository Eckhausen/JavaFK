package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
    private int length;
    private Point p1;
    private Point p2;
    private Point p3;

    public Mountain(int length, Point p1, Point p2, Point p3){
        super();
        this.length = length;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public String getTitle() {
        return "Bergfraktal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        fractalLine(turtle, order, length);

        
    }

    private void fractalLine(TurtleGraphics turtle, int order, int length){
        if(order == 0){
            turtle.moveTo(p1.getX(), p1.getY());
            turtle.forwardTo(p2.getX(), p2.getY());
            turtle.forwardTo(p3.getX(), p3.getY());
            turtle.forwardTo(p1.getX(), p1.getY());
        } else {
            turtle.moveTo(p1.getX(), p1.getY());
            turtle.forwardTo(p2.getX(), p2.getY());
            turtle.forwardTo(p3.getX(), p3.getY());
            turtle.forwardTo(p1.getX(), p1.getY());
            
            fractalLine(turtle, order-1, length);
            fractalLine(turtle, order-1, length);
            fractalLine(turtle, order-1, length);
            order--;
        }
    }



}
