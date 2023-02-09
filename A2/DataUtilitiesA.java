//Code written by Ayodeji Osho
//Test written for calculateColumnTotal and calculateRowTotal methods in DataUtilities
package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

public class DataUtilitiesA extends DataUtilities {
	
    double epsilon ;
    Mockery mockingContext;
    Values2D values;
	
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	epsilon = .000000001d;
    	
    	//The data table being mocked
    	//[[5.9,7.0,2.7] [3.2,8.5,12.2], [4.7,12.3,8.6], [6.8,4.2,16.5]]
        
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
                will(returnValue(8.5));
                
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
    }
    
//Testing the functionalities of the method calculateColumnTotal
    //data table = [[5.9,7.0,2.7] [3.2,8.5,12.2], [4.7,12.3,8.6], [6.8,4.2,16.5]]
    
    
    //Column total for data table at column index 1
    @Test 
    public void calculateColumnTotalForTwoValues() {
		double actual = DataUtilities.calculateColumnTotal(values, 1);
		double expected =32.0;
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

    //Boundary Testing - Null Value2D Object    
    @Test(expected = java.lang.NullPointerException.class)
    public void nullDataTableForColumnTotal() {
        DataUtilities.calculateColumnTotal(null, 0); 
    }

    
    
    
//Testing the functionalities of the method calculateRowTotal
    //data table = [[5.9,7.0,2.7] [3.2,8.5,12.2], [4.7,12.3,8.6], [6.8,4.2,16.5]]
    
    //Row total for data table at row index 1    
    @Test 
    public void calculateRowTotalForTwoValues() {
		double actual = DataUtilities.calculateRowTotal(values, 1);
		double expected =23.9;
        assertEquals(expected, actual, epsilon);
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
    
    //Boundary Testing - Null Value2D Object
    @Test(expected = java.lang.NullPointerException.class)
    public void nullDataTableForRowTotal() {
        DataUtilities.calculateRowTotal(null, 0); 
    }
    
  
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
