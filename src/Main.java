public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(200, 200);
        grid.createCircle(100, 100, 80, true);
        grid.render();
    }
}
