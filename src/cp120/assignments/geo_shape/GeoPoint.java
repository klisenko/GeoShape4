/**
 * 
 */
package cp120.assignments.geo_shape;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * The GeoPoint class defines a point
 * .
 * @author Jack Lisenko
 * @version 1.00, 20 November 2016
 */
public class GeoPoint {
	private float xco = 0;
	private float yco = 0;	
	
	/**
	 * Constructor for GeoPoint.
	 * 
	 * @param xco the x location of the point
	 * @param yco the y location of the point
	 */
	public GeoPoint(float xco, float yco) {
		super();
		this.xco = xco;
		this.yco = yco;
	}

	/**
	 * Return the coordinates as a point rounded to nearest integer.
	 *  
	 * @return the coordinates as a point
	 * rounded to nearest integer 
	 */
	public Point getIntPoint() {
		return new Point(Math.round(xco), Math.round(yco));
	}
	
	/**
	 * Return the coordinates as a point of type float.
	 * 
	 * @return the coordinates as a point
	 * with type float
	 */
	public Point2D getPoint2D() {
		Point2D.Float point = new Point2D.Float( xco, yco );
	    return point;
	}
	
	/**
	 * Return the distance between this point and parameter point.
	 * 
	 * @param other
	 * @return distance the distance between this GeoPoint another GeoPoint  
	 */
	public float distance( GeoPoint other ) {
		double xcoOther = other.getXco();
		double ycoOther = other.getYco();
		double distance = Math.sqrt(Math.pow(xco - xcoOther, 2) + Math.pow(yco - ycoOther, 2));		
		return (float)distance;
	}	
	
	/**
	 * The toString method for a point.
	 * 
	 * @return String of the x and y values of the point
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return "(" + xco + "," + yco + ")";
	}

	/**
	 * Return the x value of the point.
	 * 
	 * @return the xco
	 */
	public float getXco() {
		return xco;
	}
	
	/**
	 * Set the x value of the point.
	 * 
	 * @param xco the xco to set
	 */
	public void setXco(float xco) {
		this.xco = xco;
	}
	
	/**
	 * Return the y value of the point.
	 * 
	 * @return the yco
	 */
	public float getYco() {
		return yco;
	}
	
	/**
	 * Set the y value of the point.
	 * 
	 * @param yco the yco to set
	 */
	public void setYco(float yco) {
		this.yco = yco;
	}
}
