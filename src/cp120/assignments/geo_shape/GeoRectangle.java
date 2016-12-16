/**
 * 
 */
package cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * The GeoRectangle class defines a Rectangle.
 * 
 * 
 * @author Jack Lisenko
 * @version 1.00, 20 November 2016
 */
public class GeoRectangle extends GeoShape {
	
	private double width = 0;
	private double height = 0;

	/**
	 * Constructor for GeoRectangle.
	 * 
	 * @param origin the origin of the rectangle - upper left corner
	 * @param color the color of the rectangle 
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public GeoRectangle(GeoPoint origin, Color color, double width, double height) {
		super(origin, color);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Constructor for GeoRectangle.
	 * 
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public GeoRectangle(double width, double height) {
		this( DEFAULT_ORIGIN, DEFAULT_COLOR, width, height );
	}
	
	/**
	 * Constructor for GeoRectangle.
	 * 
	 * @param origin the origin of the rectangle - upper left corner
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public GeoRectangle(GeoPoint origin, double width, double height) {
		this( origin, DEFAULT_COLOR, width, height );
	}	

	/**
	 * Method to draw the Rectangle.
	 * 
	 * @param gtx
	 * @see cp120.assignments.assignment006.GeoShape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D gtx) {
		String arg1 = this.toString();
		String output = String.format("Drawing rectangle: %s", arg1);
		System.out.println(output);
		float x = this.getOrigin().getXco();
		float y = this.getOrigin().getYco();
		Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
		super.draw(rectangle, gtx);		
	}

	/**
	 * Return the area of the rectangle.
	 * 
	 * @return the area of the rectangle
	 */
	public double area() {
		return height * width;
	}
	
	/**
	 * Return the perimeter of the rectangle.
	 * 
	 * @return the perimeter of the rectangle
	 */
	public double perimeter() {
		return 2*height + 2 * width;
	}	
	
	/**
	 * Return the width of the rectangle.
	 * 
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Set the width of he rectangle.
	 * 
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Return the height of the rectangle.
	 * 
	 * @return the height of the rectangle
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Set the height of the rectangle.
	 * 
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * The toString method for the rectangle.
	 * @return String of the rectangle.
	 * @see cp120.assignments.assignment006.GeoShape#toString()
	 */
	@Override
	public String toString() {
		String arg1 = super.toString();
		return String.format("%s,width=%s,height=%s", arg1, width, height);
	}
}
