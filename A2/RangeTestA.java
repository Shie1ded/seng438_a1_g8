// code written by Jessica Hoang
package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRangePositiveNegative;
    private Range exampleRangePositive;
    private Range exampleRangeNegative;
    private double epsilon;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
        // set up a Range that includes a negative value and a positive value
    	exampleRangePositiveNegative = new Range(-1, 1);
        // set up a Range that only includes positive values
    	exampleRangePositive = new Range(5, 20);
        // set up a Range that only includes negative values 
    	exampleRangeNegative = new Range(-20, -5);
    	epsilon = 0.000000001d;
    }
    
    // TESTING METHOD: CONSTRAIN
    // Returns the value within the range that is closest to the specified value
    
    // test to check whether a positive input outside the range returns the closest boundary value   
    @Test
    public void constrainPositiveInputNotInRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(5);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }
    
    // test to check whether a negative input outside the range returns the closest boundary value   
    @Test
    public void constrainNegativeInputNotInRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-5);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }
    
    // test to check whether a positive input inside the range returns the input value since it is within the range   
    @Test
    public void constrainPositiveInputInRange() {
    	double actualSpecifiedValue = exampleRangePositive.constrain(10);
        assertEquals("The value within the range that is closest to the specified value should be 10",
        10.0, actualSpecifiedValue, epsilon);
    }

    // test to check whether a negative input inside the range returns the input value since it is within the range
    @Test
    public void constrainNegativeInputInRange() {
    	double actualSpecifiedValue = exampleRangeNegative.constrain(-10);
        assertEquals("The value within the range that is closest to the specified value should be -10.0",
        -10.0, actualSpecifiedValue, epsilon);
    }
    
    // test to check whether an input way above the range returns the closest boundary value   
    @Test
    public void constrainWayAboveRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(10000);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }

    // test to check whether an input way below the range returns the closest boundary value   
    @Test
    public void constrainWayBelowRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-10000);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }

    // test to check whether an input very close to the lower boundary but still within the range returns the correct value   
    @Test
    public void constrainOneAboveLowerRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-0.99);
        assertEquals("The value within the range that is closest to the specified value should be -0.99",
        -0.99, actualSpecifiedValue, epsilon);
    }
    
    // test to check whether an input very close to the lower boundary outside the range returns the correct value   
    @Test
    public void constrainOneBelowLowerRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-1.01);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }
    
    // test to check whether an input equal to the lower range will return the correct value   
    @Test
    public void constrainEqualToLowerRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-1);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }
 
    // test to check whether an input very close to the upper range and outside the range will return the correct value
    @Test
    public void constrainOneAboveUpperRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(1.01);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }

    // test to check whether an input very close to the upper range and inside the range will return the correct value
    @Test
    public void constrainOneBelowUpperRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(0.99);
        assertEquals("The value within the range that is closest to the specified value should be 0.99",
        0.99, actualSpecifiedValue, epsilon);
    }
   
    // test to check whether an input equal to the upper range will return the correct value
    @Test
    public void constrainEqualToUpperRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(1);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }

    // TESTING METHOD: INTERSECT
    // Returns true if the range intersects (overlaps) with the specified range, and false otherwise.
    
    // test to check if a positive specified range that is fully within the range returns the correct output.
    @Test
    public void intersectPositiveFullyInRange() {
    	boolean actual = exampleRangePositive.intersects(7, 10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a positive specified range that is not within the range returns the correct output.
    @Test
    public void intersectPositiveNotInRange() {
    	boolean actual = exampleRangePositive.intersects(1, 3);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    // test to check if a negative specified range that is fully within the range returns the correct output.
    @Test
    public void intersectNegativeFullyInRange() {
    	boolean actual = exampleRangeNegative.intersects(-10, -7);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a negative specified range that is not within the range returns the correct output.
    @Test
    public void intersectNegativeNotInRange() {
    	boolean actual = exampleRangeNegative.intersects(-3, -1);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    // test to check if a positive specified range with only the lower part of the specified range overlapping with the range returns the correct output.
    @Test
    public void intersectPositiveLowerRangeBeyondUpperInRange() {
    	boolean actual = exampleRangePositive.intersects(3, 10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a positive specified range with only the upper part of the specified range overlapping with the range returns the correct output.
    @Test
    public void intersectPositiveUpperRangeBeyondLowerInRange() {
    	boolean actual = exampleRangePositive.intersects(10, 25);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a positive specified range that has a lower and upper boundary further than the range returns the correct output.
    @Test
    public void intersectPositiveSpecifiedRangeBeyond() {
    	boolean actual = exampleRangePositive.intersects(1, 25);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a negative specified range with only the lower part of the specified range overlapping with the range returns the correct output.
    @Test
    public void intersectNegativeLowerRangeBeyondUpperInRange() {
    	boolean actual = exampleRangeNegative.intersects(-25, -10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a negative specified range with only the upper part of the specified range overlapping with the range returns the correct output.
    @Test
    public void intersectNegativeUpperRangeBeyondLowerInRange() {
    	boolean actual = exampleRangeNegative.intersects(-10, -1);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a negative specified range that has a lower and upper boundary further than the range returns the correct output.
    @Test
    public void intersectNegativeSpecifiedRangeBeyond() {
    	boolean actual = exampleRangeNegative.intersects(-25, -1);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if an illegal positive range where the lower bound is greater than the upper bound returns the correct output.
    @Test
    public void intersectPositiveLowerBoundGreaterThanUpperBound() {
    	boolean actual = exampleRangePositive.intersects(10, 5);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range because the specified range is illegal",
        false, actual);
    }
    
    // test to check if an illegal negative range where the lower bound is greater than the upper bound returns the correct output.
    @Test
    public void intersectNegativeLowerBoundGreaterThanUpperBound() {
    	boolean actual = exampleRangeNegative.intersects(-5, -10);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range because the specified range is illegal",
        false, actual);
    }
    
    // test to check if a specified range where the lower boundary is equal to the range's lower boundary returns the corect output
    @Test
    public void intersectLowerBoundEqual() {
    	boolean actual = exampleRangePositive.intersects(5, 10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range where the lower boundary is equal to the range's lower boundary, but the upper boundary is way beyond the range's upper boundary returns the corect output. 
    @Test
    public void intersectLowerBoundEqualUpperBoundBeyond() {
    	boolean actual = exampleRangePositive.intersects(5, 100);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range where the upper boundary is equal to the range's upper boundary returns the corect output.
    @Test
    public void intersectUpperBoundEqual() {
    	boolean actual = exampleRangePositive.intersects(10, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range where the upper boundary is equal to the range's upper boundary, but the lower boundary is way beyond the range's lower boundary returns the corect output.
    @Test
    public void intersectUpperBoundEqualLowerBoundBeyond() {
    	boolean actual = exampleRangePositive.intersects(-100, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range that is equal to the range returns the correct output
    @Test
    public void intersectLowerAndUpperBoundEqual() {
    	boolean actual = exampleRangePositive.intersects(5, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range with a lower boundary that is 0.01 above the range's lower boundary returns the correct output.
    @Test
    public void intersect1AboveLowerBound() {
    	boolean actual = exampleRangePositive.intersects(5.01, 5.05);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range with a lower boundary that is 0.01 below the range's lower boundary returns the correct output.
    @Test
    public void intersect1BelowLowerBound() {
    	boolean actual = exampleRangePositive.intersects(4.99, 5.0);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range with an upper boundary that is 0.01 above the range's upper boundary returns the correct output.
    @Test
    public void intersect1AboveUpperBound() {
    	boolean actual = exampleRangePositive.intersects(19.99, 20.01);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range with an upper boundary that is 0.01 below the range's upper boundary returns the correct output.
    @Test
    public void intersect1BelowUpperBound() {
    	boolean actual = exampleRangePositive.intersects(19.95, 19.99);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // test to check if a specified range with a upper boundary that is 0.01 below the range's lower boundary returns the correct output.
    @Test
    public void intersectBelowLowerBoundNotInRange() {
    	boolean actual = exampleRangePositive.intersects(1, 4.99);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    // test to check if a specified range with a lower boundary that is 0.01 above the range's upper boundary returns the correct output.
    @Test
    public void intersectAboveUpperBoundNotInRange() {
    	boolean actual = exampleRangePositive.intersects(20.01, 25);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
