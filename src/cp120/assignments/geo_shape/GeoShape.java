/**
 * 
 */
package cp120.assignments.geo_shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * The GeoShape abstract class defines a shape with origin and color.
 * 
 * @author Jack R. Lisenko
 * @version 1.00, 20 November 2016
 */
public abstract class GeoShape {
	
	/**
	 * The default origin point.
	 */
	public static final GeoPoint DEFAULT_ORIGIN  = new GeoPoint( 0f, 0f );
	
	/**
	 * The default color is blue.
	 */
	public static final Color DEFAULT_COLOR = Color.BLUE;
	
	/**
	 * The default edge color is blue.
	 */
	public static final Color DEFAULT_EDGE_COLOR = Color.BLUE;
	
	/**
	 * The default edge width is 1.
	 */
	public static final float DEFAULT_EDGE_WIDTH = 1;	
	
	private GeoPoint origin = DEFAULT_ORIGIN;
	private Color color = DEFAULT_COLOR;
	private float edgeWidth	= DEFAULT_EDGE_WIDTH;
	private Color edgeColor	= DEFAULT_EDGE_COLOR;
	
	/**
	 * Constructor for GeoShape.
	 * 
	 * @param origin the origin of the shape.
	 * @param color the color of the shape.
	 */
	public GeoShape(GeoPoint origin, Color color) {
		super();
		this.origin = origin;
		this.color = color;
	}

	/**
	 * Abstract method to draw the shape.
	 * @param gtx the graphics context.
	 */
	public abstract void draw( Graphics2D gtx );

	/**
	 * Method to set the color and edge width of the shape and
	 * then fill or draw it..
	 * 
	 * @param shape the shape to draw.
	 * @param gtx the graphics context.
	 */
	public void draw(java.awt.Shape shape, Graphics2D gtx) {
		if(color != null) {
			gtx.setColor(color);
			gtx.fill(shape);
		}
		if(edgeColor != null && edgeWidth > 0) {
			BasicStroke stroke = new BasicStroke(edgeWidth);
			gtx.setColor(edgeColor);
			gtx.setStroke(stroke);
			gtx.draw(shape);
		}		
	}	
	
	/**
	 * Returns a GeoPoint of the origin of the shape.
	 * 
	 * @return origin the origin of the shape 
	 */	
	public GeoPoint getOrigin() {
		return origin;
	}
	
	/**
	 * Returns a Point that is the origin.
	 * 
	 * @return point the origin of the shape as integers
	 */
	public Point getIntOrigin() {
		return origin.getIntPoint();		
	}

	/**
	 * Set the origin of the shape.
	 * 
	 * @param origin the origin to set
	 */
	public void setOrigin(GeoPoint origin) {
		this.origin = origin;
	}

	/**
	 * Returns the color of the shape.
	 * 
	 * @return the color of the shape.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the shape.
	 * 
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}	

	/**
	 * Returns the edge width of the shape.
	 * @return edgeWidth the edge width of the shape
	 */
	public float getEdgeWidth() {
		return edgeWidth;
	}

	/**
	 * Sets the edge width of the shape.
	 * @param edgeWidth the edgeWidth to set
	 */
	public void setEdgeWidth(float edgeWidth) {
		this.edgeWidth = edgeWidth;
	}

	/**
	 * Returns the edge color of the shape.
	 * @return edgeColor the edge color of the shape
	 */
	public Color getEdgeColor() {
		return edgeColor;
	}

	/**
	 * Sets the edge color of the shape.
	 * @param edgeColor the edgeColor to set
	 */
	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}
	
	/**
	 * Sets the edge color and edge width of the shape.
	 * @param width the edgeWidth to set
	 * @param color the edgeColor to set
	 */
	public void setEdge(Color color, float width) {
		this.setEdgeColor(color);
		this.setEdgeWidth(width);
	}
	
	/**
	 * Returns a string representation of the shape.
	 *   
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		String hexColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
		String hexEdgeColor = "#"+Integer.toHexString(edgeColor.getRGB()).substring(2);
		String output = String.format("origin=%s,color=%s,edgeColor=%s,edgeWidth=%s", origin.toString(),hexColor,hexEdgeColor,edgeWidth);
		return output;
	}
}
