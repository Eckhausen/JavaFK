package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		
		Point p1 = new Point(165, 396);
		Point p2 = new Point(289, 157);
		Point p3 = new Point(486, 433);

		fractals[0] = new Mountain(300, p1, p2, p3, 20);
		fractals[1] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
