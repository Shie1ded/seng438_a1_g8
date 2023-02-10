package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesB {
	//
    private double[] data = {1.3, 4.6, 9.66, 8.5, 65.8, -87.6};
    private double[][] data2D = {{1.2, 3.4, 12.5093, 8832.58, 5.87, 56.90},
    							 {2.14, 3.1415, 9.87, 6.3, 9.1, 50.3, 48.3},
    							 {4.3, 47.66, 93729.23, 1.534932, 9.8, 7.32, 5.55}};
    private Number[] tester;
    private Number[][] tester2D;
    
    Mockery mockingCnxt;
    KeyedValues keyed_values;
    DefaultKeyedValues expected;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

//    public static java.lang.Number[] createNumberArray(double[] data)
    @Before
    public void setUp() throws Exception { 
    	tester = DataUtilities.createNumberArray(data);

    	tester2D = DataUtilities.createNumberArray2D(data2D);
    	
    	//the table to be mocked is:
    	//{9.9999, 6.6606, 4.30, 16.87, 888.9900, 210.6453}, 
    	//{5.9, 56, 490, 80.2, 29.7001, 1.1111}, {1.24, 3.4151, 8.75, 8.01, 6.0412, 99.9300}

    	mockingCnxt = new Mockery();
		keyed_values = mockingCnxt.mock(KeyedValues.class);
		mockingCnxt.checking(new Expectations() {
			{  
				allowing(keyed_values).getItemCount();
				will(returnValue(4));
          	
				allowing(keyed_values).getValue(0);
				will(returnValue(2));
				allowing(keyed_values).getKey(0);
				will(returnValue(0));
          	
				allowing(keyed_values).getValue(1);
				will(returnValue(2));
	          	allowing(keyed_values).getKey(1);
	          	will(returnValue(1));
          	
				allowing(keyed_values).getValue(2);
				will(returnValue(2));
	          	allowing(keyed_values).getKey(2);
	          	will(returnValue(2));
          	
				allowing(keyed_values).getValue(3);
				will(returnValue(2));				
	          	allowing(keyed_values).getKey(3);
	          	will(returnValue(3)); 
	          	
	    /*this was used to see what happens when we add an end value to the array of value 0*/
//	          	allowing(keyed_values).getValue(4);
//				will(returnValue(2));				
//	          	allowing(keyed_values).getKey(4);
//	          	will(returnValue(0)); 
          }
      });
    }

    /*a test case for creating a array of type Number*/
    @Test
    public void createNewNumberArray() {
        assertArrayEquals("It is a Number", tester, DataUtilities.createNumberArray(data));//, .000001d);
    }
    /*a test case for creating a 2D array of type Number*/
    @Test
    public void createNew2DNumberArray() {
        assertArrayEquals("It is a Number", tester2D, DataUtilities.createNumberArray2D(data2D));//, .000001d);
    }
	
    /*a test case to see what happens when we look for the percentages for all the values in the array*/
	@Test
  	public void getCumulativePercentagesNominal() {
		try {
			double e = .01d;
			KeyedValues result = DataUtilities.getCumulativePercentages(keyed_values);
			assertEquals(0.250, (double) result.getValue(0), e);
			assertEquals(0.500, (double) result.getValue(1), e);
			assertEquals(0.750, (double) result.getValue(2), e);
			assertEquals(1.000, (double) result.getValue(3), e);
		} catch (Exception e) {
			assertSame(InvalidParameterException.class, e);
		}
	}
	/*a test case to see what happens when we try to access only some parts of the array*/
	@Test
	public void getCumulativePercentagesSizeMinusOne() {
		try {
			double e = .0001d;
			KeyedValues result = DataUtilities.getCumulativePercentages(keyed_values);
			assertEquals(0.3333, (double) result.getValue(0), e);//, .000001d);
			assertEquals(0.6667, (double) result.getValue(1), e);//, .000001d);
			assertEquals(1.0, (double) result.getValue(2), e);//, .000001d);
		} catch (Exception e) {
			assertSame(InvalidParameterException.class, e);
		}
	}
	/*A test to see see what happens when the Percentage is less than zero, should fail but passes*/
	@Test
	public void getCumulativePercentageLessThanZeroCount() {      
		try {
		     KeyedValues result = DataUtilities.getCumulativePercentages(keyed_values);	     
		     int count = 0;
		     for(int i = 0; i<2; i++) {
		    	 Comparable key = Integer.valueOf(i);
		    	 int this_value = result.getValue(key).intValue();
		    	 if (this_value<0) {
		    		 count += 1;	 
		    	 }
		     }
		     assertEquals("Number of element less than 0 in the cumulative percentage list should be zero.", 0, count, .000000001d);
		} catch (Exception e) {
			assertSame(InvalidParameterException.class, e);
		}
	}
	/*a test to see what happens when we look into a null array*/
	@Test(expected = IllegalArgumentException.class)
	public void getCumulativePercentageInvalidNullData() {
        KeyedValues dataNull = null; 
        DataUtilities.getCumulativePercentages(dataNull);
	}
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
