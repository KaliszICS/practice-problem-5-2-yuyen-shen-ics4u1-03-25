public class RectPrism extends Rectangle {

    private int height;
    // private int length;



    public RectPrism(int length, int width, int height) {
        //must be the first line of your constructor
        super(length, width); //must run your superclass constructor
        this.length = length;
        // super.length = 5;
        // this.width = width;
        this.height = height;
    }

    //variables used in our methods and constructors
    //check for local -> check for "this" (instance variables) -> check the superclass for an instance variable

    public int getSuperLength() {
        return super.length;
    }

    public int getThisLength() {
        return this.length;
    }

    //area method already exists
    @Override
    public int area() {
        return this.height * this.width * this.length;
        //Yes i know this is volume
    }

}