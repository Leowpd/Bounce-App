/*
 *	===============================================================================
 *	NestedShape.java : A shape that is nested.
 *  YOUR UPI: ldun202
 *	=============================================================================== */

import java.awt.Graphics;
import java.util.*;
import java.awt.*;
import java.lang.Math;

class NestedShape extends RectangleShape {
	
	private ArrayList<Shape> innerShapes = new ArrayList<Shape>();
	
	public Shape createInnerShape(PathType pt, ShapeType st) {
		if (st == ShapeType.RECTANGLE) {
			Shape innerRectangleShape = new RectangleShape(0, 0, this.width/4, this.height/4, this.width, this.height, this.color, this.borderColor, pt);
			innerRectangleShape.setParent(this);
			innerShapes.add(innerRectangleShape);
			return innerRectangleShape;
		} else if (st == ShapeType.SQUARE) {
			int sideLength = Math.min(this.width/4, this.height/4);
			Shape innerSquareShape = new SquareShape(0, 0, sideLength, this.width, this.height, this.color, this.borderColor, pt);
			innerSquareShape.setParent(this);
			innerShapes.add(innerSquareShape);
			return innerSquareShape;
		} else {
			Shape innerNestedShape = new NestedShape(0, 0, this.width/4, this.height/4, this.width, this.height, this.color, this.borderColor, pt);
			innerNestedShape.setParent(this);
			innerShapes.add(innerNestedShape);
			return innerNestedShape;
		}
	}
	
	public NestedShape(int x, int y, int width, int height, int pannelWidth, int pannelHeight, Color fillColor, Color borderColor, PathType pt) {
		super(x, y, width, height, pannelWidth, pannelHeight, fillColor, borderColor, pt);
		Shape newInnerShape = createInnerShape(PathType.BOUNCING, ShapeType.RECTANGLE);
	}
	
	public NestedShape(int width, int height) {
		super(0, 0, width, height, Shape.DEFAULT_PANEL_WIDTH, Shape.DEFAULT_PANEL_HEIGHT, Shape.DEFAULT_COLOR, Shape.DEFAULT_BORDER_COLOR, PathType.BOUNCING);
	}
	
	public Shape getInnerShapeAt(int index) { return innerShapes.get(index); }
	public int getSize() { return innerShapes.size(); }
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, this.width, this.height);
		g.translate(this.x, this.y);
		for (Shape shape : innerShapes) {
			shape.draw(g);
			shape.drawString(g);
		}
		g.translate(-this.x, -this.y);
	}
	
	public void move() {
		super.move();
		for (Shape shape : innerShapes) {
			shape.move();
		}
	}
	
	public int indexOf(Shape s) { return innerShapes.indexOf(s); }
	
	public void addInnerShape(Shape s) {
		innerShapes.add(s);
		s.setParent(this);
	}
	public void removeInnerShape(Shape s) {
		innerShapes.remove(s);
		s.setParent(null);
	}
	public void removeInnerShapeAt(int index) {
		Shape removeThis = innerShapes.get(index);
		innerShapes.remove(index);
		removeThis.setParent(null);
	}
	public ArrayList<Shape> getAllInnerShapes() { return innerShapes; }
	
	
	

	
}
