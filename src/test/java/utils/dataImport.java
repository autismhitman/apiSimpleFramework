package utils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import apiframework.BaseTest;

public class dataImport extends BaseTest{
	
	
	@DataProvider(name="getData")
	public Object[][] fetchData(Method m){
		
	//	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//src//test//resources//RoughExcel.xlsx");
		
		String sheetName= "TestData";
		
		String testName=  m.getName();//AddCustomerTest OpenAccountTest
		
		int totalRows = xls.getRowCount(sheetName);
		System.out.println("Total Rows : " + totalRows);
		
		 int dataStartRow =1 ;
		 for ( dataStartRow = 1; dataStartRow<=totalRows; dataStartRow++ ) {
			 
			 if(testName.equalsIgnoreCase(xls.getCellData(sheetName, 0, dataStartRow))) 
				break;
			  
		 }
		 
		 System.out.println("test case name is at :" + dataStartRow);
		 
		 int testCaseStartRow= dataStartRow+2;
		 
		 int totalRowsTestCase= 0;
		 while(xls.getCellData(sheetName, 0, testCaseStartRow+totalRowsTestCase)!="") {
			 totalRowsTestCase++;
		 }
		 System.out.println("Data rows are: " + totalRowsTestCase);
		 
		 int totalColsTestCase= 0;
		 int testColumnName = dataStartRow+1;
		 while(xls.getCellData(sheetName, totalColsTestCase, testColumnName)!="") {
			 totalColsTestCase++;
		 }
		 System.out.println("Data rows are: " + totalColsTestCase);
		 
		// Object[][] data = new Object[totalRowsTestCase][totalColsTestCase];
		 
		 
		 
		 Object[][] data = new Object[totalRowsTestCase][1];
		 
		 int i= 0;
		 for( int rows = testCaseStartRow; rows<( testCaseStartRow+totalRowsTestCase); rows++) {
			 
			 Hashtable<String, String> table = new Hashtable<>();
			 
			 for ( int cols = 0; cols< totalColsTestCase;  cols++) {
				 
				// System.out.print(xls.getCellData(sheetName, cols, rows)+" ");
				// data[rows-testCaseStartRow][cols] = xls.getCellData(sheetName, cols, rows);
				 
				 String testData = xls.getCellData(sheetName, cols, rows);
				 String colNames = xls.getCellData(sheetName, cols, testColumnName );
				 
				 table.put(colNames, testData);
			 }
			 data[i][0]  = table;
			 i++;
		 }

		
		return data;
	} 
	 
}


//Simple direct dataprovider
/*@DataProvider(name="getData")
public Object[][] getData(){
	   
	   Object[][] data = new Object[1][4];
	   
	   data[0][0] = "Patrik@email.com";
	   data[0][1] ="Patrik";
	   data[0][2] = "This is a post request";
	   data[0][3] ="10 street";
	   return data;
}
*/

//from excel on the same test class
/*
@DataProvider(name="getData")
public Object[][] getData(){
	   
	    String sheetName = "TestCases";
	    int rows = xls.getRowCount(sheetName);
	    int cols = xls.getColumnCount(sheetName);
	    
	    
	    
	   Object[][] data = new Object[rows-1][cols];
    
	   data[0][0] = xls.getCellData(sheetName, 0, 2);
	   data[0][1] = xls.getCellData(sheetName, 1, 2);
	   data[0][2] =  xls.getCellData(sheetName, 2, 2);
	   data[0][3] = xls.getCellData(sheetName, 3, 2);
	   
	   return data;
}
*/

/*
@DataProvider(name="getData")
public Object[][] fetchData(Method m){
	
     String sheetName = m.getName();
     
     
	 int rows = xls.getRowCount(sheetName);
	 int cols = xls.getColumnCount(sheetName);
	 System.out.println("Total rows: " + rows + "Total cols: " + cols);
	
	 Object[][] data = new Object[rows-1][cols] ;
	 
	 for( int rowNum=2; rowNum<=rows; rowNum++) {
		 
		 for( int colNum = 0; colNum< cols; colNum++) {
			 
			  data[rowNum-2][colNum] = xls.getCellData(sheetName, colNum, rowNum);
		 }
	 }
	
	
	return data;
} 
*/