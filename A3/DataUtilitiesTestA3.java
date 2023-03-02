//Code written by Ayodeji Osho and Ayal 

//Test written for DataUtilities Class
package org.jfree.data;

import static org.junit.Assert.*;


import java.security.InvalidParameterException;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;


public class DataUtilitiesTestA3 extends DataUtilities {

    double epsilon ;
    Mockery mockingContext;
    Values2D values;
    
    Mockery mockingContext3;
    Values2D values3;
    
    Mockery mockingContext4;
    Values2D values4;
    
    //
    private double[] data2 = {1.3, 4.6, 9.66, 8.5, 65.8, -87.6};
    private double[] dataN2 = {};
    private double[][] data2D2 = {{1.2, 3.4, 12.5093, 8832.58, 5.87, 56.90},
    							 {2.14, 3.1415, 9.87, 6.3, 9.1, 50.3, 48.3},
    							 {4.3, 47.66, 93729.23, 1.534932, 9.8, 7.32, 5.55}};
    private double[][] data2DN2 = {{},{},{}};
    private Number[] tester2;
    private Number[] testerN2;
    private Number[][] tester2D2;
    private Number[][] tester2DN2;
    
    Mockery mockingCnxt2;
    KeyedValues keyed_values2;
    KeyedValues keyed_valuesN2;
    DefaultKeyedValues expected2;
	
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	epsilon = .000000001d;
    	
    	//The data table being mocked
    	//[[5.9,7.0,2.7] [3.2,null,12.2], [4.7,12.3,8.6], [6.8,4.2,16.5]]
        
    	//This data table will be used for both calculateColumnTotal and calculateRowTotal
    	
    	mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	
            	//3 Columns and 4 Rows
                one(values).getColumnCount();
                will(returnValue(3));
                
                one(values).getRowCount();
                will(returnValue(4));
         
                //Invalid Negative and Positive Rows and Columns are Mocked             
                one(values).getValue(-1, -1);
                will(returnValue(0.0));   
                
                one(values).getValue(-1, 0);
                will(returnValue(0.0));
                
                one(values).getValue(-1, 1);
                will(returnValue(0.0));
                
                one(values).getValue(-1, 2);
                will(returnValue(0.0));
                
                one(values).getValue(-1, 7);
                will(returnValue(0.0));

                
                
                one(values).getValue(0, -1);
                will(returnValue(0.0));
                
                one(values).getValue(0, 0);
                will(returnValue(5.9));
                
                one(values).getValue(0, 1);
                will(returnValue(7.0));
                
                one(values).getValue(0, 2);
                will(returnValue(2.7));
                
                one(values).getValue(0, 7);
                will(returnValue(0.0));                
                
                
                one(values).getValue(1, -1);
                will(returnValue(0.0));
  
                one(values).getValue(1, 0);
                will(returnValue(3.2));
                
                one(values).getValue(1, 1);
                will(returnValue(null));
                
                one(values).getValue(1, 2);
                will(returnValue(12.2));
                
                one(values).getValue(1, 7);
                will(returnValue(0.0));                
               
                
                
                one(values).getValue(2, -1);
                will(returnValue(0.0));
                
                one(values).getValue(2, 0);
                will(returnValue(4.7));
                
                one(values).getValue(2, 1);
                will(returnValue(12.3));
                
                one(values).getValue(2, 2);
                will(returnValue(8.6));
                
                one(values).getValue(2, 7);
                will(returnValue(0.0));
                
                
                
                one(values).getValue(3, -1);
                will(returnValue(0.0));
                
                one(values).getValue(3, 0);
                will(returnValue(6.8));
                
                one(values).getValue(3, 1);
                will(returnValue(4.2));
                
                one(values).getValue(3, 2);
                will(returnValue(16.5));   
                
                one(values).getValue(3, 7);
                will(returnValue(0.0));

                
                one(values).getValue(7, -1);
                will(returnValue(0.0));
                
                one(values).getValue(7, 0);
                will(returnValue(0.0));
                
                one(values).getValue(7, 1);
                will(returnValue(0.0));
                
                one(values).getValue(7, 2);
                will(returnValue(0.0));
                
                one(values).getValue(7, 7);
                will(returnValue(0.0));
            }
        });
        
        tester2 = DataUtilities.createNumberArray(data2);
    	testerN2 = DataUtilities.createNumberArray(dataN2);
    	
    	tester2D2 = DataUtilities.createNumberArray2D(data2D2);
    	tester2DN2 = DataUtilities.createNumberArray2D(data2DN2);
    	
    	//the table to be mocked is:
    	//{9.9999, 6.6606, 4.30, 16.87, 888.9900, 210.6453}, 
    	//{5.9, 56, 490, 80.2, 29.7001, 1.1111}, {1.24, 3.4151, 8.75, 8.01, 6.0412, 99.9300}

    	mockingCnxt2 = new Mockery();
		keyed_values2 = mockingCnxt2.mock(KeyedValues.class);
		mockingCnxt2.checking(new Expectations() {
			{  
				allowing(keyed_values2).getItemCount();
				will(returnValue(4));
          	
				allowing(keyed_values2).getValue(0);
				will(returnValue(2));
				allowing(keyed_values2).getKey(0);
				will(returnValue(0));
          	
				allowing(keyed_values2).getValue(1);
				will(returnValue(2));
	          	allowing(keyed_values2).getKey(1);
	          	will(returnValue(1));
          	
				allowing(keyed_values2).getValue(2);
				will(returnValue(2));
	          	allowing(keyed_values2).getKey(2);
	          	will(returnValue(2));
          	
				allowing(keyed_values2).getValue(3);
				will(returnValue(2));				
	          	allowing(keyed_values2).getKey(3);
	          	will(returnValue(3)); 
	          	
          }
      });
		mockingCnxt2 = new Mockery();
		keyed_valuesN2 = mockingCnxt2.mock(KeyedValues.class);
		mockingCnxt2.checking(new Expectations() {
			{  
				allowing(keyed_valuesN2).getItemCount();
				will(returnValue(0));
				allowing(keyed_valuesN2).getValue(0);
				will(returnValue(null));				
	          	allowing(keyed_valuesN2).getKey(0);
	          	will(returnValue(null)); 
			}
		});
		
		
		
		mockingContext3 = new Mockery();
	    values3 = mockingContext3.mock(Values2D.class);
	    mockingContext3.checking(new Expectations() {
	        {

	            one(values3).getColumnCount();
	            will(returnValue(-1));
	            
	            one(values3).getRowCount();
	            will(returnValue(2));
	            
	            one(values3).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values3).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
        
    }
    
//Testing the functionalities of the method calculateColumnTotal
    //data table = [[5.9,7.0,2.7] [3.2,null,12.2], [4.7,12.3,8.6], [6.8,4.2,16.5]]
    
    
    //Column total for data table at column index 1
    @Test 
    public void calculateTheColumnTotal() {
		double actual = DataUtilities.calculateColumnTotal(values, 1);
		double expected =23.5;
        assertEquals(expected, actual, epsilon);
    }

    
    //Column total for data table at column index 2 that included valid Rows
    @Test 
    public void calculateColumnTotalValidRow() {
   	 	int[] validRows = new int[]{1,2}; 
		double actual = DataUtilities.calculateColumnTotal(values, 2, validRows);
		double expected =20.8;
		assertEquals(expected, actual, epsilon);
    }    
    
    
    //Column total for data table at column index 1 that included invalid Rows
    @Test
    public void calculateColumnTotalInvalidRow() {
   	 	int[] invalidRows = new int[]{1,2,3,5}; 
		double actual = DataUtilities.calculateColumnTotal(values, 1, invalidRows);
    	double expected = 16.5;
	   	assertEquals(expected, actual, epsilon);

    }
    
    
    //Boundary Testing
    //Column total for data table at invalid column index -1
    @Test
    public void calculateColumnTotalForNegativeInvalidColumnIndex() {
    	double actual = DataUtilities.calculateColumnTotal(values, -1);
    	double expected = 0.0;
	   	assertEquals(expected, actual, epsilon);

    }
    
    //Boundary Testing
    //Column total for data table at invalid column index 7
    @Test 
    public void calculateColumnTotalForPositiveInvalidColumnIndex() {
    	double actual = DataUtilities.calculateColumnTotal(values, 7);
    	double expected = 0.0;
	   	assertEquals(expected, actual, epsilon);
    }


        
    
//Testing the functionalities of the method calculateRowTotal
    //data table = [[5.9,7.0,2.7] [3.2,null,12.2], [4.7,12.3,8.6], [6.8,4.2,16.5]]
    
    //Row total for data table at row index 1    
    @Test 
    public void calculateTheRowTotal() {
		double actual = DataUtilities.calculateRowTotal(values, 1);
		double expected =15.4;
        assertEquals(expected, actual, epsilon);
    }
   
    
  //Row total for data table at row index 1 that included valid column
    @Test 
    public void calculateRowTotalForValidColumn() {
   	 	int[] validColumn = new int[]{1,2,5}; 
		double actual = DataUtilities.calculateRowTotal(values, 1, validColumn);
		double expected =12.2;
        assertEquals(expected, actual, epsilon);
    }
    
    //a == null and b == null
    @Test 
    public void equal_NullA_NullB_Array() {
    	boolean actual = DataUtilities.equal(null, null);
    	boolean expected = true;
        assertEquals(expected, actual);
    }
    
    //a == null and b != null
    @Test 
    public void equal_NullA_ValidB_Array() {
    	double[][] b = new double[10][20];
    	boolean actual = DataUtilities.equal(null, b);
    	boolean expected =false;
        assertEquals(expected, actual);
    }
    
    
    //a != null and b == null
    @Test 
    public void equal_ValidA_NullB_Array() {
    	double[][] a = new double[10][20];
    	
    	boolean actual = DataUtilities.equal(a, null);
    	boolean expected = false;
        assertEquals(expected, actual);
    }
    
    
    // a != null, b != null
    // a and b array have different length
    @Test 
    public void equal_A_and_B_ArrayNotEqualLength() {
    	double[][] a = new double[15][21];
    	double[][] b = new double[10][20];
    	
    	boolean actual = DataUtilities.equal(a, b);
    	boolean expected = false;
        assertEquals(expected, actual);
    }    
    
    
    // a != null, b != null
    // a and b array have same length
    @Test 
    public void equal_A_and_B_ArrayEqualLength() {
    	double[][] a = new double[10][20];
    	double[][] b = new double[10][20];
    	
    	boolean actual = DataUtilities.equal(a, b);
    	boolean expected = true;
        assertEquals(expected, actual);
    } 
    
    
    // a != null, b != null
    // a and b have different value at same index
    @Test 
    public void equal_A_and_B_ArrayDifferentValueAtSameIndex() {
    	double[][] a = new double[1][1];
    	double[][] b = new double[1][1];
    	
    	a[0][0] = 4.4;
    	b[0][0]	= 5.4;
    	
    	boolean actual = DataUtilities.equal(a, b);
    	boolean expected = false;
        assertEquals(expected, actual);
    }    
    
    //Boundary Testing
    //Row total for data table at invalid row index -1
    @Test
    public void calculateRowTotalForNegativeInvalidRowIndex() {
    	double actual = DataUtilities.calculateRowTotal(values, -1);
    	double expected = 0.0;
	   	assertEquals(expected, actual, epsilon);
	   	
    }
    
    //Boundary Testing
    //Row total for data table at invalid row index 7  
    @Test 
    public void calculateRowTotalForPositiveInvalidRowIndex() {
    	double actual = DataUtilities.calculateRowTotal(values, 7);
    	double expected = 0.0;
	   	assertEquals(expected, actual, epsilon);
    }
    
    
    //takes in a double array as input and gives out the same double array as ouput
    @Test 
    public void cloneOfTwoDoubleArrays() {
    	double[][] source = {{1, 2}, null};
    	double[][] actual = DataUtilities.clone(source);
    	double [][] expected = {{1, 2}, null};
    	assertArrayEquals(expected, actual);
    }
    

    //Calculates the row total but the column count is less than 0
    @Test 
    public void calculateRowTotalColCountLessThanZero() {
   	 	int[] validCols = new int[]{0,1}; 
		double actual = DataUtilities.calculateRowTotal(values3, 0, validCols);
		double expected =0.0;
		assertEquals(expected, actual, epsilon);
    }
    
    
    // Ayal Test Cases
    
    
    /*a test case for creating a array of type Number*/
    @Test 
    public void createNewNumberArray() {
        assertArrayEquals("It is a Number", tester2, DataUtilities.createNumberArray(data2));
        assertArrayEquals("It is a Number", testerN2, DataUtilities.createNumberArray(dataN2));
    }
    /*a test case for creating a 2D array of type Number*/
    @Test
    public void createNew2DNumberArray() {
        assertArrayEquals("It is a Number", tester2D2, DataUtilities.createNumberArray2D(data2D2));
        assertArrayEquals("It is a Number", tester2DN2, DataUtilities.createNumberArray2D(data2DN2));
    }
	
    /*a test case to see what happens when we look for the percentages for all the values in the array*/
	@Test (expected = IllegalArgumentException.class)
  	public void getCumulativePercentagesNominal() {
			double e = .01d;
			KeyedValues result2 = DataUtilities.getCumulativePercentages(keyed_values2);
			assertEquals(0.250, (double) result2.getValue(0), e);
			assertEquals(0.500, (double) result2.getValue(1), e);
			assertEquals(0.750, (double) result2.getValue(2), e);
			assertEquals(1.000, (double) result2.getValue(3), e);
	}
	/*a test case to see what happens when we try to access only some parts of the array*/
	@Test (expected = IllegalArgumentException.class)
	public void getCumulativePercentagesSizeMinusOne() {
			double e = .0001d;
			KeyedValues result2 = DataUtilities.getCumulativePercentages(keyed_values2);
			assertEquals(0.250, (double) result2.getValue(0), e);//, .000001d);
			assertEquals(0.500, (double) result2.getValue(1), e);//, .000001d);
			assertEquals(0.750, (double) result2.getValue(2), e);//, .000001d);
	}
	/*A test to see see what happens when the Percentage is less than zero, should fail but passes*/
	@Test (expected = AssertionError.class)
	public void getCumulativePercentageLessThanZeroCount() {      
		for (int loop=0; loop<2;loop++) {
		    KeyedValues result2 = DataUtilities.getCumulativePercentages(keyed_values2);
		    int count = 0;
		    for(int i = 0; i<keyed_values2.getItemCount(); i++) {
		    	Comparable key = Integer.valueOf(i);
		    	int this_value = (result2.getValue(key).intValue())-loop;
		    	if (this_value<0) {
		    		count += 1;
		    	}
		    }
		    assertEquals("Number of element less than 0 in the cumulative percentage list should be zero.", 0, count, .000000001d);
		}
	}
	/*a test to see what happens when we look into a null array*/
	@Test (expected = IllegalArgumentException.class)
	public void getCumulativePercentageInvalidNullArray() {
        KeyedValues result2 = DataUtilities.getCumulativePercentages(keyed_valuesN2);
        assertNull(result2.getValue(null));
	}
    
  
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}