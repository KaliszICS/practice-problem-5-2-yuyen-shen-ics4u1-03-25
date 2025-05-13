public class Rectangle {

    //if you want to use these variables in a subclass use protected instead of private
    protected int length;
    protected int width;

    //if you have a no argument constructor (or no constructor, one is made by default)
    //automatically used in subclass

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area() {
        return this.width * this.length;
    }

}