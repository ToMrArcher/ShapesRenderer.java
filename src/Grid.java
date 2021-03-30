import java.awt.*;

public class Grid {
    private int length;
    private int width;

    private Cell[][] grid;

    public Grid (int length, int width){
        this.length = length;
        this.width = width;
        this.grid = new Cell[width][length];
        setupGrid();
    }

    private void setupGrid(){
        for(int y = 0; y < this.width; y++){
            for(int x = 0; x < this.length; x++){
                grid[y][x] = new Cell(false);
            }
        }
    }

    public void setFilled(int x, int y, boolean value){
        grid[y][x].setFilled(value);
    }

    public void render(){
        for(int y = 0; y < this.width; y++){
            for(int x = 0; x < this.length; x++){
                if(grid[y][x].isFilled()){
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }

    public void createRectangle(int x, int y, int length, int width, boolean filled){

        if(y + width > this.width || x + length > this.length || y - width < 0 || x - length < 0){
            System.out.println("Rectangle out of bounds :(");
        }else{

            if(filled) {
                for(int drawY = y; drawY < width + y; drawY++){
                    for(int drawX = x; drawX < length + x; drawX++){
                        grid[drawY][drawX].setFilled(true);
                    }
                }
            }

            if(!filled){
                for(int drawY = y; drawY < width + y; drawY++){
                    for(int drawX = x; drawX < length + x; drawX++){
                        if(drawX == x || drawX == x + length - 1 || drawY == y || drawY == y + width - 1){
                            grid[drawY][drawX].setFilled(true);
                        }
                    }
                }
            }
        }
    }


    public void createCircle(int x, int y, int radius, boolean filled){

        if(y + radius > this.width || x + radius > this.length || x - radius < 0 || y - radius < 0){
            System.out.println("Rectangle out of bounds :(");
        }

        if(filled){
            for(int r = radius; r > 0; r--){
                for(double d = 0; d < 360; d += 0.01){
                    int drawY = (int) Math.round(y + r * Math.cos(d));
                    int drawX = (int) Math.round(x + r * Math.sin(d));
                    grid[drawY][drawX].setFilled(true);
                }
            }
            grid[y][x].setFilled(true);
        }
        else{
            for(double d = 0; d < 360; d += 0.01){
                int drawY = (int) Math.round(y + radius * Math.cos(d));
                int drawX = (int) Math.round(x + radius * Math.sin(d));
                grid[drawY][drawX].setFilled(true);
            }
        }
    }


}
