/*
 *	===============================================================================
 *	SquareShape.java : A shape that is a square.
 *  YOUR UPI: ldun202
 *	=============================================================================== */

import java.awt.*;
class SquareShape extends RectangleShape {
	public SquareShape(int x, int y, int sideLength, int panelWidth, int panelHeight, Color fillColor, Color borderColor, PathType pathType) {
		super(x ,y ,sideLength, sideLength ,panelWidth ,panelHeight, fillColor, borderColor, pathType);
	}
}