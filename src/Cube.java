
import java.awt.*;
public class Cube {
    private Facet[] _facets;
    public Cube(){
        _facets = new Facet[6];

        //дальняя грань, в плоскости XY
        _facets[0] = new Facet(new R3Vector(0, 0, 0),
                               new R3Vector(0,1,0),
                               new R3Vector(1,1,0),
                               new R3Vector(1,0,0));
        _facets[0].setColor(Color.RED);

        //передняя грань
        _facets[1] = new Facet(new R3Vector(0, 0, 1),
                               new R3Vector(1, 0, 1),
                               new R3Vector(1, 1, 1),
                               new R3Vector(0, 1, 1));
        _facets[1].setColor(Color.ORANGE);

        //верхняя грань
        _facets[2] = new Facet(new R3Vector(0, 1, 0),
                               new R3Vector(0, 1, 1),
                               new R3Vector(1, 1, 1),
                               new R3Vector(1, 1, 0));
        _facets[2].setColor(Color.YELLOW);

        //нижняя грань, в плоскости XZ
        _facets[3] = new Facet(new R3Vector(0, 0, 0),
                               new R3Vector(1, 0, 0),
                               new R3Vector(1, 0, 1),
                               new R3Vector(0, 0, 1));
        _facets[3].setColor(Color.GREEN);

        //левая боковая грань, в плоскости YZ
        _facets[4] = new Facet(new R3Vector(0, 1, 0),
                               new R3Vector(0, 0, 0),
                               new R3Vector(0, 0, 1),
                               new R3Vector(0, 1, 1));
        _facets[4].setColor(Color.BLUE);

        //правая боковая грань
        _facets[5] = new Facet(new R3Vector(1, 1, 0),
                               new R3Vector(1, 1, 1),
                               new R3Vector(1, 0, 1),
                               new R3Vector(1, 0, 0));
        _facets[5].setColor(Color.PINK);

        this.translate(-0.5, -0.5, -0.5);
    }

    public void scale(double kx, double ky, double kz){
        for(int i = 0; i < _facets.length; i++)
            _facets[i].scale(kx,ky,kz);

        //for(R3Vector v: _vertex)
        // v.scale(kx,ky,kz);
    }

    public void translate(double dx, double dy, double dz) {
        for (int i = 0; i < _facets.length; i++)
            _facets[i].translate(dx, dy, dz);
    }

    public void rotate(double ux, double uy, double uz) {
        for (int i = 0; i < _facets.length; i++)
            _facets[i].rotate(ux, uy, uz);
    }

    public void draw(Graphics2D g){
        for(int i = 0; i < _facets.length; i++)
            _facets[i].draw(g);
    }


}
