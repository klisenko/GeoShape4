package cp120.assignments.geo_shape;

import java.awt.Point;
import java.awt.geom.Point2D;

import org.junit.Assert;
import org.junit.Test;

public class TestGeoPoint {
	private GeoPoint point;
	private float xco = 5.7f;
	private float yco = 10.2f;
	

	@Test
	public final void testGeoPoint() {
		point = new GeoPoint(xco, yco);
		Assert.assertEquals(xco, point.getXco(), 0.0f);
		Assert.assertEquals(yco, point.getYco(), 0.0f);
	}

	@Test
	public final void testGetIntPoint() {
		point = new GeoPoint(xco, yco);
		Point p = new Point(Math.round(xco), Math.round(yco));
		Assert.assertEquals(p, point.getIntPoint());
	}

	@Test
	public final void testGetPoint2D() {
		point = new GeoPoint(xco, yco);
		Point2D.Float p = new Point2D.Float(xco, yco);
		Assert.assertEquals(p, point.getPoint2D());
	}

	@Test
	public final void testDistance() {
		point = new GeoPoint(xco, yco);
		float otherX = 12.35f;
		float otherY = 8.75f;
		GeoPoint otherPoint = new GeoPoint(otherX, otherY);
		float distanceActual = point.distance( otherPoint );
		float distanceExpected = (float)(Math.sqrt(Math.pow(xco - otherX, 2) + Math.pow(yco - otherY, 2)));
		Assert.assertEquals(distanceExpected, distanceActual, 0.0f);
	}
	

	@Test
	public final void testToString() {
		point = new GeoPoint(xco, yco);
		String expected = point.toString();
		String actual = "(" + xco + "," + yco + ")";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public final void testGetXco() {
		point = new GeoPoint(xco, yco);
		Assert.assertEquals(xco, point.getXco(), 0.0f);
	}

	@Test
	public final void testSetXco() {
		point = new GeoPoint(0f, 0f);
		point.setXco(xco);
		Assert.assertEquals(xco, point.getXco(), 0.0f);
	}

	@Test
	public final void testGetYco() {
		point = new GeoPoint(xco, yco);
		Assert.assertEquals(yco, point.getYco(), 0.0f);
	}

	@Test
	public final void testSetYco() {
		point = new GeoPoint(0f, 0f);
		point.setYco(yco);
		Assert.assertEquals(yco, point.getYco(), 0.0f);
	}

}
