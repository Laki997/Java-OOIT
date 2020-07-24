package drawing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel implements MouseListener{
	
	static int obj = 0;
	int mx;
	int my;
	static ArrayList<Shape> shapesArrList = new ArrayList<Shape>();
	private Point startLine = null;

	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my= e.getY();
		
		switch(obj) {
		case 1:
			Point p = new Point (mx,my,false);
			p.setOutline(DrawingFrm.outline);
			shapesArrList.add(p);
			break;
		case 2:
			if (startLine == null) {
				startLine = new Point(mx,my, false);
				
			}
			else {
				Point endLine = new Point(mx,my);
				Line line = new Line (startLine, endLine,false );
				line.setOutline(DrawingFrm.outline);
				shapesArrList.add(line);
				startLine = null;
			}
			break;
			
		case 3:
			DialogRectangle dlgRectangle = new DialogRectangle();
			dlgRectangle.getTxtXCoord().setText(String.valueOf(mx));
			dlgRectangle.getTxtXCoord().setEditable(false);
			dlgRectangle.getTxtYCoord().setText(String.valueOf(my));
			dlgRectangle.getTxtYCoord().setEditable(false);
			dlgRectangle.setVisible(true);
			if (dlgRectangle.isOk == true) {
				Rectangle r = new Rectangle(new Point(mx,my),
						Integer.parseInt(dlgRectangle.getTxtWidth().getText()),
						Integer.parseInt(dlgRectangle.getTxtHeight().getText()),
						false);
				r.setOutline(DrawingFrm.outline);
				r.setFill(DrawingFrm.area);
				if (dlgRectangle.isOutlineBool()) {
					r.setOutline(dlgRectangle.getOutline());
				}
				if (dlgRectangle.isAreaBool()) {
					r.setFill(dlgRectangle.getArea());
				}
				
				shapesArrList.add(r);
			}
			break;
			
		case 4: 
			DialogCircle dlgCircle = new DialogCircle();
			dlgCircle.getTxtXCoord().setText(String.valueOf(mx));
			dlgCircle.getTxtXCoord().setEditable(false);
			dlgCircle.getTxtYCoord().setText(String.valueOf(my));
			dlgCircle.getTxtYCoord().setEditable(false);
			dlgCircle.setVisible(true);
			if (dlgCircle.isOk == true) {
				Circle c = new Circle(new Point(mx,my),
						Integer.parseInt(dlgCircle.getTxtRadius().getText()),
						false);
				c.setOutline(DrawingFrm.outline);
				c.setFill(DrawingFrm.area);
				
				if(dlgCircle.isOutlineBool()) {
					c.setOutline(dlgCircle.getOutline());
				}
				
				if (dlgCircle.isAreaBool()) {
					c.setFill(dlgCircle.getArea());
				}
				shapesArrList.add(c);
			}
			break;
			
		case 5:
			DialogDonut dlgDonut = new DialogDonut();
			dlgDonut.getTxtXCoord().setText(String.valueOf(mx));
			dlgDonut.getTxtYCoord().setText(String.valueOf(my));
			dlgDonut.getTxtYCoord().setEditable(false);
			dlgDonut.getTxtXCoord().setEditable(false);
			dlgDonut.setVisible(true);
			if (dlgDonut.isOk == true) {
				Donut d = new Donut ( new Point(mx,my),
						Integer.parseInt(dlgDonut.getTxtRadius().getText()),
						Integer.parseInt(dlgDonut.getTxtInnerRadius().getText()),
						false);
				d.setOutline(DrawingFrm.outline);
				d.setFill(DrawingFrm.area);
				
				if (dlgDonut.isOutlineBool()) {
					d.setOutline(dlgDonut.getOutline());
				}
				
				if (dlgDonut.isAreaBool()) {
					d.setFill(dlgDonut.getArea());
				}
				shapesArrList.add(d);
			}
			break;
			
		case 6:
			boolean match = false;
			Collections.reverse(shapesArrList);
			for (Shape shape : shapesArrList) {
				shape.setSelected(false);
				if (match == false) {
					if (shape.contains(mx, my)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapesArrList);
			
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public PnlDrawing() {
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape: shapesArrList) {
			shape.AreaPainter(g);
			shape.draw(g);
		}
		repaint();
	}
	
	

}
