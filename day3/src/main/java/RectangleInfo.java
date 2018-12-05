import java.util.Arrays;

public class RectangleInfo {
    long id;
    int x;
    int y;
    int width;
    int height;

    public RectangleInfo(String line) {
        String[] splitShit = line.split(" @ |,|: |x");
        this.id = Long.parseLong(splitShit[0].substring(1));
        this.x = Integer.parseInt(splitShit[1]);
        this.y = Integer.parseInt(splitShit[2]);
        this.width = Integer.parseInt(splitShit[3]);
        this.height = Integer.parseInt(splitShit[4]);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
