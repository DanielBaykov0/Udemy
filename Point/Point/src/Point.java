public class Point {

    private int x;
    private int y;

    public Point () {

    }
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
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
    public double distance () {
        double xA = this.x;
        double yA = this.y;
        double xB = 0;
        double yB = 0;
        return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    }
    public double distance (int x, int y) {
        double xA = this.x;
        double yA = this.y;
        double xB = x;
        double yB = y;
        return Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
    }
    public double distance (Point another) {
        return distance(another.x, another.y);
    }
}
