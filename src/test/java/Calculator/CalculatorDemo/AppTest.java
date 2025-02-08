package Calculator.CalculatorDemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Calculator.CalculatorDemo.App;
//import junit.framework.Assert;
//import junit.framework.Test;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 	
    extends TestCase
{
	private App calc;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

   
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }

    @Before
    public void setUp() {
    		 calc = new App();
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
	@Test
    public void testAdd() {
    	int a = 10;
    	int b = 5;
    	int expected = 15;
    	int actual = calc.add(a, b);
    	Assert.assertEquals(expected, actual);
    			
    }
    
	@Test
    public void testSub() {
    	int a = 10;
    	int b= 5;
    	int expected = 5;
    	int actual = calc.sub(a, b);
    	Assert.assertEquals(expected, actual);
    }
    

   	@Test
    public void testMul() {
       	int a = 10;
       	int b= 5;
       	int expected = 50;
       	int actual = calc.mul(a, b);
       	Assert.assertEquals(expected, actual);
   }

   	@Test
    public void testDiv() {
       	int a = 10;
       	int b= 5;
       	double expected = 2;
       	double actual = calc.div(a, b);
       	Assert.assertEquals(expected, actual, 0);
    }
    
}