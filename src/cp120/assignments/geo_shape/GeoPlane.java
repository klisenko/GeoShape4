package cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The GeoPlane class defines a plane with origin and color.
 * 
 * @author Jack Straub
 * @version 1.00, 20 November 2016
 */
public class GeoPlane
    implements Runnable
{
    private final   List<GeoShape>  allShapes;
    private final   Color           color;
    private final   Panel           panel;
    
    public void run()
    {
        JFrame  frame   = new JFrame( "GeoPlane" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setContentPane( panel );
        frame.pack();
        frame.setVisible( true );
    }
    
    public GeoPlane()
    {
        this( new Color( .5f, .5f, .5f ) );
    }
    
    public GeoPlane( Color color )
    {
        this.color = color;
        allShapes = new ArrayList<>();
        panel = new Panel();
    }
    
    public void show()
    {
        new Thread( this, "GeoPlane Thread" ).start();
    }
    
    public void addShape( GeoShape shape )
    {
        allShapes.add( shape );
    }
    
    public void removeShape( GeoShape shape )
    {
        allShapes.remove( shape );
    }
    
    public void redraw()
    {
        panel.repaint();
    }
    
    private class Panel extends JPanel
    {        
        private static final long serialVersionUID = -7413434451145995808L;

        public Panel()
        {
            setPreferredSize( new Dimension( 500, 500 ) );
        }
        
        @Override
        public void paintComponent( Graphics graphics )
        {
            super.paintComponent( graphics );
            
            Graphics2D  gtx = (Graphics2D)graphics.create();
            gtx.setColor( color );
            gtx.fillRect( 0,  0,  getWidth(), getHeight() );
            for ( GeoShape shape : allShapes)
                shape.draw( gtx );
        }
    }
}
