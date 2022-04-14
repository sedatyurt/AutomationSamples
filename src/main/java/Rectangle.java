public class Rectangle {

    private int a;
    private int b;

    public int getA() {
        System.out.println("GetA method called. A is " + a);
        return a;
    }

    public void setA(int a) {
        System.out.println("SetA method called. A set " + a);
        this.a = a;
    }

    public int getB() {
        System.out.println("GetB method called. B is " + b);
        return b;
    }

    public void setB(int b) {
        System.out.println("SetB method called. B set " + b);
        this.b = b;
    }

    public Rectangle(){
        this.a = 1;
        this.b = 1;
        System.out.println("Default constructor called! A set " + this.a + ", B set " + this.b + ".");
    }

    public Rectangle(int a, int b){
        this.a = a;
        this.b = b;
        System.out.println("Constructor called! A set " + this.a + ", B set " + this.b + ".");
    }

    public int calculateArea(){
        System.out.println("CalculateArea method called. Area is " + a * b + ".");
        return a * b;
    }

    public int calculateCircumference(){
        System.out.println("CalculateCircumference method called. Circumference is " + (2 * ( a + b )) + ".");
        return 2 * ( a + b);
    }
}