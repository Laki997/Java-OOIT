package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Moveable {
	
	private boolean selected;
	
	private Color outline = Color.black;
	private Color fill = Color.white;
	
	
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		super();
		this.selected=selected;
		}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected=selected;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean contains (int x, int y);
	
	public abstract void DialogEdit();
	
	public abstract void AreaPainter(Graphics g);

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

}
