import org.junit.Assert;
import org.junit.Test;

public class JUnitTest {
    
    /** 
     * @throws Exception
     */
    @Test
    public void testCalc() throws Exception{
        Calculator calculator = new Calculator();
        calculator.setNum(0);
        Assert.assertEquals(5.0, calculator.plus(5), 0.0001);
        Assert.assertEquals(0.0, calculator.minus(5), 0.0001);
        Assert.assertEquals(5.0, calculator.plus(5), 0.0001);
        Assert.assertEquals(25.0, calculator.multi(5), 0.0001);
        Assert.assertEquals(5.0, calculator.div(5), 0.0001);
        calculator.setNum(6);
        Assert.assertEquals(12.0, calculator.plus(6), 0.0001);
        Assert.assertEquals(6.0, calculator.minus(6), 0.0001);
        Assert.assertEquals(18.0, calculator.multi(3), 0.0001);
        Assert.assertEquals(9.0, calculator.div(2), 0.0001);
    }
}
