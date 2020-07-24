package drawing;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point(2,4,true);
		System.out.println(p1);
		
		Line l1 = new Line();
		Point p2 = new Point(1,1);
		Point p3 = new Point (2,3);
		l1.setStart(p2);
		l1.setEnd(p3);
		l1.setSelected(false);
		System.out.println(l1);
		
		Line l2 = new Line(new Point(3,3), new Point (4,4));
		l2.setSelected(false);
		System.out.println(l2);
		
		Rectangle r1 = new Rectangle(new Point(1,1), 5, 5,true);
		System.out.println(r1);
		
		Circle c1 = new Circle(new Point(2,2), 5, true);
		System.out.println(c1);
		
		Donut d1 = new Donut(new Point (1,1), 2, 3, false);
		System.out.println(d1);
		
		
		Rectangle r2 = new Rectangle (new Point(1,3), 3,5);
		System.out.println(r2);
		
		

	}
}
	
