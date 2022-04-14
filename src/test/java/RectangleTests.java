import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RectangleTests {

    @Test
    public void testDefaultRectangleGetA(){
        Rectangle rectangle = new Rectangle();
        Assert.assertEquals(1, rectangle.getA());
    }

    @Test(priority = 1)
    public void testDefaultRectangleCalculateCircumference(){
        Rectangle rectangle = new Rectangle();
        rectangle.setB(4);
        Assert.assertEquals(10, rectangle.calculateCircumference());
    }

    @Test(priority = 2)
    public void testDefaultRectangleCalculateArea(){
        Rectangle rectangle = new Rectangle();
        rectangle.setB(4);
        Assert.assertEquals(4, rectangle.calculateArea());
    }

    @Test(priority = 3)
    @Parameters({"a", "b"})
    public void testRectangleGetA(@Optional("3") int a, @Optional("4") int b){
        Rectangle rectangle = new Rectangle(a, b);
        Assert.assertEquals(4, rectangle.getB());
    }

    @Test(priority = 4)
    @Parameters({"a", "b"})
    public void testRectangleCalculateCircumference(@Optional("5") int a, @Optional("7") int b){
        Rectangle rectangle = new Rectangle(a, b);
        Assert.assertEquals(24, rectangle.calculateCircumference());
    }

    @Test(priority = 5)
    @Parameters({"a", "b"})
    public void testRectangleCalculateArea(@Optional("3") int a, @Optional("4") int b){
        Rectangle rectangle = new Rectangle(a, b);
        rectangle.setA(7);
        Assert.assertEquals(28, rectangle.calculateArea());
    }
}