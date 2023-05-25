

public class Main {
    public static void main(String[] args){
        Cube cube = new Cube();
        cube.scale(200,200,200);
        cube.rotate(120,45,45);
        Screen screen = new Screen(cube);

    }
}
