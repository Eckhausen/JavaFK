package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
    private int length;

    public Mountain(int length){
        super();
        this.length = length;
    }

    @Override
    public String getTitle() {
        return "Bergfractal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        // turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0,
        // turtle.getHeight() / 2.0 - Math.sqrt(3.0) * length / 4.0); // Placera turtle.
        Point a = new Point((int) (turtle.getWidth() / 2.0 - length / 2.0),
        (int) (turtle.getHeight() / 2.0 - Math.sqrt(3.0) * length / 4.0));
        
    }

    private void fractalLine(TurtleGraphics turtle, int order, double length, double alpha){
        if(order == 0){
            
        }
    }



}
