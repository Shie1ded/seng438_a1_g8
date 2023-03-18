// code written by Jessica Hoang and Daniel Le 
package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTestA4 {
	private Range testRange;
    private Range exampleRangePositiveNegative;
    private Range exampleRangePositive;
    private Range exampleRangeNegative;
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range combineRange;
	private Range combineNAN;


    
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
    	
    	exampleRange1 = new Range(-1, 1);
    	exampleRange2= new Range(-2, 2);
    	
    	combineRange = new Range (0,20);
    	combineNAN = new Range(Double.NaN,Double.NaN);


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
    
    // Arbitrary object upper range is not equal to tested object
    @Test
    public void equalsUpperRangeNotEqual() {
    	Range equalExRange1 = new Range(-1,3);
    	assertFalse("The arbitrary object should not be equal to tested object",
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

    
    // ===================================================================================================================================
    // ASSIGNMENT 3 - WHITE BOX TEST CASES ARE BELOW
    
    // TESTING METHOD: INTERSECTS
    // returns true if the value specified is within the range

    // test an input that is within the range (true)
    @Test
    public void intersectsRangeTrue() {
    	Range intersectRange = new Range(10,15);
    	boolean actual = exampleRangePositive.intersects(intersectRange);
        assertEquals("The range specified range is within the range.",
        		true, actual);
    }
    
    // test an input that is not within the range (false)
    @Test
    public void intersectsRangeFalse() {
    	Range intersectRange = new Range(25,30);
    	boolean actual = exampleRangePositive.intersects(intersectRange);
        assertEquals("The range specified range is not within the range.",
        		false, actual);
    }
    
    // TESTING METHOD: SCALE
    // returns a new range that has been scaled by a specified value
    
    // test a real double value 
    @Test
    public void scaleDoubleTheRange() {
    	Range actual = Range.scale(exampleRangePositive, 2);
    	Range expected = new Range(10, 40);
        assertEquals("The range after being scaled by 2, should have a lower bound multiplied by 2 and upper bound multiplied by 2",
        		expected, actual);
    }
    
    // test negative inputs
    @Test (expected = IllegalArgumentException.class)
    public void scaleNegativeInput() {
    	Range.scale(exampleRangePositive, -2);
    }
    
    // TESTING METHOD: SHIFT
    // returns a new range that has been moved left or right by a specific value

    // test shifting the range by a positive value - moving to the right 
    @Test
    public void shiftPositive() {
    	Range actual = Range.shift(exampleRangePositive, 10);
    	Range expected = new Range(15, 30);
        assertEquals("The range after being shifted by positive 10, should have a lower bound + 10 and upper bound + 10",
        		expected, actual);
    }

    // test shifting the range by a positive value - moving to the left 
    @Test
    public void shiftNegative () {
    	Range actual = Range.shift(exampleRangePositive, -10, true);
    	Range expected = new Range(-5, 10);
        assertEquals("The range after being shifted by negative 10, should have a lower bound - 10 and upper bound - 10",
        		expected, actual);
    }
    
    // test shifting the range by a positive value, while allowing to shift passed 0 
    @Test
    public void shiftPositiveBooleanAllowZeroCrossing() {
    	Range actual = Range.shift(exampleRangeNegative, 10, true);
    	Range expected = new Range(-10, 5);
        assertEquals("The range after being shifted by positive 10, should have a lower bound + 10 and upper bound + 10",
        		expected, actual);
    }

    // test shifting the range by a negative value, while allowing to shift passed 0
    @Test
    public void shiftNegativeBooleanAllowZeroCrossing() {
    	Range actual = Range.shift(exampleRangePositive, -10, true);
    	Range expected = new Range(-5, 10);
        assertEquals("The range after being shifted by negative 10, should have a lower bound - 10 and upper bound - 10",
        		expected, actual);
    }
    
    // test shifting the range by a positive value, while not allowing to shift passed 0
    @Test
    public void shiftPositiveBooleanDoesNotAllowZeroCrossing() {
    	Range actual = Range.shift(exampleRangeNegative, 10, false);
    	Range expected = new Range(-10, 0);
        assertEquals("The range after being shifted by positive 10 but with no zero crossing, should have an upper range of 0 since we cannot shift pass 0.",
        		expected, actual);
    }

    // test shifting the range by a negative value, while not allowing to shift passed 0
    @Test
    public void shiftNegativeBooleanDoesNotAllowZeroCrossing() {
    	Range actual = Range.shift(exampleRangePositive, -10, false);
    	Range expected = new Range(0, 10);
        assertEquals("The range after being shifted by negative 10 but with no zero crossing, should have an lower range of 0 since we cannot shift pass 0.",
        		expected, actual);
    }
    
    // test shifting while the range is 0 and we cannot move pass 0
    @Test
    public void shiftNegativeOriginalBoundary0() {
    	Range exampleRange5 = new Range(0, 0);

    	Range actual = Range.shift(exampleRange5, 30, false);
    	Range expected = new Range(30, 30);
        assertEquals("The range after being shifted by 30 but with no zero crossing, should have a range of just 30, since the original range is 0.",
        		expected, actual);
    }
    
    // TESTING METHOD: EXPANDTOINCLUDE
    // returns a new range that has been expanded to include a specific value
    
    // testing a regular set of positive inputs where the included value is not in the range
    @Test
    public void expandToIncludeNotNullRangePositive() {
    	Range actual = Range.expandToInclude(exampleRangePositive, 35);
    	Range expected = new Range(5, 35);
        assertEquals("The range after adding a specified value above the upper bound should have an upper bound value of the specified value",
        		expected, actual);
    }
    
    // testing a regular set of negative inputs where the included value is not in the range
    @Test
    public void expandToIncludeNotNullRangeNegative() {
    	Range actual = Range.expandToInclude(exampleRangePositive, -10);
    	Range expected = new Range(-10, 20);
        assertEquals("The range after adding a specified value below the lower bound should have lower bound value of the specified value",
        		expected, actual);
    }
    
    // testing a range that have a null value  
    @Test
    public void expandToIncludeNullRange() {
    	Range actual = Range.expandToInclude(null, 10);
    	Range expected = new Range(10, 10);
        assertEquals("The range after adding the specified value to a null range, should have an upper and lower bound value including just the specified value",
        		expected, actual);
    }
    
    // testing a regular set of inputs where the included value is within the range
    @Test
    public void expandToIncludeValueWithinRange() {
    	Range actual = Range.expandToInclude(exampleRangePositive, 15);
    	Range expected = new Range(5, 20);
        assertEquals("The range after adding the specified value that is within the range, should return just the range since it's already in the range",
        		expected, actual);
    }
    
    // TESTING METHOD: EXPAND
    // returns a new range that has been expanded by a specific margin value

    // testing inputs that are less than 100% 
    @Test
    public void expand50PercentBOTH() {
    	Range actual = Range.expand(exampleRangePositive, 0.5, 0.5);
    	Range expected = new Range(-2.5, 27.5);
        assertEquals("The range after expanding the upper and lower margin by 50% should be 50% multiplied by the length of the range (15) and added to the upper range and subtracted by the lower range",
        		expected, actual);
    }
    
    // testing inputs that are greater than 100% 
    @Test
    public void expand150PercentBOTH() {
    	Range actual = Range.expand(exampleRangePositive, 1.5, 1.5);
    	Range expected = new Range(-17.5, 42.5);
        assertEquals("The range after expanding the upper and lower margin by 150% should be 150% multiplied by the length of the range (15) and added to the upper range and subtracted by the lower range",
        		expected, actual);
    }
    
    // testing inputs with the lower bound less than 100 and the upper bound 0 
    @Test
    public void expand50PercentLower() {
    	Range actual = Range.expand(exampleRangePositive, 0.5, 0);
    	Range expected = new Range(-2.5, 20);
        assertEquals("The range after expanding the lower margin by 50% should be 50% multiplied by the length of the range (15) and subtracted by the lower range, the upper range does not change",
        		expected, actual);
    }
    
    // testing inputs with the lower bound is 0 and the upper bound is less than 100 
    @Test
    public void expand50PercentUpper() {
    	Range actual = Range.expand(exampleRangePositive, 0, 0.5);
    	Range expected = new Range(5, 27.5);
        assertEquals("The range after expanding the lower margin by 50% should be 50% multiplied by the length of the range (15) and added to the upper range, the lower range does not change",
        		expected, actual);
    }
    
    // testing an exception checker where the range has a lower bound less than the upper bound
    @Test (expected = IllegalArgumentException.class)
    public void getLowerUpperBoundLowerBiggerThanUpper() {
    	Range intersectRange = new Range(10,5);
    	boolean actual = exampleRangePositive.intersects(intersectRange);
    }   
    
    // TESTING METHOD: COMBINEIGNORINGNAN
    // returns a new range that spans both range1 and range2, while ignoring Double.NaN values

    // testing combining a null range1 
    @Test
    public void combineFirstNULLIsNotNAN() {
    	Range actual = Range.combineIgnoringNaN(null, combineRange);
    	Range expected = new Range(0,20);
        assertEquals("The range after being combined with the first value being null should return the range of the second value",
        		expected, actual);
    }    
    
    // testing combining a null range2
    @Test
    public void combineSecondNULLIsNotNAN() {
		Range actual = Range.combineIgnoringNaN(combineRange, null);
		Range expected = new Range(0,20);
	    assertEquals("The range after being combined with the second value being null should return the range of the first value",
	    		expected, actual);
    }
    
    // testing combining a both null ranges 
    @Test
    public void combineBothNULLIsNotNAN() {
		Range actual = Range.combineIgnoringNaN(null, null);
		Range expected = null;
	    assertEquals("The range after two nulls are combined should return a null",
	    		expected, actual);
    }
    
    // testing combining two regular ranges 
    @Test
    public void combineNotNULLIsNotNAN() {
		Range actual = Range.combineIgnoringNaN(combineRange, exampleRangeNegative);
		Range expected = new Range(-20,20);
	    assertEquals("The range after two ranges are combined should return a new range with the minumum lower bound and the maximum upper bound between the two",
	    		expected, actual);
    }
    
    // testing combining a null range 1 and a range 2 that has both bounds of Double.NaN
    @Test
    public void combineFirstNULLIsNAN() {
    	Range actual = Range.combineIgnoringNaN(null, combineNAN);
        assertEquals("The range after being combined with Range that is not-a-number should return null",
        		null, actual);
    }
    
    // testing combining both ranges with both bounds of Double.NaN
    @Test
    public void combineBothIsNAN() {
    	Range actual = Range.combineIgnoringNaN(combineNAN, combineNAN);
        assertEquals("The NaN range after being combined with Range that is not-a-number should return null",
        		null, actual);
    }
    
    // testing combining a null range 1 and a range 2 that has a lower bound of Double.NaN and a regular upper bound
    @Test
    public void combineRangeLowerBoundNaNNull() {
    	Range combineNaN1 = new Range(Double.NaN, 5);
    	double actual = Range.combineIgnoringNaN(null, combineNaN1).getUpperBound();
    	double expected = new Range(Double.NaN, 5).getUpperBound();
    	assertEquals("The range after being combined with Range that is not-a-number should return Range(NaN, 5) since NaN is ignored.",
    			expected, actual, epsilon);
    }
    
    
    // testing combining a null range 2 and a range 1 that has both bounds of Double.NaN
    @Test
    public void combineSecondNULLIsNAN() {
    	Range actual = Range.combineIgnoringNaN(combineNAN, null);
        assertEquals("The range after being combined with Range that is not-a-number should return null",
        		null, actual);
    }
    
    
    // testing combining ranges that both have a lower bound of Double.NaN and a regular upper bound    
    @Test
    public void combineLowerBoundIsNAN() {
    	Range combineNaN1 = new Range(Double.NaN, 5.0000000000000000000000000000000000001);
    	Range combineNaN2 = new Range(Double.NaN, 10.000000000000000000000000000000000001);

    	double actual = Range.combineIgnoringNaN(combineNaN1, combineNaN2).getUpperBound();
    	double expected = new Range(Double.NaN, 10).getUpperBound();

        assertEquals("The range after being combined with Range that has a lower bound not-a-number should return Range(NaN, 10) since NaN is ignored.",
        		expected, actual, epsilon);
    }
  
    
    // testing combining a regular range 1 and a range 2 that has an upper bound of Double.NaN and a regular lower bound
    @Test
    public void combineIsNANMax() {
    	Range combineNaN1 = new Range(5, 15);
    	Range combineNaN2 = new Range(10, Double.NaN);

    	Range actual = Range.combineIgnoringNaN(combineNaN1, combineNaN2);
    	Range expected = new Range(5, 15);

        assertEquals("The range after being combined with Range that has an upper range of NaN should return Range(5, 15) since NaN is ignored.",
        		expected, actual);
    }
    
    // testing combining a regular range 1 and a range 2 that has a lower bound of Double.NaN and a regular upper bound
    @Test
    public void combineIsNANMin() {
    	Range combineNaN1 = new Range(5, 15);
    	Range combineNaN2 = new Range(Double.NaN, 15);

    	Range actual = Range.combineIgnoringNaN(combineNaN1, combineNaN2);
    	Range expected = new Range(5, 15);

        assertEquals("The range after being combined with Range that has an upper range of NaN should return Range(5, 15) since NaN is ignored.",
        		expected, actual);
    }
    
    // TESTING METHOD: GETCENTRALVALUE
    // Returns the central value for the range
    
    @Test
    public void getCentralValue() {
    	double actual = exampleRangePositive.getCentralValue();
    	double expected = 12.5;

        assertEquals("The central value within exampleRangePositive should be the middle value of 5 and 20.",
        		expected, actual, epsilon);
    }    
    
    // TESTING METHOD: HASHCODE
    // Returns a hash code
    
    @Test
    public void hashCodeIsInt() {
    	assertTrue("The returned hashcode should be an int",
    			exampleRange1.hashCode() != Double.NaN);
    }
    
    // TESTING METHOD: TOSTRING
    // Returns a string
    
    @Test
    public void toStringTest() {
    	String actual = exampleRange1.toString();
    	String expected = "Range[" + "-1.0" + "," + "1.0" + "]";
    	assertEquals("should take the range and convert it to a string",expected, actual);
    }
    
    // ===================================================================================================================================
    // ASSIGNMENT 4 - MUTATION TEST CASES ARE BELOW

    // TEST METHOD: CONSTRAIN 
	// MUTATION TEST: first if statement, negated upper field 
    @Test
    public void constrainNegated() {
    	testRange = new Range(-15,-10);
    	double actual = testRange.constrain(-7);
    	assertEquals("The value within the range that is closest to the specified value should be",
    			-10, actual, epsilon);
    }
    
    // MUTATION TEST: second if statement, negated lower field 
	@Test
	public void constrainNegated2() {
		testRange = new Range(10,15);
	  	double actual = testRange.constrain(7);
	  	assertEquals("The value within the range that is closest to the specified value should be",
	  			10, actual, epsilon);
	}
	
	// MUTATION TESTING: hash code with exact value
	@Test
	public void hashCodeTest() {
		testRange = new Range(1, 5);
		int actual = testRange.hashCode();
		assertEquals("The returned hashcode should be an int", 2118385664, actual);
	}

	// MUTATION TESTING: Null value 
	@Test (expected = IllegalArgumentException.class)
	public void expandNull() {
		Range.expand(null, 0, 0.5); // trying to expand the null range
	}

	// MUTATION TESTING: Null value 
	@Test (expected = IllegalArgumentException.class)
	public void toStringTestEmpty() {
	  	Range testRange = new Range(-3, -10);
	}
	    
	// MUTATION TESTING: Null value 
	@Test (expected = IllegalArgumentException.class)
	public void shiftNullRange() {
	 	Range.shift(null, 0, true);
	}
	    
	// MUTATION TESTING: Null value 
	@Test (expected = IllegalArgumentException.class)
	public void scaleNullRange() {
	  	Range.scale(null, 0);
	}
	
	// MUTATION TESTING: test when lower < upper
	@Test
	public void expandLowerGreaterThanUpper() {
		Range actual = Range.expand(exampleRange1, -0.9, -0.9);
		Range expected = new Range(0, 0);
		assertEquals("The range should be increased", expected, actual);
	}

	// MUTATION TESTING: remove conditional, change equalities, negate
	@Test
	public void expandZero() {
		Range actual = Range.expand(exampleRangePositive, 0, 0);
		Range expected = new Range(5, 20);
		assertEquals("The range should be the same", expected, actual);
	}

	// MUTATION TESTING: substitute 0 with 1
    @Test
    public void scaleSubstitute1() {
    	Range testRange = new Range(-1,1);
    	Range actual = Range.scale(testRange, 0);
    	Range expected = new Range(0, 0);
        assertEquals("The range after being scaled by 0, should have a lower bound multiplied by 0 and upper bound multiplied by 0",
        		expected, actual);
    }
    
    // MUTATION TESTING
  	@Test
  	public void combineNegativeFirstNull() {
  		Range actual = Range.combine(exampleRangeNegative, null); 
  		assertEquals("The combined range should be the same", exampleRangeNegative, actual);
  	}

  	// MUTATION TESTING
  	@Test
  	public void combineNegativeSecondNull() {
  		Range actual = Range.combine(null, exampleRangeNegative); 
  		assertEquals("The combined range should be the same", exampleRangeNegative, actual);
  	}
  	
    // MUTATION TESTING: 
    @Test
    public void intersectLowerBoundEqualUpperBound() {
    	Range testRange = new Range(5, 10);
    	boolean actual = testRange.intersects(10, 9);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    // MUTATION TESTING: 
    @Test
    public void intersectJustOutsideRange() {
    	Range testRange = new Range(5, 10);
    	boolean actual = testRange.intersects(11, 11);
        assertEquals("The range DOES NOT intersect (overlap) with the specified range",
        false, actual);
    }
    
    // MUTATION TESTING: remove the conditional for the lower boundary
	@Test
	public void equalsRemovedConditionalLower() {
		Range testRange = new Range(-1,1);
		Range expectedRange = new Range(-5,1);
		assertFalse("The arbitrary object should be not be equal to tested object",
				testRange.equals(expectedRange));
	}
	
	// MUTATION TESTING: change condition for the lower boundary to equal to less or equal 
	@Test
	public void equalstoLessOrEqualLower() {
		Range testRange = new Range(-1,1);
		Range expectedRange = new Range(0,1);
		assertFalse("The arbitrary object should be not be equal to tested object",
				testRange.equals(expectedRange));
	}
	
	// MUTATION TESTING: change condition for the lower to greater or equal 
	@Test
	public void equalstoGreaterOrEqualLower() {
		Range testRange = new Range(-1,1);
		Range expectedRange = new Range(-2,1);
		assertFalse("The arbitrary object should be not be equal to tested object",
				testRange.equals(expectedRange));
	}
	
	// MUTATION TESTING: change condition for the upper to greater or equal
	@Test
	public void equalstoGreaterOrEqualUpper() {
		Range testRange = new Range(-1,1);
		Range expectedRange = new Range(-1,0);
		assertFalse("The arbitrary object should be not be equal to tested object",
				testRange.equals(expectedRange));
	}

    // MUTATION TESTING: test to check if a range equal to the upper boundary of the range returns the correct output.
    @Test
    public void intersectUpperBound() {
    	boolean actual = exampleRangePositive.intersects(20, 20);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }
    
    // MUTATION TESTING: test to check if a range equal to the lower boundary of the range returns the correct output.
    @Test
    public void intersectLowerBound() {
    	boolean actual = exampleRangePositive.intersects(5, 5);
        assertEquals("The range DOES intersect (overlap) with the specified range",
        true, actual);
    }

	
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
