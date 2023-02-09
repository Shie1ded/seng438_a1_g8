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
    
    // test to check whether a positive input way above the range returns the closest boundary value   
    @Test
    public void constrainWayAboveRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(10000);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }

    // test to check whether a positive input way below the range returns the closest boundary value   
    @Test
    public void constrainWayBelowRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-10000);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }

    @Test
    public void constrainOneAboveLowerRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-0.99);
        assertEquals("The value within the range that is closest to the specified value should be -0.99",
        -0.99, actualSpecifiedValue, epsilon);
    }
    
    @Test
    public void constrainOneBelowLowerRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-1.01);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }
    
    @Test
    public void constrainEqualToLowerRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(-1);
        assertEquals("The value within the range that is closest to the specified value should be -1",
        -1.0, actualSpecifiedValue, epsilon);
    }
    
    @Test
    public void constrainOneAboveUpperRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(1.01);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }
    
    @Test
    public void constrainOneBelowUpperRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(0.99);
        assertEquals("The value within the range that is closest to the specified value should be 0.99",
        0.99, actualSpecifiedValue, epsilon);
    }
    
    @Test
    public void constrainEqualToUpperRange() {
    	double actualSpecifiedValue = exampleRangePositiveNegative.constrain(1);
        assertEquals("The value within the range that is closest to the specified value should be 1",
        1.0, actualSpecifiedValue, epsilon);
    }

    // TESTING METHOD: INTERSECT
    // Returns true if the range intersects (overlaps) with the specified range, and false otherwise.
    
    @Test
    public void intersectPositiveFullyInRange() {
    	boolean actual = exampleRangePositive.intersects(7, 10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectPositiveNotInRange() {
    	boolean actual = exampleRangePositive.intersects(1, 3);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    @Test
    public void intersectNegativeFullyInRange() {
    	boolean actual = exampleRangeNegative.intersects(-10, -7);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectNegativeNotInRange() {
    	boolean actual = exampleRangeNegative.intersects(-3, -1);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    @Test
    public void intersectPositiveLowerRangeBeyondUpperInRange() {
    	boolean actual = exampleRangePositive.intersects(3, 10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectPositiveUpperRangeBeyondLowerInRange() {
    	boolean actual = exampleRangePositive.intersects(10, 25);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectPositiveSpecifiedRangeBeyond() {
    	boolean actual = exampleRangePositive.intersects(1, 25);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectNegativeLowerRangeBeyondUpperInRange() {
    	boolean actual = exampleRangeNegative.intersects(-25, -10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectNegativeUpperRangeBeyondLowerInRange() {
    	boolean actual = exampleRangeNegative.intersects(-10, -1);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectNegativeSpecifiedRangeBeyond() {
    	boolean actual = exampleRangeNegative.intersects(-25, -1);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectPositiveLowerBoundGreaterThanUpperBound() {
    	boolean actual = exampleRangePositive.intersects(10, 5);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range because the specified range is illegal",
        false, actual);
    }
    
    @Test
    public void intersectNegativeLowerBoundGreaterThanUpperBound() {
    	boolean actual = exampleRangeNegative.intersects(-5, -10);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range because the specified range is illegal",
        false, actual);
    }
    
    @Test
    public void intersectLowerBoundEqual() {
    	boolean actual = exampleRangePositive.intersects(5, 10);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectLowerBoundEqualUpperBoundBeyond() {
    	boolean actual = exampleRangePositive.intersects(5, 100);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectUpperBoundEqual() {
    	boolean actual = exampleRangePositive.intersects(10, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectUpperBoundEqualLowerBoundBeyond() {
    	boolean actual = exampleRangePositive.intersects(-100, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectLowerAndUpperBoundEqual() {
    	boolean actual = exampleRangePositive.intersects(5, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersect1AboveLowerBound() {
    	boolean actual = exampleRangePositive.intersects(5.01, 5.05);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersect1BelowLowerBound() {
    	boolean actual = exampleRangePositive.intersects(4.99, 5.0);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersect1AboveUpperBound() {
    	boolean actual = exampleRangePositive.intersects(19.99, 20.01);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersect1BelowUpperBound() {
    	boolean actual = exampleRangePositive.intersects(19.95, 19.99);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    @Test
    public void intersectBelowLowerBoundNotInRange() {
    	boolean actual = exampleRangePositive.intersects(1, 4.99);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
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
