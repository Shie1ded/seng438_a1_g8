package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTestB {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange1 = new Range(-1, 1);
    	exampleRange2= new Range(-2, 2);
    }

    // *TESTING METHOD: combine*
    // Creates a new range by combining two existing ranges
    // Returns null if both inputs are null
   
    // Test with two real ranges input
    @Test
    public void combineTwoRealRanges() {
        assertEquals("The new range length should be 4",
        4, exampleRange3.combine(exampleRange1, exampleRange2).getLength(), .000000001d);
    }
    
    // Test Real input in range1 and null in range2
    @Test
    public void combineRealRange1Null() {
    	assertEquals("The new range length should be 2",
    	2, exampleRange3.combine(exampleRange1, null).getLength(), .000000001d);
    }
    
    // Test null in range1 and Real input in range2
    @Test
    public void combineNullRealRange2() {
    	assertEquals("The new range length should be 4",
    	4, exampleRange3.combine(null, exampleRange2).getLength(), .000000001d);
    }
    
    // Test null in range1 and null in range2
    @Test
    public void combineTwoNull() {
    	assertNull("The new range should be null",
    			exampleRange3.combine(null, null));
    }

    // *TESTING METHOD: equals*
    // Tests this object for equality with an arbitrary object
    // Returns true if object is an equivalent range and false otherwise
    
    // Arbitrary object is equal to tested object
    @Test
    public void equalsObjectEqual() {
    	Range equalExRange1 = new Range(-1,1);
    	assertTrue("The arbitrary object should be equal to tested object",
    	exampleRange1.equals(equalExRange1));
    }
    
    // Arbitrary object is not equal to tested object
    @Test
    public void equalsObjectNotEqual() {
    	assertFalse("The arbitrary object should not be equal to tested object",
    	exampleRange1.equals(exampleRange2));
    }
    
    // Arbitrary object is null
    @Test
    public void equalsObjectNull() {
    	assertFalse("The arbitrary object is null and should not be equal to tested object",
    	exampleRange1.equals(null));
    }
    
    // *TESTING METHOD: contains*
    // Returns true if the specified value is within the range and false otherwise
    
    // Tested value is within range
    @Test
    public void containsValueWithinRange() {
    	assertTrue("The tested value 0 should be within the Range",
    	exampleRange2.contains(0));
    }
    
    // Tested value is outside and above the range
    @Test
    public void containsValueNotInRangeAbove() {
    	assertFalse("The tested value 5 should not be within the Range",
    	exampleRange2.contains(5));
    }
    
    // Tested value is outside and below the range
    @Test
    public void containsValueNotInRangeBelow() {
    	assertFalse("The tested value -4 should not be within the Range",
    	exampleRange2.contains(-4));
    }
    
    // Boundary Value tests
    // Tested value is 1 below upper bound
    @Test
    public void containsValueOneBelowUpperBound() {
    	assertTrue("The tested value 1 should be within the Range",
    	exampleRange2.contains(1));
    }
    
    // Tested value is on upper bound
    @Test
    public void containsValueOnUpperBound() {
    	assertTrue("The tested value 2 should be within the Range",
    	exampleRange2.contains(2));
    }
    
    // Tested value is 1 above the upper bound
    @Test
    public void containsValueOneAboveUpperBound() {
    	assertFalse("The tested value 3 should not be within the Range",
    	exampleRange2.contains(3));
    }
    
    // Tested value is 1 below lower bound
    @Test
    public void containsValueOneBelowLowerBound() {
    	assertFalse("The tested value -3 should not be within the Range",
    	exampleRange2.contains(-3));
    }
    
    // Tested value is on lower bound
    @Test
    public void containsValueOnLowerBound() {
    	assertTrue("The tested value -2 should be within the Range",
    	exampleRange2.contains(-2));
    }
    
    // Tested value is 1 above the lower bound
    @Test
    public void containsValueOneAboveLowerBound() {
    	assertTrue("The tested value -1 should be within the Range",
    	exampleRange2.contains(-1));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}