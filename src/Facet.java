
import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] _vertex;
    private Color _color;
    private boolean view = true;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4){
        _vertex = new R3Vector[]{v1, v2, v3, v4};
        setColor(Color.RED);
    }

    public void setColor(Color color){
        _color = color;
    }

    public void scale(double kx, double ky, double kz){
        for(int i = 0; i < _vertex.length; i++)
            _vertex[i].scale(kx,ky,kz);

            //for(R3Vector v: _vertex)
            // v.scale(kx,ky,kz);
    }

    public void translate(double dx, double dy, double dz) {
        for (int i = 0; i < _vertex.length; i++)
            _vertex[i].translate(dx, dy, dz);
    }

    public void rotate(double ux, double uy, double uz) {
        for (int i = 0; i < _vertex.length; i++)
            _vertex[i].rotate(ux, uy, uz);
    }

    public boolean transp(boolean view){
        if (R3Vector.vect(R3Vector.toR3Vector(_vertex[0], _vertex[1]), R3Vector.toR3Vector(_vertex[3], _vertex[0])).getZ() < 0){
            view = false;
        }
        return view;
    }
    public void draw(Graphics2D g){
        Path2D p = new Path2D.Double();
        p.moveTo(_vertex[0].getX(), _vertex[0].getY());
        p.lineTo(_vertex[1].getX(), _vertex[1].getY());
        p.lineTo(_vertex[2].getX(), _vertex[2].getY());
        p.lineTo(_vertex[3].getX(), _vertex[3].getY());
        p.lineTo(_vertex[0].getX(), _vertex[0].getY());
        p.closePath();

        g.setColor(_color);
        if(transp(view)) g.fill(p);


    }


}
