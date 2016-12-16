package app;

import java.awt.Color;

import cp120.assignments.geo_shape.GeoLine;
import cp120.assignments.geo_shape.GeoPoint;
import cp120.assignments.geo_shape.GeoShape;

import static app.DriverUtils.*;

public class LineChecker
{
    public static void main( String[] args )
    {
        LineChecker checker = new LineChecker();
        checker.lineCheck3();
    }
    
    public boolean quickCheck()
    {
        boolean result  = true;
        
        result &= lineCheck1();
        result &= lineCheck2();
        result &= lineCheck3();
        
        return result;
    }

    private boolean lineCheck1()
    {
        float       xco1    = 4.4f;
        float       yco1    = 5.5f;
        GeoPoint    point1  = new GeoPoint( xco1, yco1 );
        Color       color1  = Color.RED;
        float       xco2    = 6.6f;
        float       yco2    = 7.7f;
        GeoPoint    point2  = new GeoPoint( xco2, yco2 );
        Color       color2  = Color.BLUE;
        
        GeoLine     line    = new GeoLine( point1, color1, point2 );
        
        GeoPoint    pTemp1  = line.getStart();
        GeoPoint    pTemp2  = line.getEnd();
        Color       cTemp   = line.getColor();
        
        boolean     result  = true;
        result &= assertEqual( point1, pTemp1 );
        result &= assertEqual( point2, pTemp2 );
        result &= assertEqual( color1, cTemp );
        
        line.setStart( point2 );
        line.setEnd( point1 );
        line.setColor( color2 );
        
        pTemp1 = line.getStart();
        pTemp2 = line.getEnd();
        cTemp = line.getColor();
        
        result &= assertEqual( point2, pTemp1 );
        result &= assertEqual( point1, pTemp2 );
        result &= assertEqual( color2, cTemp );
        
        return result;
    }

    private boolean lineCheck2()
    {
        float       xco1    = 4.4f;
        float       yco1    = 5.5f;
        GeoPoint    point1  = new GeoPoint( xco1, yco1 );
        Color       color1  = GeoShape.DEFAULT_COLOR;
        float       xco2    = 4.4f;
        float       yco2    = 5.5f;
        GeoPoint    point2  = new GeoPoint( xco2, yco2 );
        Color       color2  = Color.BLUE;
        
        GeoLine     line    = new GeoLine( point1, point2 );
        
        GeoPoint    pTemp1  = line.getStart();
        GeoPoint    pTemp2  = line.getEnd();
        Color       cTemp   = line.getColor();
        
        boolean     result  = true;
        result &= assertEqual( point1, pTemp1 );
        result &= assertEqual( point2, pTemp2 );
        result &= assertEqual( color1, cTemp );
        
        line.setStart( point2 );
        line.setEnd( point1 );
        line.setColor( color2 );
        
        pTemp1 = line.getStart();
        pTemp2 = line.getEnd();
        cTemp = line.getColor();
        
        result &= assertEqual( point2, pTemp1 );
        result &= assertEqual( point1, pTemp2 );
        result &= assertEqual( color2, cTemp );
        
        return result;
    }
    
    private boolean lineCheck3()
    {
        boolean rcode   = true;
        SlopeTester[]   allTests    =
        {
            new SlopeTester( -3, 3, 5, -5 ),
            new SlopeTester( -3, -3, 5, 5 ),
            new SlopeTester( 3, 3, 5, 7 ),
            new SlopeTester( 3, 3, 7, 5 ),
            new SlopeTester( 3, 3, 3, 3 ),
            new SlopeTester( -3, -3, 10, -3 ),
            new SlopeTester( 1, 100, 1, -100 ),
            new SlopeTester( 1, -100, 1, 100 ),
        };
        
        for ( SlopeTester tester : allTests )
        {
            rcode &= tester.test();
            System.out.println( tester );
        }
        
        return rcode;
    }
    
    private class SlopeTester
    {
        private static final double EPSILON    = .0001;
        
        private final GeoLine   line;
        private final double    expSlope;
        private final double    actSlope;
        
        public SlopeTester( float x1, float y1, float x2, float y2 )
        {
            GeoPoint    start   = new GeoPoint( x1, y1 );
            GeoPoint    end     = new GeoPoint( x2, y2 );
            line = new GeoLine( start, end );
            expSlope = (y2 - y1) / (x2 - x1);
            actSlope = line.slope();
        }
        
        public String toString()
        {
            String      fmt     = "%s->%s exp=%4.2f act=%4.2f";
            GeoPoint    start   = line.getStart();
            GeoPoint    end     = line.getEnd();
            String      result  = 
                String.format( fmt,  start, end, expSlope, actSlope );
            
            return result;
        }
        
        public boolean test()
        {
            boolean rcode   = true;
            
            if ( testNaN() || testNegInfinity() || testPosInfinity() )
                rcode = true;
            else
                rcode   = assertEqual( expSlope, actSlope, EPSILON );
            
            return rcode;
        }
        
        private boolean testNaN()
        {
            boolean rcode   =
                Double.isNaN( expSlope ) && Double.isNaN( actSlope );
            return rcode;
        }
        
        private boolean testNegInfinity()
        {
            boolean result  = false;
            
            if ( Double.isInfinite( expSlope ) &&
                 Double.isInfinite( actSlope ) &&
                 expSlope < 0  && actSlope < 0 
               )
                result = true;
            
            return result;
        }
        
        private boolean testPosInfinity()
        {
            boolean result  = false;
            
            if ( Double.isInfinite( expSlope ) &&
                 Double.isInfinite( actSlope ) &&
                 expSlope > 0  && actSlope > 0 
               )
                result = true;
            
            return result;
        }
    }
}
